// generated with ast extension for cup
// version 0.8
// 28/0/2025 16:39:0


package rs.ac.bg.etf.pp1.ast;

public class ListExpr extends ExprList {

    private ExprAddopTerm ExprAddopTerm;

    public ListExpr (ExprAddopTerm ExprAddopTerm) {
        this.ExprAddopTerm=ExprAddopTerm;
        if(ExprAddopTerm!=null) ExprAddopTerm.setParent(this);
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
        if(ExprAddopTerm!=null) ExprAddopTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprAddopTerm!=null) ExprAddopTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprAddopTerm!=null) ExprAddopTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListExpr(\n");

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
