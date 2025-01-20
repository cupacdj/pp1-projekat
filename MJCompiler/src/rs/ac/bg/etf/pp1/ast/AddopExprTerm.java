// generated with ast extension for cup
// version 0.8
// 20/0/2025 17:38:7


package rs.ac.bg.etf.pp1.ast;

public class AddopExprTerm extends ExprAddopTerm {

    private ExprAddopTerm ExprAddopTerm;
    private Addop Addop;
    private Term Term;

    public AddopExprTerm (ExprAddopTerm ExprAddopTerm, Addop Addop, Term Term) {
        this.ExprAddopTerm=ExprAddopTerm;
        if(ExprAddopTerm!=null) ExprAddopTerm.setParent(this);
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public ExprAddopTerm getExprAddopTerm() {
        return ExprAddopTerm;
    }

    public void setExprAddopTerm(ExprAddopTerm ExprAddopTerm) {
        this.ExprAddopTerm=ExprAddopTerm;
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprAddopTerm!=null) ExprAddopTerm.accept(visitor);
        if(Addop!=null) Addop.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprAddopTerm!=null) ExprAddopTerm.traverseTopDown(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprAddopTerm!=null) ExprAddopTerm.traverseBottomUp(visitor);
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddopExprTerm(\n");

        if(ExprAddopTerm!=null)
            buffer.append(ExprAddopTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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

        buffer.append(tab);
        buffer.append(") [AddopExprTerm]");
        return buffer.toString();
    }
}
