package my.bit.sem.rsa;

import java.math.BigInteger;


public class KeyImpl implements Key {

    private BigInteger left;
    private BigInteger right;


    public KeyImpl(BigInteger left, BigInteger right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public BigInteger getLeft() {
        return left;
    }


    @Override
    public BigInteger getRight() {
        return right;
    }

}
