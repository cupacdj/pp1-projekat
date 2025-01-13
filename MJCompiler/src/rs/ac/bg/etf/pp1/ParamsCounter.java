package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;


public class ParamsCounter extends VisitorAdaptor {
	
	List<Struct> finalParams;

	Stack<List<Struct>> params = new Stack<>();
	
	Logger log = Logger.getLogger(getClass());
	
	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	@Override
	public void visit(ActParsListBegin par) {
		params.push(new ArrayList<>());
		//report_info("Parametar: " + par.getExprList().struct.getKind(), par);
	}
	
	@Override
	public void visit(ActPar par) {
		params.peek().add(par.getExprList().struct);
	}
	
	@Override
	public void visit(ListActPars par) {
		finalParams = params.pop();
	}
	
	@Override
	public void visit(NoActParsList par) {
		finalParams = params.pop();
	}
	
}
