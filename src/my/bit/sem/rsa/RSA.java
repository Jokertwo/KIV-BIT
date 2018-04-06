package my.bit.sem.rsa;

import java.math.BigInteger;

public interface RSA {

    /**
     * Returns public key for distribute
     * 
     * @return
     */
    Key getPublicKey();


    /**
     * Encrypt value with public key of receiver
     * 
     * @param value
     *            value to encrypt
     * @param publicKey
     *            receivers public key
     * @return return encrypted value
     */
    BigInteger encryption(BigInteger value, Key publicKey) throws NullPointerException;


    /**
     * Decription of received value with private key
     * 
     * @param value
     * @return
     */
    BigInteger decription(BigInteger value) throws NullPointerException;
}
