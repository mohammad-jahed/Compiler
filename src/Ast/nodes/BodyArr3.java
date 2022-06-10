package Ast.nodes;

public class BodyArr3 extends BodyArr{

    private String varArr;
    private String arrN;
    private String comma;
    private String varArr1;
    private String  arrN1;

    public String getVarArr() {
        return varArr;
    }

    public void setVarArr(String varArr) {
        this.varArr = varArr;
    }

    public String getArrN() {
        return arrN;
    }

    public void setArrN(String arrN) {
        this.arrN = arrN;
    }

    @Override
    public String getComma() {
        return comma;
    }

    @Override
    public void setComma(String comma) {
        this.comma = comma;
    }

    public String getVarArr1() {
        return varArr1;
    }

    public void setVarArr1(String varArr1) {
        this.varArr1 = varArr1;
    }

    public String getArrN1() {
        return arrN1;
    }

    public void setArrN1(String arrN1) {
        this.arrN1 = arrN1;
    }
}
