package Ast.vistor;


import Ast.nodes.*;
import gen.Parserp;
import gen.ParserpBaseVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
//import sun.applet.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseVisitor extends ParserpBaseVisitor {

    public ArrayList<String> strings = new ArrayList<>();
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
    public Vairable visitVarequal(Parserp.VarequalContext ctx) {
        Vairable vairable = new Vairable();
        List<String>nums = new ArrayList<>();
        vairable.setVarname(ctx.STRINGG().toString());
        System.out.println(vairable.getVarname());
        vairable.setEqu(ctx.EQUALVAR().toString());
        System.out.println(vairable.getEqu());
        if (ctx.arrv()!=null){
            vairable.setArray(visitArrv(ctx.arrv()));
        }
        if (ctx.NUME()!=null){
            for (int i=0;i<ctx.NUME().size();i++){
                nums.add(ctx.NUME(i).toString());
                System.out.println(ctx.NUME(i));
            }
            vairable.setNums(nums);

        }
        if (ctx.ST()!=null){
            vairable.setSt(ctx.ST().toString());
            System.out.println(vairable.getSt());
        }
        vairable.setSemicolon(ctx.VAREQUAL_CLOSE().toString());
        System.out.println(vairable.getSemicolon());
        return vairable;
    }

    @Override
    public ForEach visitForeach(Parserp.ForeachContext ctx) {
        ForEach forEach = new ForEach();
        List<Body> bodies = new ArrayList<>();
        forEach.setForeachOpen(ctx.FOREACHC_OPEN().toString());
        System.out.println(forEach.getForeachOpen());
        forEach.setBodyForeach(visitBodyforeach(ctx.bodyforeach()));
        forEach.setForeachClose(ctx.FOREACH_CLOSE().toString());
        System.out.println(forEach.getForeachClose());
        forEach.setOpenBracket(ctx.OPENBRACKET().toString());
        System.out.println(forEach.getOpenBracket());
        for (int i=0;i<ctx.body().size();i++){
            bodies.add(visitBody(ctx.body(i)));
        }
        forEach.setBodies(bodies);
        forEach.setCloseBracket(ctx.CLOSEBRACKET().toString());
        System.out.println(forEach.getCloseBracket());
        return forEach;
    }

    @Override
    public Object visitForeachp(Parserp.ForeachpContext ctx) {
        return super.visitForeachp(ctx);
    }

    @Override
    public For visitFor(Parserp.ForContext ctx) {
        For forr = new For();
        List<Body> bodies = new ArrayList<>();
        forr.setForOpen(ctx.FOR_OPENC().toString());
        System.out.println(forr.getForOpen());
        forr.setBodyFor(visitBodyfor(ctx.bodyfor()));
        forr.setForClose(ctx.FOR_CLOSE().toString());
        System.out.println(forr.getForClose());
        forr.setOpenBracket(ctx.OPENBRACKET().toString());
        System.out.println(forr.getOpenBracket());
        for (int i=0;i<ctx.body().size();i++){
            bodies.add(visitBody(ctx.body(i)));
        }
        forr.setBodies(bodies);
        forr.setCloseBracket(ctx.CLOSEBRACKET().toString());
        System.out.println(forr.getCloseBracket());
        return forr;
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
            page.setDefinitionPages(definitionPages);
        }

        }
         if (ctx.def_controller()!=null){
            for (int i = 0; i < ctx.def_controller().size(); i++) {
                definitionControllers.add(visitDef_controller(ctx.def_controller(i)));
            }
            page.setDefinitionControllers(definitionControllers);
        }


        page.setDefinitionPages(definitionPages);
        return page;
    }

    @Override
    public Link visitLink(Parserp.LinkContext ctx) {
        Link link = new Link();
        link.setLink1(ctx.LINK().toString());
        System.out.println(link.getLink1());
        //write(link.getLink1());
        link.setOpenBracket(ctx.OPENC().toString());
        System.out.println(link.getOpenBracket());
        //write(link.getOpenBracket());
        link.setTag(ctx.TAG_NAME().toString());
        System.out.println(link.getTag());
        //write(link.getTagName());
        link.setCloseBracket(ctx.CLOSEC().toString());
        System.out.println(link.getCloseBracket());
        //write(link.getCloseBracket());
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
        //write(data.getData1());
        data.setOpenBracket(ctx.OPENC().toString());
        System.out.println(data.getOpenBracket());
        //write(data.getOpenBracket());
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
        if (ctx.varequal()!=null){
            bodyController.setVairable(visitVarequal(ctx.varequal()));
        }
        if (ctx.if_()!=null){
            bodyController.setIff(visitIf(ctx.if_()));
        }
        if (ctx.goto_()!=null){
            bodyController.setGoTo(visitGoto(ctx.goto_()));
        }
        if (ctx.for_()!=null){
            bodyController.setForr(visitFor(ctx.for_()));
        }
        if (ctx.foreach()!=null){
            bodyController.setForEach(visitForeach(ctx.foreach()));
        }
        if (ctx.validation()!=null){
            bodyController.setValidation(visitValidation(ctx.validation()));
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
        strings.add("src//"+definitionPage.getTagName()+".html");
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
    public BodyIn visitBodyIN(Parserp.BodyINContext ctx)
    {
        BodyIn bodyIn = new BodyIn();
        bodyIn.setArrow(ctx.TOIN().toString());
        bodyIn.setOpenBracket(ctx.OPENP().toString());
        if(ctx.N()!=null){
            bodyIn.setId(ctx.N().toString());
            write(strings.get(0)," id="+'"'+bodyIn.getId()+'"');
        }
        if(ctx.COMMAM()!=null){
            bodyIn.setComma(ctx.COMMAM().toString());
        }
        if(ctx.N1()!=null){
            bodyIn.setName(ctx.N1().toString());
            write(strings.get(0)," name="+'"'+bodyIn.getName() +'"');
        }
        bodyIn.setCloseBracket(ctx.CLOSEP().toString());
        write(strings.get(0),">"+'\n');
        return bodyIn;
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
        write(strings.get(0),"<label>");
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
            write(strings.get(0),"Your Email </label>");
            write(strings.get(0),in.getEmail()+'"'+'>'+'\n');
            write(strings.get(0),"<input type="+'"'+in.getEmail()+'"' );

            if(ctx.E()!=null){
                in.setEmailText(ctx.E().toString());
                System.out.println(in.getEmailText());
                write(strings.get(0),"value=" + '"' +in.getEmailText()+'"');
            }
            if(ctx.bodyIN()!=null){
                in.setBodyIn(visitBodyIN(ctx.bodyIN()));
            }


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
    public ARRV visitArrv(Parserp.ArrvContext ctx) {
        ARRV arrv = new ARRV();
        arrv.setOpenArray(ctx.OPENARRV().toString());
        System.out.println(arrv.getOpenArray());
        arrv.setBodyArr(visitBodyarr(ctx.bodyarr()));
        arrv.setCloseArray(ctx.ARRAY_CLOSE().toString());
        System.out.println(arrv.getCloseArray());
        return arrv;
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
    public BodyFor visitBodyfor(Parserp.BodyforContext ctx) {
        BodyFor bodyFor = new BodyFor();
        bodyFor.setBodyForFirstVar(visitBodyforfirstvar(ctx.bodyforfirstvar()));
        bodyFor.setBdyFor(ctx.BDYFOR().toString());
        System.out.println(bodyFor.getBdyFor());
        bodyFor.setBodyForSecondVar(visitBodyforsecondvar(ctx.bodyforsecondvar()));
        return bodyFor;
    }

    @Override
    public BodyForeach visitBodyforeach(Parserp.BodyforeachContext ctx) {
        BodyForeach  bodyForeach = new BodyForeach();
        bodyForeach.setBodyForeachFirstArg(visitBodyforeachFirstArg(ctx.bodyforeachFirstArg()));
        bodyForeach.setBDyforeach(ctx.BDYFOREACH().toString());
        System.out.println(bodyForeach.getBDyforeach());
        bodyForeach.setBodyForeachSecondArg(visitBodyforeachSecondArg(ctx.bodyforeachSecondArg()));
        return bodyForeach;
    }

    @Override
    public BodyIfc visitBodyifc(Parserp.BodyifcContext ctx) {
        BodyIfc bodyIfc = new BodyIfc();
        if (ctx.IFN()!=null){
            bodyIfc.setVar(ctx.IFN().toString());
            System.out.println(bodyIfc.getVar());
            if (ctx.TAG_OPERATOR()!=null){
                bodyIfc.setOperator(ctx.TAG_OPERATOR().toString());
                System.out.println(bodyIfc.getOperator());
            }
            if (ctx.VAREQ()!=null){
                bodyIfc.setEqu(ctx.VAREQ().toString());
                System.out.println(bodyIfc.getEqu());
                bodyIfc.setStr(ctx.STR().toString());
                System.out.println(bodyIfc.getStr());
            }
        }
        else if (ctx.REQ()!=null){
            bodyIfc.setReq(ctx.REQ().toString());
            System.out.println(bodyIfc.getReq());
            if (ctx.TAG_OPERATOR()!=null){
                bodyIfc.setOperator(ctx.TAG_OPERATOR().toString());
                System.out.println(bodyIfc.getOperator());
            }
            if (ctx.VAREQ()!=null){
                bodyIfc.setEqu(ctx.VAREQ().toString());
                System.out.println(bodyIfc.getEqu());
                bodyIfc.setStr(ctx.STR().toString());
                System.out.println(bodyIfc.getStr());
            }
        }

        return bodyIfc;
    }

    @Override
    public Body visitBody(Parserp.BodyContext ctx) {
        Body body = new Body();
        if (ctx.goto_()!=null){
            body.setGoTo(visitGoto(ctx.goto_()));
        }
        if (ctx.varequal()!=null){
            body.setVairable(visitVarequal(ctx.varequal()));
        }
        if (ctx.if_()!=null){
            body.setIff(visitIf(ctx.if_()));
        }
        if (ctx.print()!=null){
            body.setPrint(visitPrint(ctx.print()));
        }
        if (ctx.arr()!=null){
            body.setArr(visitArr(ctx.arr()));
            body.setSemicolon(ctx.CLOSE().toString());
            System.out.println(body.getSemicolon());
        }
        if (ctx.for_()!=null){
            body.setForr(visitFor(ctx.for_()));
        }
        if (ctx.foreach()!=null){
            body.setForEach(visitForeach(ctx.foreach()));
        }
        return body;
    }

    @Override
    public Object visitBodyP(Parserp.BodyPContext ctx) {
        return super.visitBodyP(ctx);
    }

    @Override
    public GoTo visitGoto(Parserp.GotoContext ctx) {
        GoTo goTo = new GoTo();
        List<GoToBody3> goToBody3s = new ArrayList<>();
        goTo.setGoToBody1(visitGotobody1(ctx.gotobody1()));
        if (ctx.gotobody2()!=null){
            goTo.setGoToBody2(visitGotobody2(ctx.gotobody2()));
            if (ctx.gotobody3()!=null){
                for (int i=0; i<ctx.gotobody3().size();i++){
                    goToBody3s.add(visitGotobody3(ctx.gotobody3(i)));
                }
                goTo.setGoToBody3s(goToBody3s);
            }
            goTo.setClose(ctx.GOTOC().toString());
            System.out.println(goTo.getClose());
        }
        goTo.setSemiColon(ctx.GOTO_CLOSE().toString());
        System.out.println(goTo.getSemiColon());
        return goTo;
    }

    @Override
    public IFC visitIfc(Parserp.IfcContext ctx) {
        IFC ifc = new IFC();
        ifc.setIfOpen(ctx.IF_OPENC().toString());
        System.out.println(ifc.getIfOpen());
        ifc.setBodyIfc(visitBodyifc(ctx.bodyifc()));
        ifc.setIfClose(ctx.IF_CLOSE().toString());
        System.out.println(ifc.getIfClose());
        return ifc;
    }



    @Override
    public IF visitIf(Parserp.IfContext ctx) {
        IF iff = new IF();
        iff.setIfc(visitIfc(ctx.ifc()));
        iff.setIfBody(visitIfbody(ctx.ifbody()));
        if (ctx.elsebody()!=null){
            iff.setElseBody(visitElsebody(ctx.elsebody()));
        }
        return iff;
    }

    @Override
    public BodyForFirstVar visitBodyforfirstvar(Parserp.BodyforfirstvarContext ctx) {
        BodyForFirstVar bodyForFirstVar = new BodyForFirstVar();
        bodyForFirstVar.setVarName(ctx.FORNA().toString());
        System.out.println(bodyForFirstVar.getVarName());
        return bodyForFirstVar;
    }

    @Override
    public BodyForSecondVar visitBodyforsecondvar(Parserp.BodyforsecondvarContext ctx) {
        BodyForSecondVar bodyForSecondVar = new BodyForSecondVar();
        bodyForSecondVar.setVarName(ctx.FORNA().toString());
        System.out.println(bodyForSecondVar.getVarName());
        return bodyForSecondVar;
    }

    @Override
    public BodyForeachFirstArg visitBodyforeachFirstArg(Parserp.BodyforeachFirstArgContext ctx) {
        BodyForeachFirstArg bodyForeachFirstArg = new BodyForeachFirstArg();
        bodyForeachFirstArg.setVarName(ctx.FOREACHN().toString());
        System.out.println(bodyForeachFirstArg.getVarName());
        return bodyForeachFirstArg;
    }

    @Override
    public BodyForeachSecondArg visitBodyforeachSecondArg(Parserp.BodyforeachSecondArgContext ctx) {
        BodyForeachSecondArg bodyForeachSecondArg = new BodyForeachSecondArg();
        bodyForeachSecondArg.setVarName(ctx.FOREACHN().toString());
        System.out.println(bodyForeachSecondArg.getVarName());
        return bodyForeachSecondArg;
    }

    @Override
    public GoToBody1 visitGotobody1(Parserp.Gotobody1Context ctx) {
        GoToBody1 goToBody1 = new GoToBody1();
        goToBody1.setGotoOpen(ctx.GOTO_OPEN().toString());
        System.out.println(goToBody1.getGotoOpen());
        goToBody1.setGotoON(ctx.GOTON().toString());
        System.out.println(goToBody1.getGotoON());
        return goToBody1;
    }

    @Override
    public GoToBody2 visitGotobody2(Parserp.Gotobody2Context ctx) {
        GoToBody2 goToBody2 = new GoToBody2();
        goToBody2.setGotoOP(ctx.GOTOP().toString());
        System.out.println(goToBody2.getGotoOP());
        goToBody2.setGotoVar(ctx.GOTOVAR().toString());
        System.out.println(goToBody2.getGotoVar());
        goToBody2.setGotoOn(ctx.GOTON().toString());
        System.out.println(goToBody2.getGotoOn());
        return goToBody2;
    }

    @Override
    public GoToBody3 visitGotobody3(Parserp.Gotobody3Context ctx) {
        GoToBody3 goToBody3 = new GoToBody3();
        goToBody3.setGotoComma(ctx.GOTOCOMMA().toString());
        System.out.println(goToBody3.getGotoComma());
        goToBody3.setGotoVar(ctx.GOTOVAR().toString());
        System.out.println(goToBody3.getGotoVar());
        goToBody3.setGotoOn(ctx.GOTON().toString());
        System.out.println(goToBody3.getGotoOn());
        return goToBody3;
    }

    @Override
    public IfBody visitIfbody(Parserp.IfbodyContext ctx) {
        IfBody ifBody = new IfBody();
        List<Body> bodies = new ArrayList<>();
        ifBody.setOpenBracket(ctx.OPENBRACKET().toString());
        System.out.println(ifBody.getOpenBracket());

        if (ctx.body()!=null){
            for (int i=0;i<ctx.body().size();i++){
                bodies.add(visitBody(ctx.body(i)));
            }
            ifBody.setBodies(bodies);
        }

        ifBody.setCloseBracket(ctx.CLOSEBRACKET().toString());
        System.out.println(ifBody.getCloseBracket());
        return ifBody;
    }

    @Override
    public ElseBody visitElsebody(Parserp.ElsebodyContext ctx) {
        ElseBody elseBody = new ElseBody();
        List<Body> bodies = new ArrayList<>();
        elseBody.setElse11(ctx.ELSE11().toString());
        System.out.println(elseBody.getElse11());
        elseBody.setOpenBracket(ctx.OPENBRACKET().toString());
        System.out.println(elseBody.getOpenBracket());
        if (ctx.body()!=null){
            for (int i=0;i<ctx.body().size();i++) {
                bodies.add(visitBody(ctx.body(i)));
            }
            elseBody.setBodies(bodies);
        }
        elseBody.setCloseBracket(ctx.CLOSEBRACKET().toString());
        System.out.println(elseBody.getCloseBracket());
        return elseBody;
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

        return include;
    }



    @Override
    public Valid visitValid(Parserp.ValidContext ctx) {
        Valid valid = new Valid();
        if (ctx.REQUIREDV()!=null){
            valid.setRequired(ctx.REQUIREDV().toString());
            System.out.println(valid.getRequired());
        }
        if (ctx.STRINGV()!=null){
            valid.setString(ctx.STRINGV().toString());
            System.out.println(valid.getString());
        }
        if (ctx.EMAILV()!=null){
            valid.setEmail(ctx.EMAILV().toString());
            System.out.println(valid.getEmail());
        }
        if (ctx.MINV()!=null){
            valid.setMin(ctx.MINV().toString());
            System.out.println(valid.getMin());
            valid.setNum(ctx.NUM().toString());
            System.out.println(valid.getNum());
        }
        if (ctx.MAXV()!=null){
            valid.setMax(ctx.MAXV().toString());
            System.out.println(valid.getMax());
            valid.setNum(ctx.NUM().toString());
            System.out.println(valid.getNum());
        }
        return valid;
    }

    @Override
    public Validation visitValidation(Parserp.ValidationContext ctx) {
        Validation validation = new Validation();
        List<String> strings = new ArrayList<>();
        List<String> validsstr = new ArrayList<>();
        List<String> ors = new ArrayList<>();
        List<String> semicolons = new ArrayList<>();
        List<Valid> valids = new ArrayList<>();
        List<Valid1> valid1s = new ArrayList<>();
        validation.setValidation1(ctx.VALIDATION().toString());
        System.out.println(validation.getValidation1());
        validation.setOpenC(ctx.OPENC().toString());
        System.out.println(validation.getOpenC());
        validation.setReq(ctx.REQUEST().toString());
        System.out.println(validation.getReq());
        validation.setCloseC(ctx.CLOSEC().toString());
        System.out.println(validation.getCloseC());
        validation.setOpenBracket(ctx.OPENBRACKET().toString());
        System.out.println(validation.getOpenBracket());
        if (ctx.STRINGARR()!=null){
            for (int i=0;i<ctx.STRINGARR().size();i++) {
                strings.add(ctx.STRINGARR(i).toString());
                validsstr.add(ctx.VALID(i).toString());
                semicolons.add(ctx.CLOSE(i).toString());
                System.out.println(strings.get(i));
                System.out.println(validsstr.get(i));
            }
            if (ctx.valid()!=null){
                for (int i=0; i<ctx.valid().size();i++)
                valids.add(visitValid(ctx.valid(i)));

                validation.setValids(valids);
            }
            if (ctx.OR()!=null){
                for (int m=0;m<ctx.OR().size();m++) {
                    ors.add(ctx.OR(m).toString());
                    System.out.println(ors.get(m));
                }
                    if (ctx.valid1()!=null) {
                        for (int i=0;i<ctx.valid1().size();i++)
                        valid1s.add(visitValid1(ctx.valid1(i)));
                        validation.setValid1s(valid1s);
                    }

                validation.setOr(ors);

            }
            }
            validation.setStr(strings);
            validation.setValidstr(validsstr);
            validation.setSemicolon(semicolons);

        validation.setCloseBracket(ctx.CLOSEBRACKET().toString());
        System.out.println(validation.getCloseBracket());


        return validation;
    }

    @Override
    public Valid1 visitValid1(Parserp.Valid1Context ctx) {
        Valid1 valid1 = new Valid1();
        if (ctx.REQUIREDV()!=null){
            valid1.setRequired(ctx.REQUIREDV().toString());
            System.out.println(valid1.getRequired());
        }
        if (ctx.STRINGV()!=null){
            valid1.setString(ctx.STRINGV().toString());
            System.out.println(valid1.getString());
        }
        if (ctx.EMAILV()!=null){
            valid1.setEmail(ctx.EMAILV().toString());
            System.out.println(valid1.getEmail());
        }
        if (ctx.MINV()!=null){
            valid1.setMin(ctx.MINV().toString());
            System.out.println(valid1.getMin());
            valid1.setNum(ctx.NUM().toString());
            System.out.println(valid1.getNum());
        }
        if (ctx.MAXV()!=null){
            valid1.setMax(ctx.MAXV().toString());
            System.out.println(valid1.getMax());
            valid1.setNum(ctx.NUM().toString());
            System.out.println(valid1.getNum());
        }
        return valid1;
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
    public void write(String filename, String word) {
        try {
            FileWriter fw = new FileWriter(filename, true); //the true will append the new data
            fw.write(word);
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

}
