package my.bit.sem;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;


public class RSAImplTest {
    RSAImpl rsa;


    @Before
    public void setUp() throws Exception {
        rsa = new RSAImpl(new BigInteger("32416189079"), new BigInteger("32416190039"),new BigInteger("72757265826973078766138369299481766069091107349543182542378964338958625971967"));
    }



    @Test
    public void testEncryptionWithNumber() {      
        assertEquals(new BigInteger("820032923029278232076"), rsa.encryption(new BigInteger("648975321567"), rsa.getPublicKey()));
    }


    @Test
    public void testDecriptionWithNumber() {
        assertEquals(new BigInteger("648975321567"), rsa.decription(new BigInteger("820032923029278232076")));
    }
    
    @Test
    public void testEncryptionWithText(){
        String test = "Ahoj jak se mas?";
        byte[] testB= test.getBytes();
        System.out.println(rsa.encryption(new BigInteger(testB), rsa.getPublicKey()).toString(10));
        assertEquals(new BigInteger("493499369036159486701"), rsa.encryption(new BigInteger(testB), rsa.getPublicKey()));
    }
    
    @Test
    public void testDecriptionWithText() {
        assertEquals("Ahoj jak se mas?", new String(rsa.decription(new BigInteger("493499369036159486701")).toByteArray()));
    }

}
