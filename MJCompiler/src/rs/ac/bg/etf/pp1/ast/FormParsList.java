// generated with ast extension for cup
// version 0.8
// 5/0/2025 13:3:22


package rs.ac.bg.etf.pp1.ast;

public class FormParsList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private FormPar FormPar;
    private FormParsListMore FormParsListMore;

    public FormParsList (FormPar FormPar, FormParsListMore FormParsListMore) {
        this.FormPar=FormPar;
        if(FormPar!=null) FormPar.setParent(this);
        this.FormParsListMore=FormParsListMore;
        if(FormParsListMore!=null) FormParsListMore.setParent(this);
    }

    public FormPar getFormPar() {
        return FormPar;
    }

    public void setFormPar(FormPar FormPar) {
        this.FormPar=FormPar;
    }

    public FormParsListMore getFormParsListMore() {
        return FormParsListMore;
    }

    public void setFormParsListMore(FormParsListMore FormParsListMore) {
        this.FormParsListMore=FormParsListMore;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormPar!=null) FormPar.accept(visitor);
        if(FormParsListMore!=null) FormParsListMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPar!=null) FormPar.traverseTopDown(visitor);
        if(FormParsListMore!=null) FormParsListMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPar!=null) FormPar.traverseBottomUp(visitor);
        if(FormParsListMore!=null) FormParsListMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsList(\n");

        if(FormPar!=null)
            buffer.append(FormPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsListMore!=null)
            buffer.append(FormParsListMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsList]");
        return buffer.toString();
    }
}
