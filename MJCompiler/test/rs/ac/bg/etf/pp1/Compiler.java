package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.*;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class Compiler {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
		
		Logger log = Logger.getLogger(Compiler.class);
		
		Reader br = null;
		try {
			File sourceCode = new File("test/program.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			// citanje bajt po bajt iz ulaznog fajla
			br = new BufferedReader(new FileReader(sourceCode));
			// formiranje tokena
			Yylex lexer = new Yylex(br);
			
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //formiranje AST stabla token po token
	        
	        // u s.value se nalazi adresa korena AST stabla
	        // i to mora da bude Program
	        Program prog = (Program)(s.value); 
	        
			// ispis AST
			log.info(prog.toString(""));
			log.info("=====================================================================");
			
			// inicijalizacija tabele simbola 
			Tab.init();
	        
			Struct boolType = new Struct(Struct.Bool);
			Obj boolObj = Tab.insert(Obj.Type, "bool", boolType);
			boolObj.setAdr(-1);
			boolObj.setLevel(-1);
			
			Struct setType = new Struct(Struct.Array, Tab.intType);
			Obj setObj = Tab.insert(Obj.Type, "set", setType);
			setObj.setAdr(-1);
			setObj.setLevel(-1);
			
			Obj addObj = Tab.insert(Obj.Meth, "add", Tab.noType);
			addObj.setAdr(0);
			addObj.setLevel(2);
			
			Obj addAllObj = Tab.insert(Obj.Meth, "addAll", Tab.noType);
			addAllObj.setAdr(0);
			addAllObj.setLevel(2);
			
			for (Obj fp : Tab.find("chr").getLocalSymbols()) {
				fp.setAdr(1);
			}
			for (Obj fp : Tab.find("ord").getLocalSymbols()) {
				fp.setAdr(1);
			}
			for (Obj fp : Tab.find("len").getLocalSymbols()) {
				fp.setAdr(1);
			}
			for (Obj fp : Tab.find("add").getLocalSymbols()) {
				fp.setAdr(1);
			}
			for (Obj fp : Tab.find("addAll").getLocalSymbols()) {
				fp.setAdr(1);
			}
			
			// Semanticka analiza 
			SemanticAnalyzer sa = new SemanticAnalyzer();
			prog.traverseBottomUp(sa);
			
			// Ispis tabele simbola 
			Tab.dump();

			
			if(!p.errorDetected & sa.passed()){
				// Generisanje koda
				File objFile = new File("test/program.obj");
				if(objFile.exists()) objFile.delete();
				
				CodeGenerator code = new CodeGenerator();
				prog.traverseBottomUp(code);
				Code.dataSize = sa.nVars;
				Code.mainPc = code.getmPc();
				Code.write(new FileOutputStream(objFile));
				
				log.info("Generisanje koda uspesno zavrseno!");
			}else{
				log.error("Generisanje koda NIJE uspesno zavrseno!");
			}
			
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}

	}
	
	
}
