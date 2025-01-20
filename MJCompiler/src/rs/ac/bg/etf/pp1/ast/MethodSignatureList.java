// generated with ast extension for cup
// version 0.8
// 20/0/2025 17:38:7


package rs.ac.bg.etf.pp1.ast;

public class MethodSignatureList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodSignature MethodSignature;
    private FormParsListZero FormParsListZero;

    public MethodSignatureList (MethodSignature MethodSignature, FormParsListZero FormParsListZero) {
        this.MethodSignature=MethodSignature;
        if(MethodSignature!=null) MethodSignature.setParent(this);
        this.FormParsListZero=FormParsListZero;
        if(FormParsListZero!=null) FormParsListZero.setParent(this);
    }

    public MethodSignature getMethodSignature() {
        return MethodSignature;
    }

    public void setMethodSignature(MethodSignature MethodSignature) {
        this.MethodSignature=MethodSignature;
    }

    public FormParsListZero getFormParsListZero() {
        return FormParsListZero;
    }

    public void setFormParsListZero(FormParsListZero FormParsListZero) {
        this.FormParsListZero=FormParsListZero;
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
        if(MethodSignature!=null) MethodSignature.accept(visitor);
        if(FormParsListZero!=null) FormParsListZero.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodSignature!=null) MethodSignature.traverseTopDown(visitor);
        if(FormParsListZero!=null) FormParsListZero.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodSignature!=null) MethodSignature.traverseBottomUp(visitor);
        if(FormParsListZero!=null) FormParsListZero.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodSignatureList(\n");

        if(MethodSignature!=null)
            buffer.append(MethodSignature.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsListZero!=null)
            buffer.append(FormParsListZero.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodSignatureList]");
        return buffer.toString();
    }
}
