package Ast.nodes;

public class BodyController extends DefinitionController{
    private ARR arr;
    private String semiclilon;
    private Vairable vairable;

    public ARR getArr() {
        return arr;
    }

    public void setArr(ARR arr) {
        this.arr = arr;
    }

    public String getSemiclilon() {
        return semiclilon;
    }

    public void setSemiclilon(String semiclilon) {
        this.semiclilon = semiclilon;
    }

    public Vairable getVairable() {
        return vairable;
    }

    public void setVairable(Vairable vairable) {
        this.vairable = vairable;
    }
}
