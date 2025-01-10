package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());
	
	private boolean errorDetected = false;
	private Obj currProgam;
	private Struct currType;
	private int constant;
	private Struct constType;
	private Struct boolType = Tab.find("bool").getType();
	private Obj currMethod;
	private Obj main;
	
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
		currMethod = null;
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
			currType = typeObj.getType();
		}
	}
	
	
	// CONTECST CONDITIONS

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
		factorDesignator.struct = factorDesignator.getDesignator().obj.getType();
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
		if (factor.getExprList().struct.equals(Tab.intType)) {
			factor.struct = new Struct(Struct.Array, currType);
		} else {
			report_error("GRESKA: Velicina niza nije tipa int", factor);
			factor.struct = Tab.noType;
		}
	}
	
	@Override
	public void visit(FactorExpr factor) {
		factor.struct = factor.getExprList().struct;
	}
	
	
	@Override
	public void visit(DesignatorIdent designatorIdent) {
		String ident = designatorIdent.getI1();
		Obj obj = Tab.find(ident);
		if (obj == Tab.noObj) {
			report_error("GRESKA: Identifikator - " + ident + " - nije definisan", designatorIdent);
			designatorIdent.obj = Tab.noObj;
		} else if (obj.getKind() != Obj.Var && obj.getKind() != Obj.Con) {
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
		} else if(!designatorExpr.getExprList().equals(Tab.intType)) {
            report_error("GRESKA: Indeks niza nije tipa int", designatorExpr);
            designatorExpr.obj = Tab.noObj;
		}
		else {
			designatorExpr.obj = new Obj(Obj.Elem, obj.getName() + "{$}", obj.getType().getElemType());
		}
	}
}
