package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;


%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
    return new_symbol(sym.EOF);
%eofval}

%%

" "			{ }
"\t"		{ }
"\b"		{ }
"\r\n"      { }
"\f"		{ }

"program"   { return new_symbol(sym.PROG, yytext()); }
"break"     { return new_symbol(sym.BREAK, yytext()); }
"else"      { return new_symbol(sym.ELSE, yytext()); }
"const"     { return new_symbol(sym.CONST, yytext()); }
"if"        { return new_symbol(sym.IF, yytext()); }
"new"       { return new_symbol(sym.NEW, yytext()); }
"print"     { return new_symbol(sym.PRINT, yytext()); }
"read"      { return new_symbol(sym.READ, yytext()); }
"return"    { return new_symbol(sym.RETURN, yytext()); }
"void"      { return new_symbol(sym.VOID, yytext()); }
"continue"  { return new_symbol(sym.CONTINUE, yytext()); }
"union"     { return new_symbol(sym.UNION, yytext()); }
"do"        { return new_symbol(sym.DO, yytext()); }
"while"     { return new_symbol(sym.WHILE, yytext()); }
"map"       { return new_symbol(sym.MAP, yytext()); }

"+"         { return new_symbol(sym.PLUS, yytext()); }
"-"         { return new_symbol(sym.MINUS, yytext()); }
"*"         { return new_symbol(sym.MUL, yytext()); }
"/"         { return new_symbol(sym.DIV, yytext()); }
"%"         { return new_symbol(sym.MOD, yytext()); }
"=="        { return new_symbol(sym.EQ, yytext()); }
"!="        { return new_symbol(sym.NEQ, yytext()); }
">"         { return new_symbol(sym.GT, yytext()); }
">="        { return new_symbol(sym.GTE, yytext()); }
"<"         { return new_symbol(sym.LT, yytext()); }
"<="        { return new_symbol(sym.LTE, yytext()); }
"&&"        { return new_symbol(sym.AND, yytext()); }
"||"        { return new_symbol(sym.OR, yytext()); }
"="         { return new_symbol(sym.ASSIGN, yytext()); }
"++"        { return new_symbol(sym.INC, yytext()); }
"--"        { return new_symbol(sym.DEC, yytext()); }
";"         { return new_symbol(sym.SEMI, yytext()); }
","         { return new_symbol(sym.COMMA, yytext()); }
"("         { return new_symbol(sym.LPAREN, yytext()); }
")"         { return new_symbol(sym.RPAREN, yytext()); }
"["         { return new_symbol(sym.LBRACKET, yytext()); }
"]"         { return new_symbol(sym.RBRACKET, yytext()); }
"{"         { return new_symbol(sym.LBRACE, yytext()); }
"}"         { return new_symbol(sym.RBRACE, yytext()); }

"//" 			 { yybegin(COMMENT); }
<COMMENT> . 	 { yybegin(COMMENT); }
<COMMENT> "\r\n" { yybegin(YYINITIAL); }


([1-9])([0-9])*					{ return new_symbol(sym.NUM, yytext()); }
"'"."'"                         { return new_symbol(sym.CHAR, new Character (yytext().charAt(1))); }
("true"|"false")                { return new_symbol(sym.BOOL, yytext().equals("false") ? 0:1 ); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{ return new_symbol(sym.IDENT, yytext()); }


. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }