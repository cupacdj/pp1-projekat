// generated with ast extension for cup
// version 0.8
// 21/0/2025 16:34:36


package rs.ac.bg.etf.pp1.ast;

public class StatementDo extends Statement {

    private DoVisit DoVisit;
    private Statement Statement;
    private ConditionDesignator ConditionDesignator;

    public StatementDo (DoVisit DoVisit, Statement Statement, ConditionDesignator ConditionDesignator) {
        this.DoVisit=DoVisit;
        if(DoVisit!=null) DoVisit.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ConditionDesignator=ConditionDesignator;
        if(ConditionDesignator!=null) ConditionDesignator.setParent(this);
    }

    public DoVisit getDoVisit() {
        return DoVisit;
    }

    public void setDoVisit(DoVisit DoVisit) {
        this.DoVisit=DoVisit;
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
        if(DoVisit!=null) DoVisit.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(ConditionDesignator!=null) ConditionDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DoVisit!=null) DoVisit.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ConditionDesignator!=null) ConditionDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DoVisit!=null) DoVisit.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ConditionDesignator!=null) ConditionDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDo(\n");

        if(DoVisit!=null)
            buffer.append(DoVisit.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
