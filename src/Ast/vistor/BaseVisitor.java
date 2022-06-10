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
    public BodyArr1 visitBodyarr1(Parserp.Bodyarr1Context ctx) {
        System.out.println("visit bodyarray1");
        BodyArr1 bodyArr1 = new BodyArr1();
        bodyArr1.setStringArr1(ctx.STRINGARR1().toString());
        System.out.println(bodyArr1.getStringArr1());
        if(ctx.COMMAARR()!=null){
            bodyArr1.setComma(ctx.COMMAARR().toString());
            System.out.println(bodyArr1.getComma());
            bodyArr1.setStringArr2(ctx.STRINGARR2().toString());
            System.out.println(bodyArr1.getStringArr2());
        }
        return bodyArr1;
    }

    @Override
    public BodyArr2 visitBodyarr2(Parserp.Bodyarr2Context ctx) {
        System.out.println("visit bodyarray2");
        BodyArr2 bodyArr2 = new BodyArr2();
        bodyArr2.setNumArr(ctx.NUMarr().toString());
        System.out.println(bodyArr2.getNumArr());
        if(ctx.COMMAARR()!=null){

            bodyArr2.setComma(ctx.COMMAARR().toString());
            System.out.println(bodyArr2.getComma());
            bodyArr2.setNumArr1(ctx.NUMarr1().toString());
            System.out.println(bodyArr2.getNumArr1());
        }
        return bodyArr2;
    }

    @Override
    public BodyArr3 visitBodyarr3(Parserp.Bodyarr3Context ctx) {
        System.out.println("visit bodyarray3");
        BodyArr3 bodyArr3 = new BodyArr3();
        bodyArr3.setVarArr(ctx.VARARR().toString());
        System.out.println(bodyArr3.getVarArr());
        bodyArr3.setArrN(ctx.ARRN().toString());
        System.out.println(bodyArr3.getArrN());
        bodyArr3.setComma(ctx.COMMAARR().toString());
        System.out.println(bodyArr3.getComma());

        if(ctx.VARARR1()!=null){
            bodyArr3.setArrN1(ctx.ARRN1().toString());
            System.out.println(bodyArr3.getArrN1());
        }
        return bodyArr3;
    }

    @Override
    public Object visitVarequal(Parserp.VarequalContext ctx) {
        return super.visitVarequal(ctx);
    }

    @Override
    public Object visitForeach(Parserp.ForeachContext ctx) {
        return super.visitForeach(ctx);
    }

    @Override
    public Object visitForeachp(Parserp.ForeachpContext ctx) {
        return super.visitForeachp(ctx);
    }

    @Override
    public Object visitFor(Parserp.ForContext ctx) {
        return super.visitFor(ctx);
    }

    @Override
    public Object visitForp(Parserp.ForpContext ctx) {
        return super.visitForp(ctx);
    }

    @Override
    public Object visitIfcv(Parserp.IfcvContext ctx) {
        return super.visitIfcv(ctx);
    }

    @Override
    public Object visitIfp(Parserp.IfpContext ctx) {
        return super.visitIfp(ctx);
    }

    @Override
    public Object visitSwitchp(Parserp.SwitchpContext ctx) {
        return super.visitSwitchp(ctx);
    }

    @Override
    public Page visitPages(Parserp.PagesContext ctx) {
        System.out.println("visit page");
        List<DefinitionPage> definitionPages = new ArrayList<>();
        List<DefinitionController> definitionControllers = new ArrayList<>();
        Page page = new Page();
        if (ctx.def_page()!=null){
            for (int i = 0; i < ctx.def_page().size(); i++) {
                definitionPages.add(visitDef_page(ctx.def_page(i)));
        }

        }
         if (ctx.def_controller()!=null){
            for (int i = 0; i < ctx.def_controller().size(); i++) {
                definitionControllers.add(visitDef_controller(ctx.def_controller(i)));
            }
        }


        page.setDefinitionPages(definitionPages);
        return page;
    }

    @Override
    public Link visitLink(Parserp.LinkContext ctx) {
        Link link = new Link();
        link.setLink1(ctx.LINK().toString());
        System.out.println(link.getLink1());
        write(link.getLink1());
        link.setOpenBracket(ctx.OPENC().toString());
        System.out.println(link.getOpenBracket());
        write(link.getOpenBracket());
        link.setTag(ctx.TAG_NAME().toString());
        System.out.println(link.getTag());
        write(link.getTagName());
        link.setCloseBracket(ctx.CLOSEC().toString());
        System.out.println(link.getCloseBracket());
        write(link.getCloseBracket());
        if (ctx.TO()!=null){
            link.setArrow(ctx.TO().toString());
            System.out.println(link.getArrow());
            link.setOpenBracketR(ctx.OPENC1().toString());
            System.out.println(link.getOpenBracketR());
            if (ctx.TAG_NAME1()!=null){
                link.setTagR(ctx.TAG_NAME1().toString());
                System.out.println(link.getTagR());
                link.setCloseBracketR(ctx.CLOSEC1().toString());
                System.out.println(link.getCloseBracketR());
                if (ctx.COMMA1()!=null){
                    link.setComma(ctx.COMMA1().toString());
                    System.out.println(link.getComma());
                    link.setTagRR(ctx.TAG_NAME2().toString());
                    System.out.println(link.getTagRR());
                    link.setCloseBracketR(ctx.CLOSEC1().toString());
                    System.out.println(link.getCloseBracketR());
                }
            }
        }
        link.setSemicolon(ctx.CLOSE().toString());
        System.out.println(link.getSemicolon());

        return link;
    }

    @Override
    public Data visitData(Parserp.DataContext ctx) {

        Data data = new Data();
        data.setData1(ctx.DATA().toString());
        System.out.println(data.getData1());
        write(data.getData1());
        data.setOpenBracket(ctx.OPENC().toString());
        System.out.println(data.getOpenBracket());
        write(data.getOpenBracket());
        data.setTag(ctx.TAG_NAME().toString());
        System.out.println(data.getTag());
        data.setCloseBracket(ctx.CLOSEC().toString());

        if (ctx.TO()!=null){
            data.setArrow(ctx.TO().toString());
            System.out.println(data.getArrow());
            data.setOpenBracketR(ctx.OPENC1().toString());
            System.out.println(data.getOpenBracketR());
            if (ctx.TAG_NAME1()!=null){
                data.setTagR(ctx.TAG_NAME1().toString());
                System.out.println(data.getTagR());
                data.setCloseBracketR(ctx.CLOSEC1().toString());
                System.out.println(data.getCloseBracketR());
                if (ctx.COMMA1()!=null){
                    data.setComma(ctx.COMMA1().toString());
                    System.out.println(data.getComma());
                    data.setTagRR(ctx.TAG_NAME2().toString());
                    System.out.println(data.getTagRR());
                    data.setCloseBracketR(ctx.CLOSEC1().toString());
                    System.out.println(data.getCloseBracketR());
                }
            }
        }
        data.setSemicolon(ctx.CLOSE().toString());
        System.out.println(data.getSemicolon());
        return data;
    }

    @Override
    public BodyController visitBody_controller(Parserp.Body_controllerContext ctx) {
        System.out.println("visit bodaycontroller");
        BodyController bodyController = new BodyController();
        if(ctx.arr()!=null){
            bodyController.setArr(visitArr(ctx.arr()));
            bodyController.setSemiclilon(ctx.CLOSE().toString());
            System.out.println(bodyController.getSemiclilon());
        }



        return bodyController;
    }

    @Override
    public DefinitionController visitDef_controller(Parserp.Def_controllerContext ctx) {
        System.out.println("visit def controller");
        DefinitionController definitionController = new DefinitionController();
        List<BodyController> bodyControllers = new ArrayList<>();
        //BodyController bodyController = new BodyController() ;
        definitionController.setController(ctx.CONTROLLER().toString());
        System.out.println(definitionController.getController());
        definitionController.setTagName(ctx.TAG_NAME().toString());
        System.out.println(definitionController.getTagName());
        definitionController.setControls(ctx.CONTROLS().toString());
        System.out.println(definitionController.getControls());
        definitionController.setTagName2(ctx.TAG_NAME4().toString());
        System.out.println(definitionController.getTagName2());
        if(ctx.COMMA4()!=null){
            definitionController.setComma(ctx.COMMA4().toString());
            System.out.println(definitionController.getComma());
            definitionController.setTagName3(ctx.TAG_NAME5().toString());
            System.out.println(definitionController.getTagName3());
        }
        definitionController.setOpenBracket(ctx.OPENBRACKET4().toString());
        System.out.println(definitionController.getOpenBracket());
        if (ctx.body_controller()!=null){
            for (int i=0;i<ctx.body_controller().size();i++)
                bodyControllers.add(visitBody_controller(ctx.body_controller(i)));

           definitionController.setBodyControllers(bodyControllers);
        }

        definitionController.setCloseBracket(ctx.CLOSEBRACKET().toString());
        System.out.println(definitionController.getCloseBracket());
        return definitionController;
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

        if (ctx.print() != null) {
            bodyPage.setPrint(visitPrint(ctx.print()));
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
        Print print = new Print();
        print.setPrintOpen(ctx.PRINT_OPEN().toString());
        System.out.println(print.getPrintOpen());
        if (ctx.STRINGP()!=null){
            print.setTag(ctx.STRINGP().toString());
            System.out.println(print.getTag());
        }
        if (ctx.VARP()!=null){
            print.setVar(ctx.VARP().toString());
            System.out.println(print.getVar());
        }
        if (ctx.NUMP()!=null){
            print.setNum(ctx.NUMP().toString());
            System.out.println(print.getNum());
        }
        print.setPrintclose(ctx.PRINT_CLOSE().toString());
        System.out.println(print.getPrintclose());
        print.setSemicolon(ctx.CLOSE().toString());
        System.out.println(print.getSemicolon());
        return (Print) super.visitPrint(ctx);
    }

    @Override
    public ARR  visitArr(Parserp.ArrContext ctx) {
        System.out.println("visit arry");
        ARR arr = new ARR();

        arr.setArrayOpen(ctx.ARRAY_OPEN().toString());
        System.out.println(arr.getArrayOpen());

        if (ctx.bodyarr()!=null){
            arr.setArr(visitBodyarr(ctx.bodyarr()));
        }


        arr.setArrayClose(ctx.ARRAY_CLOSE().toString());
        System.out.println(arr.getArrayClose());
        return arr;
    }

    @Override
    public Object visitArrv(Parserp.ArrvContext ctx) {
        return super.visitArrv(ctx);
    }

    @Override
    public BodyArr visitBodyarr(Parserp.BodyarrContext ctx) {
        System.out.println("visit bodyarray");
        BodyArr bodyArr = new BodyArr();
        if(ctx.bodyarr1()!=null){
            bodyArr.setBodyArr1(visitBodyarr1(ctx.bodyarr1()));
        }
        if(ctx.bodyarr2()!=null){
            bodyArr.setBodyArr2(visitBodyarr2(ctx.bodyarr2()));
        }
        if(ctx.bodyarr3()!=null){
            bodyArr.setBodyArr3(visitBodyarr3(ctx.bodyarr3()));
        }
        return bodyArr;
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
    public Object visitIf(Parserp.IfContext ctx) {
        return super.visitIf(ctx);
    }



    @Override
    public Object visitSwitch(Parserp.SwitchContext ctx) {
        return super.visitSwitch(ctx);
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
        Include include = new Include();
        include.setInclude11(ctx.INCLUDE().toString());
        System.out.println(include.getInclude11());
        include.setOpenBracket(ctx.OPENC().toString());
        System.out.println(include.getOpenBracket());

        include.setTagName(ctx.TAG_NAME().toString());
        System.out.println(include.getTagName());

        include.setCloseBracket(ctx.CLOSEC().toString());
        System.out.println(include.getCloseBracket());

        include.setClose(ctx.CLOSE().toString());
        System.out.println(include.getClose());

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
    public void write(String word) {
        try {
            String filename = "src//file.txt";
            FileWriter fw = new FileWriter(filename, true); //the true will append the new data
            fw.write(word + "\n");
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
}
