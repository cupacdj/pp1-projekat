// generated with ast extension for cup
// version 0.8
// 10/0/2025 12:59:8


package rs.ac.bg.etf.pp1.ast;

public class StatementReturn extends Statement {

    private ExprZero ExprZero;

    public StatementReturn (ExprZero ExprZero) {
        this.ExprZero=ExprZero;
        if(ExprZero!=null) ExprZero.setParent(this);
    }

    public ExprZero getExprZero() {
        return ExprZero;
    }

    public void setExprZero(ExprZero ExprZero) {
        this.ExprZero=ExprZero;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprZero!=null) ExprZero.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprZero!=null) ExprZero.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprZero!=null) ExprZero.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementReturn(\n");

        if(ExprZero!=null)
            buffer.append(ExprZero.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementReturn]");
        return buffer.toString();
    }
}
