package Ast.nodes;


public class BodyPage extends DefinitionPage {
    private IN in ;
    private Out out ;
    private Link link ;
    private Data data ;
    private Page_IF page_if ;
    private Print print ;
    private Page_For page_for ;
    private Page_Foreach page_foreach ;
    private Page_Switch page_switch ;
    private Variable variable ;
    private Include include ;

    public IN getIn() {
        return in;
    }

    public Print getPrint() {
        return print;
    }

    public void setPrint(Print print) {
        this.print = print;
    }

    public void setIn(IN in) {
        this.in = in;
    }

    public Out getOut() {
        return out;
    }

    public void setOut(Out out) {
        this.out = out;
    }

    public String getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Page_IF getPage_if() {
        return page_if;
    }

    public void setPage_if(Page_IF page_if) {
        this.page_if = page_if;
    }

    public Page_For getPage_for() {
        return page_for;
    }

    public void setPage_for(Page_For page_for) {
        this.page_for = page_for;
    }

    public Page_Foreach getPage_foreach() {
        return page_foreach;
    }

    public void setPage_foreach(Page_Foreach page_foreach) {
        this.page_foreach = page_foreach;
    }

    public Page_Switch getPage_switch() {
        return page_switch;
    }

    public void setPage_switch(Page_Switch page_switch) {
        this.page_switch = page_switch;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public Include getInclude() {
        return include;
    }

    public void setInclude(Include include) {
        this.include = include;
    }
}
