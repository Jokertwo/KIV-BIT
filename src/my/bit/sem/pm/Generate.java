package my.bit.sem.pm;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Generate {

    private static final int BITLENGHT = 2048;
    List<BigInteger> list = new LinkedList<>();
    ExecutorService executor = Executors.newFixedThreadPool(2);
    public SecureRandom rnd = new SecureRandom();


    public Generate() {
        create1();
        Print.printPrimeNumber(list);
    }


    private void create1() {
        int i = 0;
        for (i = 0; i < 15; i++) {
            executor.submit(() -> {
                list.add(BigInteger.probablePrime(BITLENGHT, rnd));
                String threadName = Thread.currentThread().getName();
                System.out.println("Hello " + threadName);
            });
        }
        try {
            
            System.out.println("attempt to shutdown executor");
            executor.awaitTermination(20, TimeUnit.SECONDS);
            executor.shutdown();
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } 

    }


    public static void main(String[] args) {
        new Generate();
    }

}
