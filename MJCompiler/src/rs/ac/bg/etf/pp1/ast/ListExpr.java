// generated with ast extension for cup
// version 0.8
// 3/0/2025 23:21:27


package src.rs.ac.bg.etf.pp1.ast;

public class ListExpr extends ExprList {

    private ExprTerm ExprTerm;
    private ExprAddopTerm ExprAddopTerm;

    public ListExpr (ExprTerm ExprTerm, ExprAddopTerm ExprAddopTerm) {
        this.ExprTerm=ExprTerm;
        if(ExprTerm!=null) ExprTerm.setParent(this);
        this.ExprAddopTerm=ExprAddopTerm;
        if(ExprAddopTerm!=null) ExprAddopTerm.setParent(this);
    }

    public ExprTerm getExprTerm() {
        return ExprTerm;
    }

    public void setExprTerm(ExprTerm ExprTerm) {
        this.ExprTerm=ExprTerm;
    }

    public ExprAddopTerm getExprAddopTerm() {
        return ExprAddopTerm;
    }

    public void setExprAddopTerm(ExprAddopTerm ExprAddopTerm) {
        this.ExprAddopTerm=ExprAddopTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprTerm!=null) ExprTerm.accept(visitor);
        if(ExprAddopTerm!=null) ExprAddopTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprTerm!=null) ExprTerm.traverseTopDown(visitor);
        if(ExprAddopTerm!=null) ExprAddopTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprTerm!=null) ExprTerm.traverseBottomUp(visitor);
        if(ExprAddopTerm!=null) ExprAddopTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListExpr(\n");

        if(ExprTerm!=null)
            buffer.append(ExprTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprAddopTerm!=null)
            buffer.append(ExprAddopTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListExpr]");
        return buffer.toString();
    }
}
