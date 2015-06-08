import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by Marius on 21.05.2015.
 */
public class Sequence {

    public static final String ALPHABET = "ACTG";
    public static final int N = ALPHABET.length();
    public static final String FILENAME = "frag.dat";

    public static void main (String[] args) throws Exception {
        System.out.println("Options: 1 for generating sequence to file");
        String input = System.console().readLine();

        if (input.equals("1")){


            System.out.println("Choose a sequence length:");
            String inputLength = System.console().readLine();
            Integer length = Integer.parseInt(inputLength.toString());
            Sequence.generate(length);
        }


    }

    public static void generate(int n) throws Exception{


        File f = new File(FILENAME);
        PrintWriter genSeq = new PrintWriter(new FileWriter((FILENAME),true));
        Random r = new Random();

        for (int i = 0; i < n; i++){

            genSeq.print(ALPHABET.charAt((r.nextInt(N))));

        }
        genSeq.println("");
        genSeq.println("+++");
        genSeq.close();
    }

    public static boolean compare (String seq, String seq2, int i) throws Exception{

        return (seq.indexOf(seq2, i) != -1);

    }

    public static int overlap(String seq, String seq2) throws Exception{
        int i ;
        int count = 0;
        for (i = seq.length(); i >= 0; i--) {
           // System.out.println(seq.substring(i));
            if (seq2.startsWith(seq.substring(i))) {
                count = seq.substring(i).length();
            }
        }
        return count;
    }


    public static String mold (String seq, String seq2) {

        int l = seq.length();
        for (int i = 0; i < l; i++) {
            if (seq2.startsWith(seq.substring(i))) {
                return seq.substring(0, i) + seq2;
            }
        }
        return "NOPE";

    }

    public static boolean isValid(String seq){

        return seq.matches("[ACTG]+");
    }
}
