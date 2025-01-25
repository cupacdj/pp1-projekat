// generated with ast extension for cup
// version 0.8
// 25/0/2025 16:54:45


package rs.ac.bg.etf.pp1.ast;

public class DesignatorExpr extends Designator {

    private DesignatorArray DesignatorArray;
    private ExprList ExprList;

    public DesignatorExpr (DesignatorArray DesignatorArray, ExprList ExprList) {
        this.DesignatorArray=DesignatorArray;
        if(DesignatorArray!=null) DesignatorArray.setParent(this);
        this.ExprList=ExprList;
        if(ExprList!=null) ExprList.setParent(this);
    }

    public DesignatorArray getDesignatorArray() {
        return DesignatorArray;
    }

    public void setDesignatorArray(DesignatorArray DesignatorArray) {
        this.DesignatorArray=DesignatorArray;
    }

    public ExprList getExprList() {
        return ExprList;
    }

    public void setExprList(ExprList ExprList) {
        this.ExprList=ExprList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorArray!=null) DesignatorArray.accept(visitor);
        if(ExprList!=null) ExprList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorArray!=null) DesignatorArray.traverseTopDown(visitor);
        if(ExprList!=null) ExprList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorArray!=null) DesignatorArray.traverseBottomUp(visitor);
        if(ExprList!=null) ExprList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorExpr(\n");

        if(DesignatorArray!=null)
            buffer.append(DesignatorArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprList!=null)
            buffer.append(ExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorExpr]");
        return buffer.toString();
    }
}
