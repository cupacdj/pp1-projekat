package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
	private int currNum = 0;
	private String currSet = "";
	private boolean isSet = false;
	private HashMap<String, Integer> setMapCap = new HashMap<>();
	private HashMap<String, HashSet<Integer>> setValues = new HashMap<>();
	private Obj zero = new Obj(Obj.Con, "zero", Tab.intType, 0, 0);
	
	
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
	
	
	private void ordChrMethod() {
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
	}
	
	private void lenMethod() {
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
	
	private void addMethod() {
		Obj addMethod = Tab.find("add");
	    addMethod.setAdr(Code.pc);
	    
	    Code.put(Code.enter);
	    Code.put(2);  // Two parameters (set 's', integer 'b')
	    Code.put(4);  // No local variables

	    // Load set reference (s) and get array length
	    Code.put(Code.load_n);  
	    Code.put(Code.arraylength);  

	    // Initialize index = 0
	    Code.put(Code.const_);
	    Code.put4(0);
	    Code.put(Code.store_n + 1); // Store index in local variable

	    // Start of loop
	    int loopStart = Code.pc;

	    // Load s[index] (s[i])
	    Code.put(Code.load_n);  // Load set reference
	    Code.put(Code.load_n + 1); // Load index
	    Code.put(Code.dup2); // Duplicate set and index before `aload`
	    Code.put(Code.aload);   // Get s[i] (element at index)

	    // Compare s[i] with b (check if already exists)
	    Code.put(Code.load_n + 2); // Load 'b'
	    Code.put(Code.jcc + Code.eq); // If s[i] == b, return (duplicate found)
	    int returnIfFound = Code.pc;
	    Code.put2(0); // Placeholder (must be patched)

	    // Check if empty slot (s[i] == 0)
	    Code.put(Code.dup2); // Duplicate before checking if s[i] == 0
	    Code.put(Code.aload);   // Get s[i] again

	    Code.put(Code.const_);
	    Code.put4(0);
	    Code.put(Code.jcc + Code.eq); // If s[i] == 0, jump to insert
	    int insertIndex = Code.pc;
	    Code.put2(0);  // Placeholder

	    // Increment index
	    Code.put(Code.load_n + 1);
	    Code.put(Code.const_);
	    Code.put4(1);
	    Code.put(Code.add);
	    Code.put(Code.store_n + 1);

	    // Loop back
	    Code.put(Code.jmp);
	    Code.put2(loopStart - Code.pc + 2);  // Jump back to loop start

	    // Return if duplicate found
	    Code.fixup(returnIfFound);
	    Code.put(Code.pop); // Clear leftover values
	    Code.put(Code.pop);
	    Code.put(Code.pop);
	    Code.put(Code.exit);
	    Code.put(Code.return_);

	    // Insert 'b' into empty slot
	    Code.fixup(insertIndex);
	    Code.put(Code.load_n);  // Load set reference
	    Code.put(Code.load_n + 1); // Load index
	    Code.put(Code.load_n + 2); // Load 'b'
	    Code.put(Code.astore);  // Store 'b' into s[i]

	    Code.put(Code.pop); // Clear leftover values
	    Code.put(Code.pop);
	    Code.put(Code.pop);
	    Code.put(Code.exit);
	    Code.put(Code.return_);
	}
	
	private void addAllMethod() {
		Obj addAllMethod = Tab.find("addAll");
        addAllMethod.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(2);
        Code.put(2);
        Code.put(Code.load_n);
        // implementacija addAll metode
        //standardna metoda; addAll(a, b) dodaje sve elemente celobrojnog niza b u skup a
        Code.put(Code.exit);
        Code.put(Code.return_);
	}
	
	private void initializePredeclaredMethods() {
		
		ordChrMethod();
		
		lenMethod();
        
        addMethod();
           
        addAllMethod();
        
        Obj getElementMethod = Tab.find("getElement");
        getElementMethod.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(2);  // Two parameters: set reference (array), index
        Code.put(2);  // No local variables

        Code.put(Code.load_n);   // Load set reference
        Code.put(Code.load_n + 1); // Load index
        Code.put(Code.aload);   // Fetch s[index]

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
		report_info("print1", print1);
		Code.loadConst(0);
		if(print1.getExprList().struct.equals(Tab.charType))
            Code.put(Code.bprint);
        else
        	Code.put(Code.print);		
	}
	
	@Override
	public void visit(StatementPrint2 print2) {
		report_info("print2", print2);
		Code.loadConst(print2.getN2());
		if(print2.getExprList().struct.equals(Tab.charType))
            Code.put(Code.bprint);
        else
        	Code.put(Code.print);	
	}
	
	@Override
	public void visit(StatementReturn ret) {
		report_info("Return", ret);
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(StatementReturnExpr ret) {
		report_info("ReturnExpr", ret);
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(StatementRead read) {
		report_info("Read", read);
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
		report_info("DesignatorINC", inc);
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
		report_info("DesignatorDEC", dec);
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
		if(isSet) {
			setMapCap.put(desg.getDesignator().obj.getName(), currNum);
			isSet = false;
			report_info("Name - " + desg.getDesignator().obj.getName() + " value - " + currNum, desg);
			//currSet =  desg.getDesignator().obj.getName();
		}
		report_info("DesignatorAssignExpr", desg);
		Code.store(desg.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorActPars desg) {
		report_info("DesignatorActPars", desg);
		String name = desg.getDesignator().obj.getName();
		if (name.equals("add")) {
			ParamsCounter paramsCounter = new ParamsCounter();
			desg.getActParsList().traverseBottomUp(paramsCounter);
			if (setMapCap.get(currSet) > setValues.get(currSet).size())
				setValues.get(currSet).add(currNum);
			// print set
			System.out.println("Set " + currSet + " : ");
			for (Integer i : setValues.get(currSet)) {
				System.out.println(" " + i);		
			}
			
		} else if (name.equals("addAll")) {
			
			
		}
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
		report_info("DesignatorArray + " + desg.getI1() + " curnum " + currNum, desg);
		
		Code.load(desg.obj);
	}
	
	@Override
	public void visit(DesignatorExpr desg) {
		report_info("DesignatorExpr " + " currNUm " + currNum  , desg);
	
	}
	
	@Override
	public void visit(DesignatorIdent desg) {
		report_info("DesignatorIdent - " + desg.obj.getName(), desg);
		currSet = desg.obj.getName();
	}
	
	
	// MAP
	
	@Override
	public void visit(ExprMap m) {
		Obj desg1 = m.getDesignator().obj;
		Obj desg2 = m.getDesignator1().obj;
		Code.put(Code.call);
		Code.put(desg1.getAdr());
		
	}
	
	
	
	// FACTORS
	
	@Override
	public void visit(FactorNum fact) {
		report_info("Num: " + fact.getN1(), fact);
		currNum = fact.getN1();
		Code.loadConst(fact.getN1());
	}
	
	@Override
	public void visit(FactorChar fact) {
		report_info("Char: " + fact.getC1(), fact);
		Code.loadConst(fact.getC1());
	}
	
	@Override
	public void visit(FactorBool fact) {
		report_info("Bool: " + fact.getB1(), fact);
        Code.loadConst(fact.getB1());
    }
	
	@Override
	public void visit(FactorDesignator fact) {
		report_info("Designator: " + fact.getDesignator().obj.getName(), fact);
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
		report_info("Minus ", fact);
		Code.put(Code.neg);
	}
	
	@Override
	public void visit(FactorNew fact) {	
		Code.put(Code.newarray);
		Struct factStruct = fact.getType().struct;
		if(factStruct.equals(Tab.charType)) {
			report_info("New char arr", fact);
			Code.put(0);
		} else if(factStruct.equals(Tab.intType)) {
			report_info("New int arr", fact);
			Code.put(1);
		} else {
			report_info("New set + " + currSet, fact);
			isSet = true;
			// new set of integers
			HashSet<Integer> s = new HashSet<Integer>();
			setValues.put(currSet, s);
			Code.put(1);
		}
			
		
	}
	
	
	
	@Override
	public void visit(AddopExprTerm addop) {
		report_info("AddopExprTerm", addop);
		if (addop.getAddop() instanceof AddopPlus)
			Code.put(Code.add);
		else
			Code.put(Code.sub);
	}
	
	@Override
	public void visit(MulopTerm mulop) {
		report_info("MulopTerm", mulop);
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
		report_info("CondFactExpr", cond);
	    Code.loadConst(0);
	    Code.putFalseJump(Code.ne, 0); // netacno
	    skipCondFact.add(Code.pc - 2);
	    // tacno
	}

	@Override
	public void visit(CondFactExprRelop cond) {
		report_info("CondFactExprRelop", cond);
	    Code.putFalseJump(getRelop(cond.getRelop()), 0); // netacno
	    skipCondFact.add(Code.pc - 2); 
	    // tacno
	}

	@Override
	public void visit(CondTerm cond) {
		report_info("CondTerm", cond);
	    // tacne
	    Code.putJump(0); // tacne idu na THEN, ispunila ceo jedan OR
	    skipCondition.add(Code.pc - 2); 
	    while (!skipCondFact.isEmpty()) 
	        Code.fixup(skipCondFact.remove(skipCondFact.size() - 1)); 
	    
	}

	@Override
	public void visit(ConditionC cond) {
		report_info("ConditionC", cond);
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
		report_info("ElseStmtNo", e);
		//tacke
		Code.fixup(skipThen.pop());
		// tacne + netacne
		
	}
	
	@Override
	public void visit(Else e) {
		report_info("Else", e);
		//tacne
		Code.putJump(0); // idu na kraj ELSE
		skipElse.push(Code.pc - 2);
		Code.fixup(skipThen.pop());
		// netacne
	}
	
	@Override
	public void visit(ElseStmtYes e) {
		report_info("ElseStmtYes", e);
		//netacne
		Code.fixup(skipElse.pop()); // vracamo tacne koji su preskocili ELSE
		// tacne + netacne
	}
	
	
	private Stack<Integer> doBegin = new Stack<>();
	
	// DO WHILE
	
	@Override
	public void visit(DoVisit dw) {
		report_info("DoVisit", dw);
		doBegin.push(Code.pc);
		breakStack.push(new ArrayList<>());
		continueStack.push(new ArrayList<>());
	}
	
	@Override
	public void visit(StatementDo dw) {
		report_info("StatementDo", dw);
		Code.putJump(doBegin.pop());
		if (dw.getConditionDesignator() instanceof CondDesignator || dw.getConditionDesignator() instanceof CondDesignatorList) 
			Code.fixup(skipThen.pop());
		while (!breakStack.peek().isEmpty())
			Code.fixup(breakStack.peek().remove(0));
		breakStack.pop();
	}
	
//	@Override
//	public void visit(CondDesignatorList cond) {
//		 report_info("CondDesignatorList", cond);
//        Code.putFalseJump(Code.ne, 0);
//        skipThen.push(Code.pc - 2);
//	}

	
	// BRAKE & CONTINUE
	private Stack<List<Integer>> breakStack = new Stack<>();
	private Stack<List<Integer>> continueStack = new Stack<>();
	
	@Override
	public void visit(StatementBreak br) {
		report_info("Break", br);
		Code.putJump(0);
		breakStack.peek().add(Code.pc - 2);
		
	}
	
	@Override
	public void visit(StatementContinue ct) {
		report_info("Continue", ct);
		Code.putJump(0);
        continueStack.peek().add(Code.pc - 2);
    }
	
	@Override
	public void visit(WhileVisit w) {
		report_info("WhileVisit", w);
		while (!continueStack.peek().isEmpty())
			Code.fixup(continueStack.peek().remove(0));
		continueStack.pop();
	}
	
	
}
