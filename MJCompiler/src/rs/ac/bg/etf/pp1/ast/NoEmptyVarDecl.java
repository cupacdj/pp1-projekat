// generated with ast extension for cup
// version 0.8
// 25/0/2025 16:54:45


package rs.ac.bg.etf.pp1.ast;

public class NoEmptyVarDecl extends VarDeclEmpty {

    public NoEmptyVarDecl () {
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
        buffer.append("NoEmptyVarDecl(\n");

        buffer.append(tab);
        buffer.append(") [NoEmptyVarDecl]");
        return buffer.toString();
    }
}
