// generated with ast extension for cup
// version 0.8
// 25/0/2025 16:54:45


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodSignatureList MethodSignatureList;
    private VarDeclEmpty VarDeclEmpty;
    private StatementList StatementList;

    public MethodDecl (MethodSignatureList MethodSignatureList, VarDeclEmpty VarDeclEmpty, StatementList StatementList) {
        this.MethodSignatureList=MethodSignatureList;
        if(MethodSignatureList!=null) MethodSignatureList.setParent(this);
        this.VarDeclEmpty=VarDeclEmpty;
        if(VarDeclEmpty!=null) VarDeclEmpty.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodSignatureList getMethodSignatureList() {
        return MethodSignatureList;
    }

    public void setMethodSignatureList(MethodSignatureList MethodSignatureList) {
        this.MethodSignatureList=MethodSignatureList;
    }

    public VarDeclEmpty getVarDeclEmpty() {
        return VarDeclEmpty;
    }

    public void setVarDeclEmpty(VarDeclEmpty VarDeclEmpty) {
        this.VarDeclEmpty=VarDeclEmpty;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodSignatureList!=null) MethodSignatureList.accept(visitor);
        if(VarDeclEmpty!=null) VarDeclEmpty.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodSignatureList!=null) MethodSignatureList.traverseTopDown(visitor);
        if(VarDeclEmpty!=null) VarDeclEmpty.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodSignatureList!=null) MethodSignatureList.traverseBottomUp(visitor);
        if(VarDeclEmpty!=null) VarDeclEmpty.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(MethodSignatureList!=null)
            buffer.append(MethodSignatureList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclEmpty!=null)
            buffer.append(VarDeclEmpty.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
