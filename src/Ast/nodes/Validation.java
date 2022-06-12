package Ast.nodes;

import java.util.List;

public class Validation extends BodyController{
    private String validation1;
    private String openC;
    private String Req;
    private String closeC;
    private String openBracket;
    private List<String> str;
    private List<String> validstr;
    private List<String> or;
    private List<String> or1;
    private List<String> semicolon;
    private List<Valid>valids;
    private List<Valid1>valid1s;
    private String closeBracket;

    public String getValidation1() {
        return validation1;
    }

    public void setValidation1(String validation1) {
        this.validation1 = validation1;
    }

    public String getOpenC() {
        return openC;
    }

    public void setOpenC(String openC) {
        this.openC = openC;
    }

    public String getReq() {
        return Req;
    }

    public void setReq(String req) {
        Req = req;
    }

    public String getCloseC() {
        return closeC;
    }

    public void setCloseC(String closeC) {
        this.closeC = closeC;
    }

    @Override
    public String getOpenBracket() {
        return openBracket;
    }

    @Override
    public void setOpenBracket(String openBracket) {
        this.openBracket = openBracket;
    }

    public List<String> getStr() {
        return str;
    }

    public void setStr(List<String> str) {
        this.str = str;
    }

    public List<String> getValidstr() {
        return validstr;
    }

    public void setValidstr(List<String> valid) {
        this.validstr = valid;
    }

    public List<String> getOr() {
        return or;
    }

    public void setOr(List<String> or) {
        this.or = or;
    }

    public List<String> getOr1() {
        return or1;
    }

    public void setOr1(List<String> or1) {
        this.or1 = or1;
    }

    public List<String> getSemicolon() {
        return semicolon;
    }

    public void setSemicolon(List<String> semicolon) {
        this.semicolon = semicolon;
    }

    public List<Valid> getValids() {
        return valids;
    }

    public void setValids(List<Valid> valids) {
        this.valids = valids;
    }

    public List<Valid1> getValid1s() {
        return valid1s;
    }

    public void setValid1s(List<Valid1> valid1s) {
        this.valid1s = valid1s;
    }

    @Override
    public String getCloseBracket() {
        return closeBracket;
    }

    @Override
    public void setCloseBracket(String closeBracket) {
        this.closeBracket = closeBracket;
    }
}
