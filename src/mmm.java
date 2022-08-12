import Ast.nodes.Page;
import Ast.vistor.BaseVisitor;
import Ast.vistor.symbolTable;
import gen.Lexerp;
import gen.Parserp;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.io.*;
import java.util.Scanner;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class mmm {

    public static void main(String[] args) throws IOException {


        try {

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


        symbolTable symboleTable = new symbolTable();

        symboleTable.add();

        symboleTable.print();

        String result1 =  symboleTable.search("gg");

        System.out.println(result1);


    }

    public static void write(String filename, String word) {
        try {
            FileWriter fw = new FileWriter(filename, true); //the true will append the new data
            fw.write(word + "\n");
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

}

