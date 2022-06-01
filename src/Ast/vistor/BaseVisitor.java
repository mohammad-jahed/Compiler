package Ast.vistor;


import Ast.nodes.*;
import gen.Parserp;
import gen.ParserpBaseVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import sun.applet.Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseVisitor extends ParserpBaseVisitor {
    @Override
    public Page visitPages(Parserp.PagesContext ctx) {
        List<DefinitionPage> definitionPages = new ArrayList<>();
        List<DefinitionController> definitionControllers = new ArrayList<>();
        Page page = new Page();
        for (int i = 0; i < ctx.def_page().size(); i++) {
            definitionPages.add(visitDef_page(ctx.def_page(i)));
        }
        page.setDefinitionPages(definitionPages);
        return page;
    }

    @Override
    public Link visitLink(Parserp.LinkContext ctx) {
        Link link = new Link();
        link.setLink(ctx.LINK().toString());
        System.out.println(link.getLink());
        link.setOpenBracket(ctx.OPENC().toString());
        System.out.println(link.getOpenBracket());
        link.setTag(ctx.TAG_NAME().toString());
        System.out.println(link.getTag());
        link.setCloseBracket(ctx.CLOSEC().toString());

        if (ctx.TO()!=null){
            link.setArrow(ctx.TO().toString());
            System.out.println(link.getArrow());
            link.setOpenBracketR(ctx.OPENC().toString());
            System.out.println(link.getOpenBracketR());
            if (ctx.TAG_NAME()!=null){
                link.setTagR(ctx.TAG_NAME().toString());
                System.out.println(link.getTagR());
                if (ctx.COMMA()!=null){
                    link.setComma(ctx.COMMA().toString());
                    System.out.println(link.getComma());
                    link.setTagRR(ctx.TAG_NAME().toString());
                    System.out.println(link.getTagRR());
                    link.setCloseBracketR(ctx.CLOSEC().toString());
                    System.out.println(link.getCloseBracketR());
                }
            }
        }
        link.setSemicolon(ctx.CLOSE().toString());
        System.out.println(link.getSemicolon());

        return (Link) super.visitLink(ctx);
    }

    @Override
    public Data visitData(Parserp.DataContext ctx) {
        return (Data) super.visitData(ctx);
    }

    @Override
    public Object visitBody_controller(Parserp.Body_controllerContext ctx) {
        return super.visitBody_controller(ctx);
    }

    @Override
    public Object visitDef_controller(Parserp.Def_controllerContext ctx) {
        return super.visitDef_controller(ctx);
    }

    @Override
    public DefinitionPage visitDef_page(Parserp.Def_pageContext ctx) {
        System.out.println("i visited def-page");
        DefinitionPage definitionPage = new DefinitionPage();

        List<BodyPage> bodyPages = new ArrayList<>();

        definitionPage.setBodyPages(bodyPages);
        definitionPage.setPage(ctx.PAGE().toString());
        definitionPage.setTagName(ctx.TAG_NAME().toString());
        definitionPage.setOpenBracket(ctx.OPENBRACKET().toString());
        definitionPage.setCloseBracket(ctx.CLOSEBRACKET().toString());
        System.out.println(definitionPage.getPage());
        System.out.println(definitionPage.getTagName().substring(1, definitionPage.getTagName().length() - 1));
        System.out.println(definitionPage.getOpenBracket());


        for (int i = 0; i < ctx.body_page().size(); i++) {
            bodyPages.add(visitBody_page(ctx.body_page(i)));
        }
        System.out.println(definitionPage.getCloseBracket());

        return definitionPage;
    }

    @Override
    public BodyPage visitBody_page(Parserp.Body_pageContext ctx) {
        BodyPage bodyPage = new BodyPage();
        if (ctx.in() != null) {
            bodyPage.setIn(visitIn(ctx.in()));
        }
        if (ctx.out() != null) {
            bodyPage.setOut(visitOut(ctx.out()));
        }
        if (ctx.link() != null) {
            bodyPage.setLink(visitLink(ctx.link()));
        }
        if (ctx.data() != null) {
            bodyPage.setData(visitData(ctx.data()));
        }
        if (ctx.ifp() != null) {
            bodyPage.setPage_if(visitIfp(ctx.ifp()));
        }
        if (ctx.print() != null) {
            bodyPage.setPrint(visitPrint(ctx.print()));
        }
        if (ctx.varequal() != null) {
            bodyPage.setVariable(visitVarequal(ctx.varequal()));
        }
        if (ctx.foreachp() != null) {
            bodyPage.setPage_foreach(visitForeachp(ctx.foreachp()));
        }
        if (ctx.forp() != null) {
            bodyPage.setPage_for(visitForp(ctx.forp()));
        }
        if (ctx.switchp() != null) {
            bodyPage.setPage_switch(visitSwitchp(ctx.switchp()));
        }
        if (ctx.include() != null) {
            bodyPage.setInclude(visitInclude(ctx.include()));
        }


        return bodyPage;
    }

    @Override
    public BodyIn visitBodyIN(Parserp.BodyINContext ctx) {
        return (BodyIn) super.visitBodyIN(ctx);
    }

    @Override
    public BodyOut visitBodyOUT(Parserp.BodyOUTContext ctx) {
        return (BodyOut) super.visitBodyOUT(ctx);
    }

    @Override
    public IN visitIn(Parserp.InContext ctx) {
        IN in = new IN();
        in.setInOpen(ctx.IN_OPEN().toString());
        System.out.println(in.getInOpen());
        if (ctx.COLOR() != null) {
            in.setColor(ctx.COLOR().toString());
            System.out.println(in.getColor());
            in.setOpenBracket(ctx.OPENP().toString());
            System.out.println(in.getOpenBracket());
            in.setColorText(ctx.H().toString());
            System.out.println(in.getColor());
        }
        if (ctx.EMAIL() != null) {
            in.setEmail(ctx.EMAIL().toString());
            System.out.println(in.getEmail());
            in.setOpenBracket(ctx.OPENP().toString());
            System.out.println(in.getOpenBracket());
            in.setEmailText(ctx.E().toString());
            System.out.println(in.getEmailText());
        }
        if (ctx.FILE() != null) {
            in.setFile(ctx.FILE().toString());
            in.setOpenBracket(ctx.OPENP().toString());
            in.setPath(ctx.PATH().toString());
        }
        if (ctx.IMAGEIN() != null) {
            in.setImageIn(ctx.IMAGEIN().toString());
            in.setOpenBracket(ctx.OPENP().toString());
            in.setPath(ctx.PATH().toString());
        }
        if (ctx.NUAMIN() != null) {
            in.setTag(ctx.NUAMIN().toString());
            in.setOpenBracket(ctx.OPENP().toString());
            in.setTagText(ctx.N().toString());
        }
        in.setCloseBracket(ctx.CLOSEP().toString());
        System.out.println(in.getCloseBracket());
        if (ctx.bodyIN() != null) {
            in.setBodyIn(visitBodyIN(ctx.bodyIN()));
        }
        in.setSemiColon(ctx.IN_CLOSE().toString());
        System.out.println(in.getSemiColon());
        return in;
    }

    @Override
    public Out visitOut(Parserp.OutContext ctx) {
        Out out = new Out();
        out.setName(ctx.OUT_OPEN().toString());
        if(ctx.TEXT()!=null){
            out.setText(ctx.TEXT().toString());
            out.setOpenBracket(ctx.OPENPOUT().toString());
            out.setTagName(ctx.NOUT().toString());
        }
        if(ctx.IMAGEOUT()!=null){
            out.setImage(ctx.IMAGEOUT().toString());
            out.setOpenBracket(ctx.OPENPOUT().toString());
            out.setPath(ctx.PATHOUT().toString());
        }

        out.setCloseBracket(ctx.CLOSEPOUT().toString());
        if(ctx.bodyOUT()!=null){
            out.setBodyOut(visitBodyOUT(ctx.bodyOUT()));
        }
        out.setSemiColon(ctx.OUT_CLOSE().toString());
        System.out.println(out.getSemiColon());
        return (Out) super.visitOut(ctx);
    }

    @Override
    public Print visitPrint(Parserp.PrintContext ctx) {
        return (Print) super.visitPrint(ctx);
    }

    @Override
    public Object visitArr(Parserp.ArrContext ctx) {
        return super.visitArr(ctx);
    }

    @Override
    public Object visitArrv(Parserp.ArrvContext ctx) {
        return super.visitArrv(ctx);
    }

    @Override
    public Object visitBodyarr(Parserp.BodyarrContext ctx) {
        return super.visitBodyarr(ctx);
    }

    @Override
    public Variable visitVarequal(Parserp.VarequalContext ctx) {
        return (Variable) super.visitVarequal(ctx);
    }

    @Override
    public Object visitForeach(Parserp.ForeachContext ctx) {
        return super.visitForeach(ctx);
    }

    @Override
    public Page_Foreach visitForeachp(Parserp.ForeachpContext ctx) {
        return (Page_Foreach) super.visitForeachp(ctx);
    }

    @Override
    public Object visitFor(Parserp.ForContext ctx) {
        return super.visitFor(ctx);
    }

    @Override
    public Page_For visitForp(Parserp.ForpContext ctx) {
        return (Page_For) super.visitForp(ctx);
    }

    @Override
    public Object visitBodyfor(Parserp.BodyforContext ctx) {
        return super.visitBodyfor(ctx);
    }

    @Override
    public Object visitBodyforeach(Parserp.BodyforeachContext ctx) {
        return super.visitBodyforeach(ctx);
    }

    @Override
    public Object visitBodyifc(Parserp.BodyifcContext ctx) {
        return super.visitBodyifc(ctx);
    }

    @Override
    public Object visitBody(Parserp.BodyContext ctx) {
        return super.visitBody(ctx);
    }

    @Override
    public Object visitBodyP(Parserp.BodyPContext ctx) {
        return super.visitBodyP(ctx);
    }

    @Override
    public Object visitGoto(Parserp.GotoContext ctx) {
        return super.visitGoto(ctx);
    }

    @Override
    public Object visitIfc(Parserp.IfcContext ctx) {
        return super.visitIfc(ctx);
    }

    @Override
    public Object visitIfcv(Parserp.IfcvContext ctx) {
        return super.visitIfcv(ctx);
    }

    @Override
    public Object visitIf(Parserp.IfContext ctx) {
        return super.visitIf(ctx);
    }

    @Override
    public Page_IF visitIfp(Parserp.IfpContext ctx) {
        return (Page_IF) super.visitIfp(ctx);
    }

    @Override
    public Object visitSwitch(Parserp.SwitchContext ctx) {
        return super.visitSwitch(ctx);
    }

    @Override
    public Page_Switch visitSwitchp(Parserp.SwitchpContext ctx) {
        return (Page_Switch) super.visitSwitchp(ctx);
    }

    @Override
    public Object visitBody_switch(Parserp.Body_switchContext ctx) {
        return super.visitBody_switch(ctx);
    }

    @Override
    public Object visitF(Parserp.FContext ctx) {
        return super.visitF(ctx);
    }

    @Override
    public Include visitInclude(Parserp.IncludeContext ctx) {
        return (Include) super.visitInclude(ctx);
    }

    @Override
    public Object visitValidn(Parserp.ValidnContext ctx) {
        return super.visitValidn(ctx);
    }

    @Override
    public Object visitValid(Parserp.ValidContext ctx) {
        return super.visitValid(ctx);
    }

    @Override
    public Object visitValidation(Parserp.ValidationContext ctx) {
        return super.visitValidation(ctx);
    }

    @Override
    public Object visit(ParseTree tree) {
        return super.visit(tree);
    }

    @Override
    public Object visitChildren(RuleNode node) {
        return super.visitChildren(node);
    }

    @Override
    public Object visitTerminal(TerminalNode node) {
        return super.visitTerminal(node);
    }

    @Override
    public Object visitErrorNode(ErrorNode node) {
        return super.visitErrorNode(node);
    }

    @Override
    protected Object defaultResult() {
        return super.defaultResult();
    }

    @Override
    protected Object aggregateResult(Object aggregate, Object nextResult) {
        return super.aggregateResult(aggregate, nextResult);
    }

    @Override
    protected boolean shouldVisitNextChild(RuleNode node, Object currentResult) {
        return super.shouldVisitNextChild(node, currentResult);
    }
   /* public void write(String word) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\tokens.txt"));
            bufferedWriter.write(word+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
