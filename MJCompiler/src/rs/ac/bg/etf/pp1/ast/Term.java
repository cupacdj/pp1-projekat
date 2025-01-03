// generated with ast extension for cup
// version 0.8
// 3/0/2025 23:21:27


package src.rs.ac.bg.etf.pp1.ast;

public class Term implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Factor Factor;
    private TermMulFactor TermMulFactor;

    public Term (Factor Factor, TermMulFactor TermMulFactor) {
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
        this.TermMulFactor=TermMulFactor;
        if(TermMulFactor!=null) TermMulFactor.setParent(this);
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public TermMulFactor getTermMulFactor() {
        return TermMulFactor;
    }

    public void setTermMulFactor(TermMulFactor TermMulFactor) {
        this.TermMulFactor=TermMulFactor;
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
        if(Factor!=null) Factor.accept(visitor);
        if(TermMulFactor!=null) TermMulFactor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
        if(TermMulFactor!=null) TermMulFactor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        if(TermMulFactor!=null) TermMulFactor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Term(\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TermMulFactor!=null)
            buffer.append(TermMulFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Term]");
        return buffer.toString();
    }
}
