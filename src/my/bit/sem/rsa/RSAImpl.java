package my.bit.sem.rsa;

import java.math.BigInteger;
import java.security.SecureRandom;


public class RSAImpl implements RSA {

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger euler;
    private BigInteger euklid;
    private BigInteger e;

    private Key publicKey;
    private Key privateKey;

    private static final int BITLENGHT = 2048;
    private static SecureRandom rnd = new SecureRandom();


    public RSAImpl() {
        this.p = BigInteger.probablePrime(BITLENGHT, rnd);
        this.q = BigInteger.probablePrime(BITLENGHT, rnd);
        prepare();
        publicKey = createKey(n, e);
        privateKey = createKey(n, euklid);
    }


    public RSAImpl(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        prepare();
        publicKey = createKey(n, e);
        privateKey = createKey(n, euklid);
    }


    /**
     * Just for test
     * 
     * @param p
     * @param q
     * @param e
     */
    public RSAImpl(BigInteger p, BigInteger q, BigInteger e) {
        this.p = p;
        this.q = q;
        this.e = e;
        prepare();
        publicKey = createKey(n, e);
        privateKey = createKey(n, euklid);
    }


    private void prepare() {
        n = p.multiply(q);
        euler = (p.add(new BigInteger("-1")).multiply(q.add(new BigInteger("-1"))));
        if (e == null) {
            e = createE();
        }
        euklid = e.modInverse(euler);
    }


    private Key createKey(BigInteger left, BigInteger right) {
        return new KeyImpl(left, right);
    }


    private BigInteger createE() {
        BigInteger e;
        do {
            e = BigInteger.probablePrime(BITLENGHT / 2, new SecureRandom());
        } while (e.gcd(euler).intValue() > 1);
        return e;
    }


    @Override
    public Key getPublicKey() {
        // TODO Auto-generated method stub
        return publicKey;
    }


    @Override
    public BigInteger encryption(String value, Key publicKey) throws NullPointerException {
        if (value == null || publicKey == null) {
            throw new NullPointerException("Arguments can not be null.");
        }
        BigInteger temp = new BigInteger(value.getBytes());
        temp = temp.modPow(publicKey.getRight(), publicKey.getLeft());
        return temp;
    }


    @Override
    public BigInteger decription(String value) throws NullPointerException {
        if (value == null) {
            throw new NullPointerException("Argument can not be null.");
        }
        BigInteger temp = new BigInteger(value);
        temp = temp.modPow(privateKey.getRight(), privateKey.getLeft());
        return temp;
    }




    //////////////////////////////////////// methods just for test////////////////////////////////////
    public BigInteger getN() {
        return n;
    }


    public BigInteger getEul() {
        return euler;
    }


    public BigInteger getE() {
        return e;
    }


    public BigInteger getEuk() {
        return euklid;
    }


    public Key getPrivateKey() {
        return privateKey;
    }

}
