// generated with ast extension for cup
// version 0.8
// 8/0/2025 14:29:26


package rs.ac.bg.etf.pp1.ast;

public class DesignatorDEC extends DesignatorStatement {

    public DesignatorDEC () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorDEC(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorDEC]");
        return buffer.toString();
    }
}
