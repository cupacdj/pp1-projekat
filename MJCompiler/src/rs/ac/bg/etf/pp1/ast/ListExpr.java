// generated with ast extension for cup
// version 0.8
// 10/0/2025 18:58:12


package rs.ac.bg.etf.pp1.ast;

public class ListExpr extends ExprList {

    private Term Term;
    private ExprAddopTerm ExprAddopTerm;

    public ListExpr (Term Term, ExprAddopTerm ExprAddopTerm) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.ExprAddopTerm=ExprAddopTerm;
        if(ExprAddopTerm!=null) ExprAddopTerm.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
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
        if(Term!=null) Term.accept(visitor);
        if(ExprAddopTerm!=null) ExprAddopTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(ExprAddopTerm!=null) ExprAddopTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(ExprAddopTerm!=null) ExprAddopTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListExpr(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
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
