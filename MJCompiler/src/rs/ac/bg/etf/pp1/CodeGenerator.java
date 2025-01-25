package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.mj.runtime.Code;

public class CodeGenerator extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());
	
	private int mPC;
	private Struct setType = Tab.find("set").getType();
	
	public void report_error(String message, SyntaxNode info) {
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
	
	public int getmPc() {
		return mPC;
	}
	
	
	private void initializePredeclaredMethods() {
        // 'ord' and 'chr' are the same code.
        Obj ordMethod = Tab.find("ord");
        Obj chrMethod = Tab.find("chr");
        ordMethod.setAdr(Code.pc);
        chrMethod.setAdr(Code.pc);
        // skinula se vrednost sa steka
        Code.put(Code.enter);
        // jedan formalni parametar
        Code.put(1);
        // zbir formalnih i lokalnih promenljivih
        Code.put(1);
        // stavlja vrednost na stek
        Code.put(Code.load_n);
        Code.put(Code.exit);
        Code.put(Code.return_);
 
        Obj lenMethod = Tab.find("len");
        lenMethod.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(1);
        Code.put(1);
        Code.put(Code.load_n);
        // ostavlja len niza na exprstek
        Code.put(Code.arraylength);
        Code.put(Code.exit);
        Code.put(Code.return_);
 
    }
	
	CodeGenerator() {
		this.initializePredeclaredMethods();
	}
	
	//METHODS
	
	@Override
	public void visit(VoidSignature methName) {
		methName.obj.setAdr(Code.pc);
		if(methName.getI1().equalsIgnoreCase("main"))
			this.mPC = Code.pc;
		Code.put(Code.enter);
		Code.put(methName.obj.getLevel()); //b1
		Code.put(methName.obj.getLocalSymbols().size()); //b2
		
	}
	
	@Override
	public void visit(TypeSignature methName) {
		methName.obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(methName.obj.getLevel()); //b1
		Code.put(methName.obj.getLocalSymbols().size()); //b2
	}
	
	@Override
	public void visit(MethodDecl meth) {
		Code.put(Code.exit);
        Code.put(Code.return_);
	}
	
	
	//STATEMENTS
	
	@Override
	public void visit(StatementPrint1 print1) {
		Code.loadConst(0);
		if(print1.getExprList().struct.equals(Tab.charType))
            Code.put(Code.bprint);
        else
        	Code.put(Code.print);		
	}
	
	@Override
	public void visit(StatementPrint2 print2) {
		Code.loadConst(print2.getN2());
		if(print2.getExprList().struct.equals(Tab.charType))
            Code.put(Code.bprint);
        else
        	Code.put(Code.print);	
	}
	
	@Override
	public void visit(StatementReturn ret) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(StatementReturnExpr ret) {
		//Struct expr = ret.getExprList().struct;
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(StatementRead read) {
		Obj readObj = read.getDesignator().obj;
		if (readObj.getType().equals(Tab.charType))
			Code.put(Code.bread);
		else
			Code.put(Code.read);
		Code.store(readObj);
	}
	
	
	// DESIGNATOR STATEMENTS
	
	@Override
	public void visit(DesignatorINC inc) {
		Obj desgObj = inc.getDesignator().obj;
		if (desgObj.getKind() == Obj.Elem)
			Code.put(Code.dup2);
		// stavljamo promenljivu na stek
		Code.load(inc.getDesignator().obj);
		Code.loadConst(1);
		// sabiramo promenljivo sa 1
		Code.put(Code.add);
		// cuvamo u designatoru
		Code.store(inc.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorDEC dec) {
		Obj desgObj = dec.getDesignator().obj;
		if (desgObj.getKind() == Obj.Elem)
			Code.put(Code.dup2);
		Code.load(desgObj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(desgObj);
	}
	
	@Override
	public void visit(DesignatorAssignExpr desg) {
		Code.store(desg.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorActPars desg) {
		int offset = desg.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		// ako nije void metoda skida se sa steka
		if (desg.getDesignator().obj.getType() != Tab.noType)
			Code.put(Code.pop);
	}
	
	
	// DESIGNATOR
	
	@Override
	public void visit(DesignatorArray desg) {
		Code.load(desg.obj);
	}
	
	
	
	// FACTORS
	
	@Override
	public void visit(FactorNum fact) {
		
		report_info("Num: " + fact.getN1(), fact);
		Code.loadConst(fact.getN1());
	}
	
	@Override
	public void visit(FactorChar fact) {
		Code.loadConst(fact.getC1());
	}
	
	@Override
	public void visit(FactorBool fact) {
        Code.loadConst(fact.getB1());
    }
	
	@Override
	public void visit(FactorDesignator fact) {
		if(fact.getFactorActPars() instanceof NoActParsFactor)
			Code.load(fact.getDesignator().obj);
		else {
			int offset = fact.getDesignator().obj.getAdr() - Code.pc;
			Code.put(Code.call);
			Code.put2(offset);
			if(fact.getDesignator().obj.getName().equals("ord")){
				
			}
		}
	}
	
	
	@Override
	public void visit(FactorListMinus fact) {
		Code.put(Code.neg);
	}
	
	@Override
	public void visit(FactorNew fact) {
		if (fact.getType().struct.equals(setType)) {
			//take from stack
			report_info("New set", fact);
			return;
			
		}
		Code.put(Code.newarray);
		Struct factStruct = fact.getType().struct;
		if(factStruct.equals(Tab.charType)) 
			Code.put(0);
		else
			Code.put(1);
		
	}
	
	
	
	@Override
	public void visit(AddopExprTerm addop) {
		if (addop.getAddop() instanceof AddopPlus)
			Code.put(Code.add);
		else
			Code.put(Code.sub);
	}
	
	@Override
	public void visit(MulopTerm mulop) {
		if (mulop.getMulop() instanceof MulopMul)
			Code.put(Code.mul);
		else if (mulop.getMulop() instanceof MulopDiv)
			Code.put(Code.div);
		else
			Code.put(Code.rem);
	}
	
	
	// CONDITIONS
	private int getRelop(Relop relop) {
		if(relop instanceof RelopEq)
			return Code.eq;
		else if(relop instanceof RelopNe)
			return Code.ne;
		else if(relop instanceof RelopGt)
			return Code.gt;
		else if(relop instanceof RelopGe)
			return Code.ge;
		else if(relop instanceof RelopLt)
			return Code.lt;
		else if(relop instanceof RelopLe)
			return Code.le;
		else
			return -1;
		
	}
	private List<Integer> skipCondFact = new ArrayList<>();
	private List<Integer> skipCondition = new ArrayList<>();
	private Stack<Integer> skipThen = new Stack<>();
	private Stack<Integer> skipElse = new Stack<>();

	@Override
	public void visit(CondFactExpr cond) {
	    Code.loadConst(0);
	    Code.putFalseJump(Code.ne, 0); // netacno
	    skipCondFact.add(Code.pc - 2);
	    // tacno
	}

	@Override
	public void visit(CondFactExprRelop cond) {
	    Code.putFalseJump(getRelop(cond.getRelop()), 0); // netacno
	    skipCondFact.add(Code.pc - 2); 
	    // tacno
	}

	@Override
	public void visit(CondTerm cond) {
	    // tacne
	    Code.putJump(0); // tacne idu na THEN, ispunila ceo jedan OR
	    skipCondition.add(Code.pc - 2); 
	    while (!skipCondFact.isEmpty()) 
	        Code.fixup(skipCondFact.remove(skipCondFact.size() - 1)); 
	    
	}

	@Override
	public void visit(ConditionC cond) {
	    // netacni
	    Code.putJump(0); // netacni idu na ELSE
	    skipThen.push(Code.pc - 2);
	    // THEN
	    while (!skipCondition.isEmpty()) 
	        Code.fixup(skipCondition.remove(skipCondition.size() - 1));
	    
	    // tacne
	}
	
	@Override
	public void visit(ElseStmtNo e) {
		//tacke
		Code.fixup(skipThen.pop());
		// tacne + netacne
		
	}
	
	@Override
	public void visit(Else e) {
		//tacne
		Code.putJump(0); // idu na kraj ELSE
		skipElse.push(Code.pc - 2);
		Code.fixup(skipThen.pop());
		// netacne
	}
	
	@Override
	public void visit(ElseStmtYes e) {
		//netacne
		Code.fixup(skipElse.pop()); // vracamo tacne koji su preskocili ELSE
		// tacne + netacne
	}
	
	
	private Stack<Integer> doBegin = new Stack<>();
	
	// DO WHILE
	
	@Override
	public void visit(DoVisit dw) {
		doBegin.push(Code.pc);
		breakStack.push(new ArrayList<>());
		continueStack.push(new ArrayList<>());
	}
	
	@Override
	public void visit(StatementDo dw) {
		Code.putJump(doBegin.pop());
		Code.fixup(skipThen.pop());
		while (!breakStack.peek().isEmpty())
			Code.fixup(breakStack.peek().remove(0));
		breakStack.pop();
	}

	
	// BRAKE & CONTINUE
	private Stack<List<Integer>> breakStack = new Stack<>();
	private Stack<List<Integer>> continueStack = new Stack<>();
	
	@Override
	public void visit(StatementBreak br) {
		Code.putJump(0);
		breakStack.peek().add(Code.pc - 2);
		
	}
	
	@Override
	public void visit(StatementContinue ct) {
		Code.putJump(0);
        continueStack.peek().add(Code.pc - 2);
    }
	
	@Override
	public void visit(WhileVisit w) {
		while (!continueStack.peek().isEmpty())
			Code.fixup(continueStack.peek().remove(0));
		continueStack.pop();
	}
	
	
}
