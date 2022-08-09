import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class symbolTable {


    String[][] arr;

    public symbolTable() {
        arr = new String[16][10];

        arr[0][0] = "controller";

        arr[1][0] = "controls";

        arr[2][0] = "validation";

        arr[3][0] = "if";

        arr[4][0] = "switch";

        arr[5][0] = "for";

        arr[6][0] = "foreach";

        arr[7][0] = "array";

        arr[8][0] = "include";

        arr[9][0] = "page";

        arr[10][0] = "in";

        arr[11][0] = "out";

        arr[12][0] = "link";

        arr[13][0] = "data";

        arr[14][0] = "goto";

        arr[15][0] = "case";


    }

    public String[][] add() {
        File file = new File(
                "D:\\Compiler-5\\sample1.txt");

        int controller = 1;
        int in = 1;
        int out = 1;
        int controls = 1;
        int validation = 1;
        int iff = 1;
        int switchh = 1;
        int forr = 1;
        int foreachh = 1;
        int arrayy = 1;
        int include = 1;
        int page = 1;
        int link = 1;
        int data = 1;
        int go = 1;
        int casee = 1;
        String array;
        //int number =0;

        try {
            Scanner scan = new Scanner(file);


            while (scan.hasNext()) {

                String temp = scan.next();
                if (temp.contains("controller")) {
                    String help = scan.next();
                    String result = search(help);
                    if (Objects.equals(result, "exit")) {
                        arr[0][controller] = help;
                        System.out.println(arr[0][controller]);
                        controller++;
                    } else {
                        int number = getLineNumber(file,arr[0][controller]);
                        System.out.println("-------There is a variable named " + help + "  "+number);

                    }

                } else if (temp.contains("controls")) {
                    String help = scan.next();
                    String result = search(help);
                    if (Objects.equals(result, "exit")) {
                        arr[1][controls] = help;
                        System.out.println(arr[1][controls]);

                        controls++;
                    } else {
                        int number = getLineNumber(file,arr[1][controls]);
                        System.out.println("-------There is a variable named " + help + "   "+number);
                    }

                } else if (temp.contains("validation")) {
                    arr[2][validation] = "true";
                    System.out.println(arr[2][validation]);
                    validation++;

                } else if (temp.contains("if")) {
                    arr[3][iff] = "true";
                    System.out.println(arr[3][iff]);
                    iff++;

                } else if (temp.contains("switch")) {
                    arr[4][switchh] = "true";
                    System.out.println(arr[4][switchh]);
                    switchh++;

                } else if (temp.contains("for")) {
                    arr[5][forr] = "true";
                    System.out.println(arr[5][forr]);
                    forr++;

                } else if (temp.contains("foreach")) {
                    arr[6][foreachh] = "true";
                    System.out.println(arr[6][foreachh]);
                    foreachh++;

                } else if (temp.contains("$") && scan.next().matches("=")) {
                    arr[7][arrayy] = temp;
                    System.out.println(arr[7][arrayy]);
                    arrayy++;
                     array = scan.next();
                    System.out.println(array);


                } else if (temp.contains("include")) {
                    arr[8][include] = scan.next();
                    System.out.println(arr[8][include]);
                    include++;

                } else if (temp.contains("page")) {
                    arr[9][page] = scan.next();
                    System.out.println(arr[9][page]);
                    page++;

                } else if (temp.matches("in")) {

                    arr[10][in] = scan.next();
                    System.out.println(arr[10][in]);

                    in++;


                } else if (temp.contains("out")) {
                    arr[11][out] = scan.next();
                    System.out.println(arr[11][out]);
                    out++;

                } else if (temp.contains("link")) {
                    arr[12][link] = scan.next();
                    System.out.println(arr[12][link]);
                    link++;

                } else if (temp.contains("data")) {
                    arr[13][data] = scan.next();
                    System.out.println(arr[13][data]);
                    data++;

                }

                else if (temp.contains("goto")) {
                    arr[14][go] = scan.next();
                    System.out.println(arr[14][go]);
                    go++;

                }

                else if (temp.contains("case:")) {
                    String splite = temp.substring(5);
                    arr[15][ casee] = splite;
                    System.out.println(arr[15][casee]);
                    casee++;

                }

            }



            scan.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


        return arr;
    }

    public void print() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j]);
                System.out.print("\t\t");
            }
            System.out.print("\n");
        }
    }

    public String search(String word) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 1; j < arr[i].length; j++)
                if (Objects.equals(arr[i][j], word))
                    return arr[i][j];

        return "exit";
    }

    public boolean doubleSearch(String word) {
        int n=0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 1; j < arr[i].length; j++)
                if (Objects.equals(arr[i][j], word))
                    n++;
        if(n>1)
            return true;


        return false;
    }

    public int getLineNumber(File file, String result) throws FileNotFoundException {
        int number=0;

        Scanner sc = new Scanner(file);

        while(sc.hasNextLine() && doubleSearch(result)) {
            sc.nextLine();
            number++;
        }



        return number;
    }
}
