// generated with ast extension for cup
// version 0.8
// 11/0/2025 20:30:57


package rs.ac.bg.etf.pp1.ast;

public class Term implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private TermMulFactor TermMulFactor;

    public Term (TermMulFactor TermMulFactor) {
        this.TermMulFactor=TermMulFactor;
        if(TermMulFactor!=null) TermMulFactor.setParent(this);
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
        if(TermMulFactor!=null) TermMulFactor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermMulFactor!=null) TermMulFactor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermMulFactor!=null) TermMulFactor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Term(\n");

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
