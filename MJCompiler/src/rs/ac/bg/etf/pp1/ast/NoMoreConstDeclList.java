// generated with ast extension for cup
// version 0.8
// 23/0/2025 18:6:31


package rs.ac.bg.etf.pp1.ast;

public class NoMoreConstDeclList extends ConstDeclListMore {

    public NoMoreConstDeclList () {
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
        buffer.append("NoMoreConstDeclList(\n");

        buffer.append(tab);
        buffer.append(") [NoMoreConstDeclList]");
        return buffer.toString();
    }
}
