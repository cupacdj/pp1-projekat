// generated with ast extension for cup
// version 0.8
// 13/0/2025 18:27:16


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Mulop Mulop);
    public void visit(Constant Constant);
    public void visit(Relop Relop);
    public void visit(CondTermList CondTermList);
    public void visit(FormParsListMore FormParsListMore);
    public void visit(StatementElse StatementElse);
    public void visit(MethodSignature MethodSignature);
    public void visit(StatementList StatementList);
    public void visit(FactorList FactorList);
    public void visit(ConstVarDeclList ConstVarDeclList);
    public void visit(Addop Addop);
    public void visit(TermMulFactor TermMulFactor);
    public void visit(Factor Factor);
    public void visit(CondFactList CondFactList);
    public void visit(Designator Designator);
    public void visit(ExprAddopTerm ExprAddopTerm);
    public void visit(MethodName MethodName);
    public void visit(Condition Condition);
    public void visit(ActParsList ActParsList);
    public void visit(FormParsListZero FormParsListZero);
    public void visit(DesignatorStatementList DesignatorStatementList);
    public void visit(ConstDeclListMore ConstDeclListMore);
    public void visit(FactorActPars FactorActPars);
    public void visit(ExprList ExprList);
    public void visit(ActPars ActPars);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ConditionDesignator ConditionDesignator);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(VarDeclListMore VarDeclListMore);
    public void visit(FormPar FormPar);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(VarDeclEmpty VarDeclEmpty);
    public void visit(Setop Setop);
    public void visit(RelopLe RelopLe);
    public void visit(RelopLt RelopLt);
    public void visit(RelopGe RelopGe);
    public void visit(RelopGt RelopGt);
    public void visit(RelopNe RelopNe);
    public void visit(RelopEq RelopEq);
    public void visit(MulopMod MulopMod);
    public void visit(MulopDiv MulopDiv);
    public void visit(MulopMul MulopMul);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPlus AddopPlus);
    public void visit(Assignop Assignop);
    public void visit(DesignatorArray DesignatorArray);
    public void visit(DesignatorExpr DesignatorExpr);
    public void visit(DesignatorIdent DesignatorIdent);
    public void visit(NoActParsFactor NoActParsFactor);
    public void visit(ActParsFactor ActParsFactor);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorNew FactorNew);
    public void visit(FactorBool FactorBool);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNum FactorNum);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(NoFactorListMinus NoFactorListMinus);
    public void visit(FactorListMinus FactorListMinus);
    public void visit(FactorMulopTerm FactorMulopTerm);
    public void visit(MulopTerm MulopTerm);
    public void visit(Term Term);
    public void visit(TermAddopExprTerm TermAddopExprTerm);
    public void visit(AddopExprTerm AddopExprTerm);
    public void visit(ExprMap ExprMap);
    public void visit(ListExpr ListExpr);
    public void visit(CondFactExprRelop CondFactExprRelop);
    public void visit(CondFactExpr CondFactExpr);
    public void visit(CondFactListAnd CondFactListAnd);
    public void visit(JustCondFactList JustCondFactList);
    public void visit(CondTerm CondTerm);
    public void visit(CondTermListOr CondTermListOr);
    public void visit(JustCondTermList JustCondTermList);
    public void visit(ErrorCondition ErrorCondition);
    public void visit(ConditionC ConditionC);
    public void visit(ActPar ActPar);
    public void visit(NoActPars NoActPars);
    public void visit(ActParsRepeat ActParsRepeat);
    public void visit(ActParsListBegin ActParsListBegin);
    public void visit(NoActParsList NoActParsList);
    public void visit(ListActPars ListActPars);
    public void visit(DesignatorDEC DesignatorDEC);
    public void visit(DesignatorINC DesignatorINC);
    public void visit(DesignatorActPars DesignatorActPars);
    public void visit(ErrorDesignatorStatement ErrorDesignatorStatement);
    public void visit(DesignatorAssignExpr DesignatorAssignExpr);
    public void visit(DesignatorAssignopSetop DesignatorAssignopSetop);
    public void visit(ListDesignatorStatement ListDesignatorStatement);
    public void visit(NoCondDesignator NoCondDesignator);
    public void visit(CondDesignatorList CondDesignatorList);
    public void visit(CondDesignator CondDesignator);
    public void visit(ElseStmtNo ElseStmtNo);
    public void visit(ElseStmtYes ElseStmtYes);
    public void visit(DoVisit DoVisit);
    public void visit(StatementRepeat StatementRepeat);
    public void visit(StatementDo StatementDo);
    public void visit(StatementPrint2 StatementPrint2);
    public void visit(StatementPrint1 StatementPrint1);
    public void visit(StatementRead StatementRead);
    public void visit(StatementReturnExpr StatementReturnExpr);
    public void visit(StatementReturn StatementReturn);
    public void visit(StatementContinue StatementContinue);
    public void visit(StatementBreak StatementBreak);
    public void visit(StatementIf StatementIf);
    public void visit(SingleStatementDsg SingleStatementDsg);
    public void visit(NoStatementList NoStatementList);
    public void visit(ListStatement ListStatement);
    public void visit(ErrorFormPar ErrorFormPar);
    public void visit(FormParArray FormParArray);
    public void visit(FormParVar FormParVar);
    public void visit(NoMoreFormParsList NoMoreFormParsList);
    public void visit(MoreFormParsList MoreFormParsList);
    public void visit(FormParsList FormParsList);
    public void visit(NoFormParsListZero NoFormParsListZero);
    public void visit(ZeroFormParsList ZeroFormParsList);
    public void visit(NoEmptyVarDecl NoEmptyVarDecl);
    public void visit(EmptyVarDecl EmptyVarDecl);
    public void visit(VoidSignature VoidSignature);
    public void visit(TypeSignature TypeSignature);
    public void visit(MethodSignatureList MethodSignatureList);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMethodDeclList NoMethodDeclList);
    public void visit(ListMethodDecl ListMethodDecl);
    public void visit(Type Type);
    public void visit(NoMoreVarDeclList NoMoreVarDeclList);
    public void visit(MoreVarDeclList MoreVarDeclList);
    public void visit(ErrorVarDecl ErrorVarDecl);
    public void visit(ArrayVarDecl ArrayVarDecl);
    public void visit(IdentVarDecl IdentVarDecl);
    public void visit(VarDeclList VarDeclList);
    public void visit(NoMoreConstDeclList NoMoreConstDeclList);
    public void visit(MoreConstDeclList MoreConstDeclList);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumConst NumConst);
    public void visit(ErrorConstDecl ErrorConstDecl);
    public void visit(ConstDeclConst ConstDeclConst);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(NoConstVarDeclList NoConstVarDeclList);
    public void visit(VConstVarDeclList VConstVarDeclList);
    public void visit(CConstVarDeclList CConstVarDeclList);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
