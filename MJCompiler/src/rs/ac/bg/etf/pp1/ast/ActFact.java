// generated with ast extension for cup
// version 0.8
// 5/0/2025 13:3:22


package rs.ac.bg.etf.pp1.ast;

public class ActFact extends FactorExprAct {

    private ActParsZero ActParsZero;

    public ActFact (ActParsZero ActParsZero) {
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
        buffer.append("ActFact(\n");

        if(ActParsZero!=null)
            buffer.append(ActParsZero.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActFact]");
        return buffer.toString();
    }
}
