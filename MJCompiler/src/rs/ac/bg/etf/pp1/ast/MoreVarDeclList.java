// generated with ast extension for cup
// version 0.8
// 10/0/2025 12:59:8


package rs.ac.bg.etf.pp1.ast;

public class MoreVarDeclList extends VarDeclListMore {

    private VarDecl VarDecl;
    private VarDeclListMore VarDeclListMore;

    public MoreVarDeclList (VarDecl VarDecl, VarDeclListMore VarDeclListMore) {
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
        this.VarDeclListMore=VarDeclListMore;
        if(VarDeclListMore!=null) VarDeclListMore.setParent(this);
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public VarDeclListMore getVarDeclListMore() {
        return VarDeclListMore;
    }

    public void setVarDeclListMore(VarDeclListMore VarDeclListMore) {
        this.VarDeclListMore=VarDeclListMore;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDecl!=null) VarDecl.accept(visitor);
        if(VarDeclListMore!=null) VarDeclListMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
        if(VarDeclListMore!=null) VarDeclListMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        if(VarDeclListMore!=null) VarDeclListMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MoreVarDeclList(\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclListMore!=null)
            buffer.append(VarDeclListMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreVarDeclList]");
        return buffer.toString();
    }
}
