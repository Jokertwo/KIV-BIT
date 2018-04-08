package my.bit.sem.aes;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AESImpl implements AES {

    private final String key;
    private final String initVector;


    public AESImpl(String key,String initVector) {
        this.key = key;
        this.initVector = initVector;
    }

        public String encrypt(String value) {
            try {
                IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
                SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

                byte[] encrypted = cipher.doFinal(value.getBytes());
                System.out.println("encrypted string: "
                        + Base64.getEncoder().encodeToString(encrypted));

                return Base64.getEncoder().encodeToString(encrypted);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }

        public String decrypt(String encrypted) {
            try {
                IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
                SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

                byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

                return new String(original);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }

}
