// generated with ast extension for cup
// version 0.8
// 9/0/2025 15:0:29


package rs.ac.bg.etf.pp1.ast;

public class MoreFormParsList extends FormParsListMore {

    private FormPar FormPar;
    private VarDeclListMore VarDeclListMore;

    public MoreFormParsList (FormPar FormPar, VarDeclListMore VarDeclListMore) {
        this.FormPar=FormPar;
        if(FormPar!=null) FormPar.setParent(this);
        this.VarDeclListMore=VarDeclListMore;
        if(VarDeclListMore!=null) VarDeclListMore.setParent(this);
    }

    public FormPar getFormPar() {
        return FormPar;
    }

    public void setFormPar(FormPar FormPar) {
        this.FormPar=FormPar;
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
        if(FormPar!=null) FormPar.accept(visitor);
        if(VarDeclListMore!=null) VarDeclListMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPar!=null) FormPar.traverseTopDown(visitor);
        if(VarDeclListMore!=null) VarDeclListMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPar!=null) FormPar.traverseBottomUp(visitor);
        if(VarDeclListMore!=null) VarDeclListMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MoreFormParsList(\n");

        if(FormPar!=null)
            buffer.append(FormPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclListMore!=null)
            buffer.append(VarDeclListMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreFormParsList]");
        return buffer.toString();
    }
}
