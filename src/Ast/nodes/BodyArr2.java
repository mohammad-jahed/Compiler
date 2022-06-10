package Ast.nodes;

public class BodyArr2 extends BodyArr {
    private String numArr;
    private String comma;
    private String numArr1;

    public String getNumArr() {
        return numArr;
    }

    public void setNumArr(String numArr) {
        this.numArr = numArr;
    }

    @Override
    public String getComma() {
        return comma;
    }

    @Override
    public void setComma(String comma) {
        this.comma = comma;
    }

    public String getNumArr1() {
        return numArr1;
    }

    public void setNumArr1(String numArr1) {
        this.numArr1 = numArr1;
    }
}
