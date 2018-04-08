package my.bit.sem.pm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class PrimeNumber {
    private static final List<PrimeNumbersE> VALUES;
    private static final int SIZE;
    private static final Random RANDOM = new Random();

    static {
        List<PrimeNumbersE> temp = new ArrayList<PrimeNumbersE>(10);
        temp.add(PrimeNumbersE.pN1);
        temp.add(PrimeNumbersE.pN2);
        temp.add(PrimeNumbersE.pN3);
        temp.add(PrimeNumbersE.pN4);
        temp.add(PrimeNumbersE.pN5);
        temp.add(PrimeNumbersE.pN6);
        temp.add(PrimeNumbersE.pN7);
        temp.add(PrimeNumbersE.pN8);
        temp.add(PrimeNumbersE.pN9);
        temp.add(PrimeNumbersE.pN10);
        VALUES = Collections.unmodifiableList(temp);
        SIZE = VALUES.size();
    }


    public static BigInteger randomPrimeNumber() {
        return VALUES.get(RANDOM.nextInt(SIZE)).getPn();
    }
}
