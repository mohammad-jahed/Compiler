package Ast.nodes;

public class BodyFor extends For{
    private BodyForFirstVar bodyForFirstVar;
    private String BdyFor;
    private BodyForSecondVar bodyForSecondVar;

    public BodyForFirstVar getBodyForFirstVar() {
        return bodyForFirstVar;
    }

    public void setBodyForFirstVar(BodyForFirstVar bodyForFirstVar) {
        this.bodyForFirstVar = bodyForFirstVar;
    }

    public String getBdyFor() {
        return BdyFor;
    }

    public void setBdyFor(String bdyFor) {
        BdyFor = bdyFor;
    }

    public BodyForSecondVar getBodyForSecondVar() {
        return bodyForSecondVar;
    }

    public void setBodyForSecondVar(BodyForSecondVar bodyForSecondVar) {
        this.bodyForSecondVar = bodyForSecondVar;
    }
}
