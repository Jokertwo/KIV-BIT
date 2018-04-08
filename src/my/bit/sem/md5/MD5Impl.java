package my.bit.sem.md5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Impl implements MD5 {

    @Override
    public byte[] decripte(String message) {
        byte[] cripte = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            cripte = md.digest(message.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cripte;
    }

}
