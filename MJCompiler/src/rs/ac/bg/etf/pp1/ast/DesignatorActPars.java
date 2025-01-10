// generated with ast extension for cup
// version 0.8
// 10/0/2025 12:59:8


package rs.ac.bg.etf.pp1.ast;

public class DesignatorActPars extends DesignatorStatement {

    private ActParsZero ActParsZero;

    public DesignatorActPars (ActParsZero ActParsZero) {
        this.ActParsZero=ActParsZero;
        if(ActParsZero!=null) ActParsZero.setParent(this);
    }

    public ActParsZero getActParsZero() {
        return ActParsZero;
    }

    public void setActParsZero(ActParsZero ActParsZero) {
        this.ActParsZero=ActParsZero;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsZero!=null) ActParsZero.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsZero!=null) ActParsZero.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsZero!=null) ActParsZero.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorActPars(\n");

        if(ActParsZero!=null)
            buffer.append(ActParsZero.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorActPars]");
        return buffer.toString();
    }
}
