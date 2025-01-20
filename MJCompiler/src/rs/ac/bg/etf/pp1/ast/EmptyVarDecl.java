// generated with ast extension for cup
// version 0.8
// 20/0/2025 20:47:40


package rs.ac.bg.etf.pp1.ast;

public class EmptyVarDecl extends VarDeclEmpty {

    private VarDeclEmpty VarDeclEmpty;
    private VarDeclList VarDeclList;

    public EmptyVarDecl (VarDeclEmpty VarDeclEmpty, VarDeclList VarDeclList) {
        this.VarDeclEmpty=VarDeclEmpty;
        if(VarDeclEmpty!=null) VarDeclEmpty.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
    }

    public VarDeclEmpty getVarDeclEmpty() {
        return VarDeclEmpty;
    }

    public void setVarDeclEmpty(VarDeclEmpty VarDeclEmpty) {
        this.VarDeclEmpty=VarDeclEmpty;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclEmpty!=null) VarDeclEmpty.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclEmpty!=null) VarDeclEmpty.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclEmpty!=null) VarDeclEmpty.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EmptyVarDecl(\n");

        if(VarDeclEmpty!=null)
            buffer.append(VarDeclEmpty.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EmptyVarDecl]");
        return buffer.toString();
    }
}
