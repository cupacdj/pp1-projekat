// generated with ast extension for cup
// version 0.8
// 20/0/2025 20:47:40


package rs.ac.bg.etf.pp1.ast;

public class ElseStmtNo extends StatementElse {

    public ElseStmtNo () {
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
        buffer.append("ElseStmtNo(\n");

        buffer.append(tab);
        buffer.append(") [ElseStmtNo]");
        return buffer.toString();
    }
}
