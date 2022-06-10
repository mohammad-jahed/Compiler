import Ast.nodes.Page;
import Ast.vistor.BaseVisitor;
import gen.Lexerp;
import gen.Parserp;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class mmm {

    public static void main(String[] args) {
        try {
            System.out.println("Enter the choice");
            System.out.println("1)Ngfor Standard " + "2)Ngfor Key " + "3)Ngfor Index " + "4)Ngfor Direct Array ");
            System.out.println("5)Switch " + "6)Show " + "7)Event " + "8)Hide " + "9)If" + "10)Model " + "11)Event");
            System.out.println("12)Full " + "13)Exit");

            String source = "sample1.txt";

            CharStream cs = fromFileName(source);
            Lexerp lexer = new Lexerp(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            Parserp parser = new Parserp(token);
            ParseTree tree = parser.pages();
            System.out.println("--------------------------");
            Page doc = (Page) new BaseVisitor().visit(tree);
            System.out.println();

            System.out.println(doc);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

