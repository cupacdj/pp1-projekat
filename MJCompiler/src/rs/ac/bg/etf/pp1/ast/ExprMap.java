// generated with ast extension for cup
// version 0.8
// 4/0/2025 14:38:3


package rs.ac.bg.etf.pp1.ast;

public class ExprMap extends ExprList {

    private DesignatorList DesignatorList;
    private DesignatorList DesignatorList1;

    public ExprMap (DesignatorList DesignatorList, DesignatorList DesignatorList1) {
        this.DesignatorList=DesignatorList;
        if(DesignatorList!=null) DesignatorList.setParent(this);
        this.DesignatorList1=DesignatorList1;
        if(DesignatorList1!=null) DesignatorList1.setParent(this);
    }

    public DesignatorList getDesignatorList() {
        return DesignatorList;
    }

    public void setDesignatorList(DesignatorList DesignatorList) {
        this.DesignatorList=DesignatorList;
    }

    public DesignatorList getDesignatorList1() {
        return DesignatorList1;
    }

    public void setDesignatorList1(DesignatorList DesignatorList1) {
        this.DesignatorList1=DesignatorList1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.accept(visitor);
        if(DesignatorList1!=null) DesignatorList1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorList!=null) DesignatorList.traverseTopDown(visitor);
        if(DesignatorList1!=null) DesignatorList1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.traverseBottomUp(visitor);
        if(DesignatorList1!=null) DesignatorList1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprMap(\n");

        if(DesignatorList!=null)
            buffer.append(DesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorList1!=null)
            buffer.append(DesignatorList1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprMap]");
        return buffer.toString();
    }
}
