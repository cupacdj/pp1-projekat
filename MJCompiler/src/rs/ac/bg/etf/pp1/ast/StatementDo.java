// generated with ast extension for cup
// version 0.8
// 3/0/2025 23:21:27


package src.rs.ac.bg.etf.pp1.ast;

public class StatementDo extends Statement {

    private Statement Statement;
    private ConditionDesignator ConditionDesignator;

    public StatementDo (Statement Statement, ConditionDesignator ConditionDesignator) {
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ConditionDesignator=ConditionDesignator;
        if(ConditionDesignator!=null) ConditionDesignator.setParent(this);
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public ConditionDesignator getConditionDesignator() {
        return ConditionDesignator;
    }

    public void setConditionDesignator(ConditionDesignator ConditionDesignator) {
        this.ConditionDesignator=ConditionDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Statement!=null) Statement.accept(visitor);
        if(ConditionDesignator!=null) ConditionDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ConditionDesignator!=null) ConditionDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ConditionDesignator!=null) ConditionDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDo(\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionDesignator!=null)
            buffer.append(ConditionDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDo]");
        return buffer.toString();
    }
}
