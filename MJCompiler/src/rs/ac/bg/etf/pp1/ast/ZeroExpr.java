// generated with ast extension for cup
// version 0.8
// 4/0/2025 14:38:3


package rs.ac.bg.etf.pp1.ast;

public class ZeroExpr extends ExprZero {

    private ExprList ExprList;

    public ZeroExpr (ExprList ExprList) {
        this.ExprList=ExprList;
        if(ExprList!=null) ExprList.setParent(this);
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
        if(ExprList!=null) ExprList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprList!=null) ExprList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprList!=null) ExprList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ZeroExpr(\n");

        if(ExprList!=null)
            buffer.append(ExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ZeroExpr]");
        return buffer.toString();
    }
}
