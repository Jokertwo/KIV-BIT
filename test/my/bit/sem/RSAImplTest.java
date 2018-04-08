package my.bit.sem;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;
import my.bit.sem.rsa.RSAImpl;


public class RSAImplTest {
    RSAImpl rsa;


    @Before
    public void setUp() throws Exception {
        rsa = new RSAImpl(new BigInteger("32416189079"), new BigInteger("32416190039"),new BigInteger("534253395802282055093"));
    }



//    @Test
//    public void testEncryptionWithNumber() {      
//        assertEquals(new BigInteger("129762754444537238596"), rsa.encryption(new BigInteger("648975321567"), rsa.getPublicKey()));
//    }
//
//
//    @Test
//    public void testDecriptionWithNumber() {
//        assertEquals(new BigInteger("648975321567"), rsa.decription(new BigInteger("129762754444537238596")));
//    }
//    
//    @Test
//    public void testEncryptionWithText(){
//        String test = "1";
//        byte[] testB= test.getBytes();
//        assertEquals(new BigInteger("379728321945786270746"), rsa.encryption(new BigInteger(testB), rsa.getPublicKey()));
//    }
//    
//    @Test
//    public void testDecriptionWithText() {
//        System.out.println(rsa.decription(new BigInteger("379728321945786270746")).toString());
//        assertEquals("1", new String(rsa.decription(new BigInteger("379728321945786270746")).toByteArray()));
//    }

}
