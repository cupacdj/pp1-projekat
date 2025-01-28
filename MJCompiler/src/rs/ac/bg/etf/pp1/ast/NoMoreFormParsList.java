// generated with ast extension for cup
// version 0.8
// 28/0/2025 16:12:25


package rs.ac.bg.etf.pp1.ast;

public class NoMoreFormParsList extends FormParsListMore {

    public NoMoreFormParsList () {
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
        buffer.append("NoMoreFormParsList(\n");

        buffer.append(tab);
        buffer.append(") [NoMoreFormParsList]");
        return buffer.toString();
    }
}
