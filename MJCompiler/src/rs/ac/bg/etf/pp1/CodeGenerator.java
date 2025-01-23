package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.mj.runtime.Code;

public class CodeGenerator extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());
	
	private boolean errorDetected = false;
	private int mPC;
	private Struct setType = Tab.find("set").getType();
	
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
	
	public int getmPc() {
		return mPC;
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
		Struct expr = ret.getExprList().struct;
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
		}
	}
	
	
	@Override
	public void visit(FactorListMinus fact) {
		Code.put(Code.neg);
	}
	
	@Override
	public void visit(FactorNew fact) {
//		if (fact.getType().struct.equals(setType)) {
//			
//			Code.put(Code.new_);
//			return;
//		}
		Code.put(Code.newarray);
		Struct factStruct = fact.getType().struct;
		if(factStruct.equals(Tab.charType)) 
			Code.put(0);
		else
			Code.put(1);
		
	}
	
	@Override
	public void visit(FactorExpr fact) {
		// Code.put(Code.dup);
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
	
	
}
