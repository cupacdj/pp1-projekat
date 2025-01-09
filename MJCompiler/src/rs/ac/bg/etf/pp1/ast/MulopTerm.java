// generated with ast extension for cup
// version 0.8
// 9/0/2025 15:0:29


package rs.ac.bg.etf.pp1.ast;

public class MulopTerm extends TermMulFactor {

    private TermMulFactor TermMulFactor;
    private Mulop Mulop;
    private FactorList FactorList;

    public MulopTerm (TermMulFactor TermMulFactor, Mulop Mulop, FactorList FactorList) {
        this.TermMulFactor=TermMulFactor;
        if(TermMulFactor!=null) TermMulFactor.setParent(this);
        this.Mulop=Mulop;
        if(Mulop!=null) Mulop.setParent(this);
        this.FactorList=FactorList;
        if(FactorList!=null) FactorList.setParent(this);
    }

    public TermMulFactor getTermMulFactor() {
        return TermMulFactor;
    }

    public void setTermMulFactor(TermMulFactor TermMulFactor) {
        this.TermMulFactor=TermMulFactor;
    }

    public Mulop getMulop() {
        return Mulop;
    }

    public void setMulop(Mulop Mulop) {
        this.Mulop=Mulop;
    }

    public FactorList getFactorList() {
        return FactorList;
    }

    public void setFactorList(FactorList FactorList) {
        this.FactorList=FactorList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermMulFactor!=null) TermMulFactor.accept(visitor);
        if(Mulop!=null) Mulop.accept(visitor);
        if(FactorList!=null) FactorList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermMulFactor!=null) TermMulFactor.traverseTopDown(visitor);
        if(Mulop!=null) Mulop.traverseTopDown(visitor);
        if(FactorList!=null) FactorList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermMulFactor!=null) TermMulFactor.traverseBottomUp(visitor);
        if(Mulop!=null) Mulop.traverseBottomUp(visitor);
        if(FactorList!=null) FactorList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopTerm(\n");

        if(TermMulFactor!=null)
            buffer.append(TermMulFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Mulop!=null)
            buffer.append(Mulop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorList!=null)
            buffer.append(FactorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulopTerm]");
        return buffer.toString();
    }
}
