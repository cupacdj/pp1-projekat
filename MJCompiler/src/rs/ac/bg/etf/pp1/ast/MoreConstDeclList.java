// generated with ast extension for cup
// version 0.8
// 3/0/2025 23:21:27


package src.rs.ac.bg.etf.pp1.ast;

public class MoreConstDeclList extends ConstDeclListMore {

    private ConstDecl ConstDecl;
    private ConstDeclListMore ConstDeclListMore;

    public MoreConstDeclList (ConstDecl ConstDecl, ConstDeclListMore ConstDeclListMore) {
        this.ConstDecl=ConstDecl;
        if(ConstDecl!=null) ConstDecl.setParent(this);
        this.ConstDeclListMore=ConstDeclListMore;
        if(ConstDeclListMore!=null) ConstDeclListMore.setParent(this);
    }

    public ConstDecl getConstDecl() {
        return ConstDecl;
    }

    public void setConstDecl(ConstDecl ConstDecl) {
        this.ConstDecl=ConstDecl;
    }

    public ConstDeclListMore getConstDeclListMore() {
        return ConstDeclListMore;
    }

    public void setConstDeclListMore(ConstDeclListMore ConstDeclListMore) {
        this.ConstDeclListMore=ConstDeclListMore;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDecl!=null) ConstDecl.accept(visitor);
        if(ConstDeclListMore!=null) ConstDeclListMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDecl!=null) ConstDecl.traverseTopDown(visitor);
        if(ConstDeclListMore!=null) ConstDeclListMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDecl!=null) ConstDecl.traverseBottomUp(visitor);
        if(ConstDeclListMore!=null) ConstDeclListMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MoreConstDeclList(\n");

        if(ConstDecl!=null)
            buffer.append(ConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclListMore!=null)
            buffer.append(ConstDeclListMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreConstDeclList]");
        return buffer.toString();
    }
}
