package my.bit.sem.pm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;


public class Print {

    public static void printPrimeNumber(List<BigInteger> values) {
        try (FileWriter fw = new FileWriter("primeNumber.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw);) {

            for (int i = 0; i < values.size(); i++) {
                out.println(values.get(i).toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
