// generated with ast extension for cup
// version 0.8
// 28/0/2025 16:39:0


package rs.ac.bg.etf.pp1.ast;

public class CondFactExprRelop extends CondFact {

    private ExprList ExprList;
    private Relop Relop;
    private ExprList ExprList1;

    public CondFactExprRelop (ExprList ExprList, Relop Relop, ExprList ExprList1) {
        this.ExprList=ExprList;
        if(ExprList!=null) ExprList.setParent(this);
        this.Relop=Relop;
        if(Relop!=null) Relop.setParent(this);
        this.ExprList1=ExprList1;
        if(ExprList1!=null) ExprList1.setParent(this);
    }

    public ExprList getExprList() {
        return ExprList;
    }

    public void setExprList(ExprList ExprList) {
        this.ExprList=ExprList;
    }

    public Relop getRelop() {
        return Relop;
    }

    public void setRelop(Relop Relop) {
        this.Relop=Relop;
    }

    public ExprList getExprList1() {
        return ExprList1;
    }

    public void setExprList1(ExprList ExprList1) {
        this.ExprList1=ExprList1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprList!=null) ExprList.accept(visitor);
        if(Relop!=null) Relop.accept(visitor);
        if(ExprList1!=null) ExprList1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprList!=null) ExprList.traverseTopDown(visitor);
        if(Relop!=null) Relop.traverseTopDown(visitor);
        if(ExprList1!=null) ExprList1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprList!=null) ExprList.traverseBottomUp(visitor);
        if(Relop!=null) Relop.traverseBottomUp(visitor);
        if(ExprList1!=null) ExprList1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactExprRelop(\n");

        if(ExprList!=null)
            buffer.append(ExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Relop!=null)
            buffer.append(Relop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprList1!=null)
            buffer.append(ExprList1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactExprRelop]");
        return buffer.toString();
    }
}
