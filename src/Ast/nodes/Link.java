package Ast.nodes;

public class Link extends BodyPage{



    private String link1;
    private String openBracket;
    private String tag;
    private String closeBracket;
    private String semicolon;
    private String arrow;
    private String openBracketR;
    private String tagR;
    private String comma;
    private String tagRR;
    private String closeBracketR;

    public String getLink1() {
        return link1;
    }

    public void setLink1(String link1) {
        this.link1 = link1;
    }

    @Override
    public String getOpenBracket() {
        return openBracket;
    }

    @Override
    public void setOpenBracket(String openBracket) {
        this.openBracket = openBracket;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String getCloseBracket() {
        return closeBracket;
    }

    @Override
    public void setCloseBracket(String closeBracket) {
        this.closeBracket = closeBracket;
    }

    public String getSemicolon() {
        return semicolon;
    }

    public void setSemicolon(String semicolon) {
        this.semicolon = semicolon;
    }

    public String getArrow() {
        return arrow;
    }

    public void setArrow(String arrow) {
        this.arrow = arrow;
    }

    public String getOpenBracketR() {
        return openBracketR;
    }

    public void setOpenBracketR(String openBracketR) {
        this.openBracketR = openBracketR;
    }

    public String getTagR() {
        return tagR;
    }

    public void setTagR(String tagR) {
        this.tagR = tagR;
    }

    public String getComma() {
        return comma;
    }

    public void setComma(String comma) {
        this.comma = comma;
    }

    public String getTagRR() {
        return tagRR;
    }

    public void setTagRR(String tagRR) {
        this.tagRR = tagRR;
    }

    public String getCloseBracketR() {
        return closeBracketR;
    }

    public void setCloseBracketR(String closeBracketR) {
        this.closeBracketR = closeBracketR;
    }
}
