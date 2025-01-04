// generated with ast extension for cup
// version 0.8
// 4/0/2025 23:33:36


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignator extends Factor {

    private DesignatorList DesignatorList;
    private FactorActPars FactorActPars;

    public FactorDesignator (DesignatorList DesignatorList, FactorActPars FactorActPars) {
        this.DesignatorList=DesignatorList;
        if(DesignatorList!=null) DesignatorList.setParent(this);
        this.FactorActPars=FactorActPars;
        if(FactorActPars!=null) FactorActPars.setParent(this);
    }

    public DesignatorList getDesignatorList() {
        return DesignatorList;
    }

    public void setDesignatorList(DesignatorList DesignatorList) {
        this.DesignatorList=DesignatorList;
    }

    public FactorActPars getFactorActPars() {
        return FactorActPars;
    }

    public void setFactorActPars(FactorActPars FactorActPars) {
        this.FactorActPars=FactorActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.accept(visitor);
        if(FactorActPars!=null) FactorActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorList!=null) DesignatorList.traverseTopDown(visitor);
        if(FactorActPars!=null) FactorActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.traverseBottomUp(visitor);
        if(FactorActPars!=null) FactorActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignator(\n");

        if(DesignatorList!=null)
            buffer.append(DesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorActPars!=null)
            buffer.append(FactorActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignator]");
        return buffer.toString();
    }
}
