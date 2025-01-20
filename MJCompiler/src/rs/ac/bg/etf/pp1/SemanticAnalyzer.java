package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyzer extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());
	
	private boolean errorDetected = false;
	private Obj currProgam;
	private Struct currType;
	private int constant;
	private Struct constType;
	private Struct boolType = Tab.find("bool").getType();
	private Struct setType = Tab.find("set").getType();
	private Obj currMethod;
	private Obj main;
	private boolean hasReturn;
	private int loopCnt = 0;
	int nVars;
	
	/* LOG MESSAGES */
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected  = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public boolean passed() {
		return !errorDetected;
	}
	
	
	/* SEMANTIC PASS CODE */

	@Override
	public void visit(ProgName programName) {
		currProgam = Tab.insert(Obj.Prog, programName.getI1(), Tab.noType);
		Tab.openScope();
	}
	
	@Override
	public void visit(Program program) {
		nVars = Tab.currentScope().getnVars();
		Tab.chainLocalSymbols(currProgam);
		Tab.closeScope();
		currProgam = null;
		
		if(main == null || main.getLevel() > 0)
			report_error("Program nema adekvatnu main metodu", program);
		
	}
	
	
	
	//CONST DECLARATION
	
	@Override
	public void visit(ConstDeclConst constDecl) {
		String constName = constDecl.getI1();
		Obj constObj = Tab.find(constName);
		if(constObj != Tab.noObj) {
            report_error("GRESKA: Dovstruja definicija konstante - " + constName, constDecl);
		}else {
			if(constType.assignableTo(currType)) {
				constObj = Tab.insert(Obj.Con, constName, currType);
				constObj.setAdr(constant);
			} else {
				report_error("GRESKA: Tip konstante - " + constName + " - nije kompatibilan sa tipom podataka", constDecl);
			}
        }
	}
	
	@Override
	public void visit(NumConst numConst) {
		constant = numConst.getN1();
		constType = Tab.intType;
	}
	
	@Override
	public void visit(CharConst charConst) {
		constant = charConst.getC1();
		constType = Tab.charType;
	}
	
	@Override
	public void visit(BoolConst boolConst) {
		constant = boolConst.getB1();
		constType = boolType;
	}
	
	
	
	//VAR DECLARATION
	
	@Override
	public void visit(IdentVarDecl varDecl) {
		String varName = varDecl.getI1();
		Obj varObj = null;
		if(currMethod == null) {
			varObj = Tab.find(varName);
		}
		else {
			varObj = Tab.currentScope().findSymbol(varName);
		}
		if(varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, varName, currType);
            
		}else {
			report_error("GRESKA: Dovstruja definicija varijable - " + varName, varDecl);
        }
	}
	
	@Override
	public void visit(ArrayVarDecl varArray) {
		String arrName = varArray.getI1();
		Obj varObj = null;
		if(currMethod == null) {
			varObj = Tab.find(arrName);
		}
		else {
			varObj = Tab.currentScope().findSymbol(arrName);
		}
		if(varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, arrName, new Struct(Struct.Array, currType));
           
		}else {
			report_error("GRESKA: Dovstruja definicija varijable (niz) - " + arrName, varArray);
        }
	}
	
	
	
	//METHOD DECLARATION
	
	@Override
	public void visit(VoidSignature voidSignature) {
		currMethod = Tab.insert(Obj.Meth, voidSignature.getI1(), Tab.noType);
		Tab.openScope();
		
		if(voidSignature.getI1().equalsIgnoreCase("main"))
			main = currMethod;
	}
	
	@Override
	public void visit(TypeSignature typeSignature) {
		currMethod = Tab.insert(Obj.Meth, typeSignature.getI2(), currType);
		Tab.openScope();
	}
	
	@Override
	public void visit(MethodDecl methodDecl) {	
		Tab.chainLocalSymbols(currMethod);
		Tab.closeScope();
		if (currMethod.getType() != Tab.noType && !hasReturn)
			report_error("GRESKA: Metoda - " + currMethod.getName() + " - nema return iskaz", methodDecl);
		currMethod = null;
		hasReturn = false;
	}
	
	
	
	//FORMAL PARAMETER DECLARATION
	
	@Override
	public void visit(FormParVar formParVar) {
		String varName = formParVar.getI2();
		Obj varObj = null;
		if(currMethod == null) {
			report_error("GRESKA: Semanticka greska {FormParVar}", formParVar);
		}
		else {
			varObj = Tab.currentScope().findSymbol(varName);
		}
		if(varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, varName, currType);
			varObj.setFpPos(1);
			currMethod.setLevel(currMethod.getLevel() + 1);
			
            
		}else {
			report_error("GRESKA: Dovstruja definicija formalnog parametra - " + varName, formParVar);
        }
	}
	
	@Override
	public void visit(FormParArray formParArray) {
		String arrName = formParArray.getI2();
		Obj varObj = null;
		if(currMethod == null) {
			report_error("GRESKA: Semanticka greska {FormParArray}", formParArray);
		}
		else {
			varObj = Tab.currentScope().findSymbol(arrName);
		}
		if(varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, arrName, new Struct(Struct.Array, currType));
			varObj.setFpPos(1);
			currMethod.setLevel(currMethod.getLevel() + 1);
           
		}else {
			report_error("GRESKA: Dovstruja definicija formalnog parametra (niz) - " + arrName, formParArray);
        }
	}
	
	
	
	@Override
	public void visit(Type type) {
		String typeName = type.getI1();
		Obj typeObj = Tab.find(typeName);
		if(typeObj == Tab.noObj) {
            report_error("GRESKA: Nije pronadjen tip podatka - " + typeName, type);
            currType = Tab.noType;
		} else if (typeObj.getKind() != Obj.Type) {
			report_error("GRESKA: Identifikator - " + typeName + " - nije tip podatka", type);
			currType = Tab.noType;
		} else {
//			if(typeObj.getType().equals(setType)) {
//				report_info("Type set ", type);
//			}
			currType = typeObj.getType();
		}
	}
	
	
	// CONTECST CONDITIONS

	//FACTOR
	
	@Override
	public void visit(FactorChar factorChar) {
		factorChar.struct = Tab.charType;
	}
	
	@Override
	public void visit(FactorNum factorNum) {
		factorNum.struct = Tab.intType;
	}
	
	@Override
	public void visit(FactorBool factorBool) {
		factorBool.struct = boolType;
	}
	
	@Override
	public void visit(FactorDesignator factorDesignator) {
		if(factorDesignator.getFactorActPars() instanceof NoActParsFactor)
			factorDesignator.struct = factorDesignator.getDesignator().obj.getType();
		else {
			if (factorDesignator.getDesignator().obj.getKind() != Obj.Meth) {
				report_error("GRESKA: Identifikator - " + factorDesignator.getDesignator().obj.getName() + " - nije metoda", factorDesignator);
				factorDesignator.struct = Tab.noType;
			} else {
				Obj desgObj = factorDesignator.getDesignator().obj;
				
				factorDesignator.struct = desgObj.getType();
				
				List<Struct> formalList = new ArrayList<>();
				for (Obj param : desgObj.getLocalSymbols()) {
					if(param.getKind() == Obj.Var && param.getLevel() == 1 && param.getFpPos() == 1) {
						formalList.add(param.getType());
					}
				}
				ParamsCounter paramsCounter = new ParamsCounter();
				factorDesignator.getFactorActPars().traverseBottomUp(paramsCounter);
				List<Struct> actualList = paramsCounter.finalParams;

				
				try {
					if(formalList.size() != actualList.size()) {
						throw new Exception("GRESKA: Neodgovarajuci broj parametara");
					}
					for(int i = 0; i < formalList.size(); i++) {
						Struct formal = formalList.get(i);
						Struct actual = actualList.get(i);
						if (!actual.assignableTo(formal)) {
							throw new Exception("GRESKA: Neodgovarajuci tip parametara");
						}		
						//report_info("Poziv metode - " + desgObj.getName(), factorDesignator);
					}
				} catch (Exception e) {
					report_error(e.getMessage(), factorDesignator);
				}
			}
		}
	}
	

	@Override
	public void visit(FactorListMinus factor) {
		if (factor.getFactor().struct.equals(Tab.intType)) {
			factor.struct = Tab.intType;
		} else {
			report_error("GRESKA: Negacija vrednosti koja nije tipa int", factor);
			factor.struct = Tab.noType;
		}
		
	}
	
	@Override
	public void visit(NoFactorListMinus factor) {
		factor.struct = factor.getFactor().struct;
	}
	
	@Override
	public void visit(FactorNew factor) {
		Struct expr = factor.getExprList().struct;
		if (expr.equals(Tab.intType)) {
			factor.struct = new Struct(Struct.Array, currType);
		} 
		else {
			report_error("GRESKA: Velicina niza nije tipa int", factor);
			factor.struct = Tab.noType;
		}
	}
	
	@Override
	public void visit(FactorExpr factor) {
		factor.struct = factor.getExprList().struct;
	}
	
	
	
	//DESIGNATOR
	
	@Override
	public void visit(DesignatorIdent designatorIdent) {
		String ident = designatorIdent.getI1();
		Obj obj = Tab.find(ident);
		if (obj == Tab.noObj) {
			report_error("GRESKA: Identifikator - " + ident + " - nije definisan", designatorIdent);
			designatorIdent.obj = Tab.noObj;
		} 
		else if (obj.getKind() != Obj.Var && obj.getKind() != Obj.Con && obj.getKind() != Obj.Meth) {
			report_error("GRESKA: Identifikator - " + ident + " - nije promenljiva ili konstanta", designatorIdent);
			designatorIdent.obj = Tab.noObj;
		}
		else {
			designatorIdent.obj = obj;
		}
	}
	
	@Override
	public void visit(DesignatorArray designatorArray) {
		String arr = designatorArray.getI1();
		Obj obj = Tab.find(arr);
		if (obj == Tab.noObj) {
			report_error("GRESKA: Niz - " + arr + " - nije deklarisan", designatorArray);
			designatorArray.obj = Tab.noObj;
		} else if (obj.getKind() != Obj.Var && obj.getType().getKind() != Struct.Array) {
			report_error("GRESKA: Promenljiva - " + arr + " - nije niz", designatorArray);
			designatorArray.obj = Tab.noObj;
		} 
		else {
			designatorArray.obj = obj;
		}
	}
	
	@Override
	public void visit(DesignatorExpr designatorExpr) {
		Obj obj = designatorExpr.getDesignatorArray().obj;
		if(obj == Tab.noObj) {
			designatorExpr.obj = Tab.noObj;
		} else if(designatorExpr.getExprList().struct.equals(Tab.intType)) {
			designatorExpr.obj = new Obj(Obj.Elem, obj.getName() , obj.getType().getElemType());
			//report_info("Pristup elementu niza - " + designatorExpr.obj.getName() + " Kind: "+ designatorExpr.obj.getKind(), designatorExpr);
		}
		else {
			report_error("GRESKA: Indeks niza nije tipa int", designatorExpr);
            designatorExpr.obj = Tab.noObj;
		}
	}
	

	
	//TERM

	@Override
	public void visit(Term term) {
		term.struct = term.getTermMulFactor().struct;
	}
	
	@Override
	public void visit(MulopTerm mulTerm) {
		Struct term = mulTerm.getTermMulFactor().struct;
		Struct factor = mulTerm.getFactorList().struct;
		if(term.equals(Tab.intType) && factor.equals(Tab.intType))
			mulTerm.struct = Tab.intType;
		else {
			report_error("GRESKA: Obe variable moraju da budu int vrednost (Mulop)", mulTerm);
			mulTerm.struct = Tab.noType;
		}
	}

	@Override
	public void visit(FactorMulopTerm term) {
		term.struct = term.getFactorList().struct;
	}
	
    
	
	//EXPR
	
	@Override
	public void visit(ListExpr listExpr) {
		listExpr.struct = listExpr.getExprAddopTerm().struct;
	}
	
	@Override
	public void visit(AddopExprTerm addopExprTerm) {
		Struct expr = addopExprTerm.getExprAddopTerm().struct;
		Struct term = addopExprTerm.getTerm().struct;
		if(!expr.compatibleWith(term)) {
			report_error("GRESKA: Tipovi nisu kompatibilni", addopExprTerm);
			addopExprTerm.struct = Tab.noType;
			return;
		}
		if (expr.equals(Tab.intType) && term.equals(Tab.intType))
			addopExprTerm.struct = Tab.intType;
		else {
			report_error("GRESKA: Obe variable moraju da budu int vrednost (Addop)", addopExprTerm);
			addopExprTerm.struct = Tab.noType;
		}
	}
	
	@Override
	public void visit(TermAddopExprTerm expr) {
		expr.struct = expr.getTerm().struct;
		
	}
	
	@Override
	public void visit(ExprMap exprMap) {
		Obj desg1 = exprMap.getDesignator().obj;
		Obj desg2 = exprMap.getDesignator1().obj;
		
		if(desg1.getKind() != Obj.Meth) {
			report_error("GRESKA: Levi designator - " + desg1.getName() + " - nije metoda", exprMap);
			exprMap.struct = Tab.noType;
			return;
		}
		
		Obj methodObj = Tab.find(desg1.getName());
		if(methodObj == null) {
			report_error("GRESKA: Identifikator - " + desg1.getName() + " - nije pronadjen", exprMap);
            exprMap.struct = Tab.noType;
            return;
        } else if(!methodObj.getType().equals(Tab.intType)){
			report_error("GRESKA: Povratna vrednost metode - " + desg1.getName() + " - nije tipa int", exprMap);
			exprMap.struct = Tab.noType;
			return;
        } else if(methodObj.getLevel() != 1) {
        	report_error("GRESKA: Metoda - " + desg1.getName() + " - mora da ima samo jedan parametar", exprMap);
        	exprMap.struct = Tab.noType;
        	return;
        } else if(methodObj.getLevel() == 1) {
			for(Obj param : desg1.getLocalSymbols()) {
				if (param.getType() != Tab.intType) {
					report_error("GRESKA: Parametar metode - " + desg1.getName() + " - nije tipa int", exprMap);
					exprMap.struct = Tab.noType;
					return;
				}
			}
        }
		if(desg2.getType().getKind() != Struct.Array) {
			report_error("GRESKA: Desni designator - " + desg2.getName() + " - nije niz", exprMap);
			exprMap.struct = Tab.noType;
			return;
		}
		
		exprMap.struct = Tab.intType;
		
	}
	
	
	
	
	//DESIGNATOR STATEMENTS
	
	@Override
	public void visit(DesignatorAssignExpr desg) {
		Obj desgObj = desg.getDesignator().obj;
		Struct expr = desg.getExprList().struct;
		if (desgObj.getKind() != Obj.Var && desgObj.getKind() != Obj.Elem) {
			report_error("GRESKA: Dodela u neadekvatnu promenljivu - " + desgObj.getName(), desg);
		} 
		else if(currType.equals(setType)) {
			return;
		}
		else if(!expr.assignableTo(desgObj.getType())) {
			report_error("GRESKA: Neadekvatna dodela vrednosti u promenjivu - " + desgObj.getName(), desg);
		}
	}
	
	@Override
	public void visit(DesignatorINC desg) {
		Obj desgObj = desg.getDesignator().obj;
		if (desgObj.getKind() != Obj.Var && desgObj.getKind() != Obj.Elem) {
			report_error("GRESKA: Inkrementiranje neadekvatne promenljive - " + desgObj.getName(), desg);
		} else if (!desgObj.getType().equals(Tab.intType)) {
			report_error("GRESKA: Inkrementiranje promenljive koja nije tipa int - " + desgObj.getName(), desg);
		}
	}
	
	@Override
	public void visit(DesignatorDEC desg) {
		Obj desgObj = desg.getDesignator().obj;
		if (desgObj.getKind() != Obj.Var && desgObj.getKind() != Obj.Elem) {
			report_error("GRESKA: Dekrementiranje neadekvatne promenljive - " + desgObj.getName(), desg);
		} else if (!desgObj.getType().equals(Tab.intType)) {
			report_error("GRESKA: Dekrementiranje promenljive koja nije tipa int - " + desgObj.getName(), desg);
		}
	}
	
	@Override
	public void visit(DesignatorActPars desg) {
		Obj desgObj = desg.getDesignator().obj;
		if (desgObj.getKind() != Obj.Meth) {
			report_error("GRESKA: Poziv metode nad promenljivom koja nije metoda - " + desgObj.getName(), desg);
		} else {
			List<Struct> formalList = new ArrayList<>();
			for (Obj param : desgObj.getLocalSymbols()) {
				if(param.getKind() == Obj.Var && param.getLevel() == 1 && param.getFpPos() == 1) {
					formalList.add(param.getType());
				}
			}
			ParamsCounter paramsCounter = new ParamsCounter();
			desg.getActParsList().traverseBottomUp(paramsCounter);
			List<Struct> actualList = paramsCounter.finalParams;

			
			try {

				if(formalList.size() != actualList.size()) {
					throw new Exception("GRESKA: Neodgovarajuci broj parametara");
				}
				for(int i = 0; i < formalList.size(); i++) {
					Struct formal = formalList.get(i);
					Struct actual = actualList.get(i);
					if (!actual.assignableTo(formal)) {
						throw new Exception("GRESKA: Neodgovarajuci tip parametara");
					}
					report_info("Poziv metode - " + desgObj.getName(), desg);
				}
			} catch (Exception e) {
				report_error(e.getMessage(), desg);
			}
		}
	}
	
	@Override
	public void visit(DesignatorAssignopSetop desg) {
		Obj desg1 = desg.getDesignator().obj;
		Obj desg2 = desg.getDesignator1().obj;
		Obj desg3 = desg.getDesignator2().obj;
		if (!desg1.getType().equals(setType) || !desg2.getType().equals(setType) || !desg3.getType().equals(setType)) {
			report_error("GRESKA: Neki designator nije set", desg);
		}
	}
	
	
	
	
	//STATEMENTS
	
	@Override
	public void visit(StatementRead stmt) {
		Obj stmtObj = stmt.getDesignator().obj;
		if (stmtObj.getKind() != Obj.Var && stmtObj.getKind() != Obj.Elem) {
			report_error("GRESKA: Read operacija neadekvatne promenljive - " + stmtObj.getName(), stmt);
		} else if (!stmtObj.getType().equals(Tab.intType) && !stmtObj.getType().equals(Tab.charType) && !stmtObj.getType().equals(boolType)) {
			report_error("GRESKA: Read operacija promenljive koja nije dobrog tipa - " + stmtObj.getName(), stmt);
		}
	}
	
	@Override
	public void visit(StatementPrint1 stmt) {
		Struct stmtStruct = stmt.getExprList().struct;
		if (!stmtStruct.equals(Tab.intType) && !stmtStruct.equals(Tab.charType) && !stmtStruct.equals(boolType) && !stmtStruct.equals(setType)) {
			report_error("GRESKA: Print operacija promenljive koja nije dobrog tipa ", stmt);
		}
	}
	
	@Override
	public void visit(StatementPrint2 stmt) {
		Struct stmtStruct = stmt.getExprList().struct;
		if (!stmtStruct.equals(Tab.intType) && !stmtStruct.equals(Tab.charType) && !stmtStruct.equals(boolType) && !stmtStruct.equals(setType)) {
			report_error("GRESKA: Print operacija promenljive koja nije dobrog tipa ", stmt);
		}
	}
	
	@Override
	public void visit(StatementReturn rtrn) {
		hasReturn = true;
		if(currMethod == null) {
			report_error("GRESKA: Return van metode", rtrn);
			return;
		}
		if(currMethod.getType() != Tab.noType) {
			report_error("GRESKA: Nevalidan return unutar metode - " + currMethod.getName() , rtrn);
		} 
	}
	
	@Override
	public void visit(StatementReturnExpr rtrn) {
		hasReturn = true;
		if(currMethod == null) {
			report_error("GRESKA: Return van metode", rtrn);
			return;
		}
		if (!currMethod.getType().equals(rtrn.getExprList().struct)) {
			report_error("GRESKA: Nevalidan return unutar metode (pogresna vrednost) - " + currMethod.getName(), rtrn);
		}
 
	}
	
	@Override
	public void visit(DoVisit doVisit) {
		loopCnt++;
	}
	
	@Override
	public void visit(StatementDo stmt) {
		loopCnt--;
	}
	
	@Override
	public void visit(StatementBreak stmt) {
		if (loopCnt == 0) {
			report_error("GRESKA: Break van petlje", stmt);
		}
	}
	
	@Override
	public void visit(StatementContinue stmt) {
		if (loopCnt == 0) {
			report_error("GRESKA: Continue van petlje", stmt);
		}
	}
	
	
	
	
	//CONDITIONS
	
	@Override
	public void visit(CondFactExpr cond) {
		Struct expr = cond.getExprList().struct;
		if (!expr.equals(boolType)) {
			report_error("GRESKA: Logicki operand nije tipa bool", cond);
			cond.struct = Tab.noType;
			return;
		}
		cond.struct = boolType;
	}
	
	public void visit(CondFactExprRelop condFact) {
		Struct expr1 = condFact.getExprList().struct;
        Struct expr2 = condFact.getExprList1().struct;
        if(!expr1.compatibleWith(expr2)) {
        	report_error("GRESKA: Tipovi nisu kompatibilni", condFact);
        	condFact.struct = Tab.noType;
        	return;
        	
		} else if ((expr1.getKind() == (Struct.Array)) && (expr2.getKind() == (Struct.Array))) {
			if (condFact.getRelop() instanceof RelopEq || condFact.getRelop() instanceof RelopNe) {
				condFact.struct = boolType;
			} else {
				report_error("GRESKA: Nizovi ne mogu da se porede sa tim operatorom", condFact);
				condFact.struct = Tab.noType;
				return;
				
			}
		}
        condFact.struct = boolType;  
	}
	
	//AND
	
	@Override
	public void visit(JustCondTermList cond) {
		cond.struct = cond.getCondTerm().struct;
	}
	
	@Override
	public void visit(CondTermListOr cond) {
		Struct cond1 = cond.getCondTermList().struct;
		Struct cond2 = cond.getCondTerm().struct;
		if (cond1.equals(boolType) && cond2.equals(boolType))
			cond.struct = boolType;
		else {
			report_error("GRESKA: OR operacija mora da ima bool vrednosti", cond);
			cond.struct = Tab.noType;
		}
	}
	
	// OR
	
	@Override
	public void visit(ConditionC cond) {
		cond.struct = cond.getCondTermList().struct;
		
	}
	
	@Override
	public void visit(JustCondFactList cond) {
		cond.struct = cond.getCondFact().struct;
	}
	
	@Override
	public void visit(CondFactListAnd cond) {
		Struct cond1 = cond.getCondFactList().struct;
		Struct cond2 = cond.getCondFact().struct;
		if (cond1.equals(boolType) && cond2.equals(boolType))
			cond.struct = boolType;
		else {
			report_error("GRESKA: And operacija mora da ima bool vrednosti", cond);
			cond.struct = Tab.noType;
		}
	}
	
	@Override
	public void visit(CondTerm cond) {
		cond.struct = cond.getCondFactList().struct;
		if (!cond.struct.equals(boolType)) {
			report_error("GRESKA: Logicki operand nije tipa bool", cond);
		}
		
	}
	
	
}
