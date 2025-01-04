// generated with ast extension for cup
// version 0.8
// 4/0/2025 23:33:36


package rs.ac.bg.etf.pp1.ast;

public class FactorNew extends Factor {

    private Type Type;
    private FactorExprAct FactorExprAct;

    public FactorNew (Type Type, FactorExprAct FactorExprAct) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FactorExprAct=FactorExprAct;
        if(FactorExprAct!=null) FactorExprAct.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FactorExprAct getFactorExprAct() {
        return FactorExprAct;
    }

    public void setFactorExprAct(FactorExprAct FactorExprAct) {
        this.FactorExprAct=FactorExprAct;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FactorExprAct!=null) FactorExprAct.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FactorExprAct!=null) FactorExprAct.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FactorExprAct!=null) FactorExprAct.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNew(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorExprAct!=null)
            buffer.append(FactorExprAct.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNew]");
        return buffer.toString();
    }
}
