// generated with ast extension for cup
// version 0.8
// 4/0/2025 14:38:3


package rs.ac.bg.etf.pp1.ast;

public class AddopExprTerm extends ExprAddopTerm {

    private Addop Addop;
    private Term Term;
    private ExprAddopTerm ExprAddopTerm;

    public AddopExprTerm (Addop Addop, Term Term, ExprAddopTerm ExprAddopTerm) {
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.ExprAddopTerm=ExprAddopTerm;
        if(ExprAddopTerm!=null) ExprAddopTerm.setParent(this);
    }

    public Addop getAddop() {
        return Addop;
    }

    public void setAddop(Addop Addop) {
        this.Addop=Addop;
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
        if(Addop!=null) Addop.accept(visitor);
        if(Term!=null) Term.accept(visitor);
        if(ExprAddopTerm!=null) ExprAddopTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(ExprAddopTerm!=null) ExprAddopTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(ExprAddopTerm!=null) ExprAddopTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddopExprTerm(\n");

        if(Addop!=null)
            buffer.append(Addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
        buffer.append(") [AddopExprTerm]");
        return buffer.toString();
    }
}
