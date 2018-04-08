package my.bit.sem.aes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AESImplTest {

    private AES aes;
    private String key = "Bar12345Bar12345"; // 128 bit key
    private String initVector = "RandomInitVector"; // 16 bytes IV
    private String value = "A ted tady mohu napsat proste snad cokoliv nebo fakt nevim jestli je nebo to neni jedno";

    @Before
    public void setUp() throws Exception {
        
        aes = new AESImpl(key,initVector);
    }


    @Test
    public void testEncrypt() {
        assertEquals("vcx6eT4UnLze6IuZdpMkU54l8SOWdkB4UfzEJvPIJ6M=", aes.encrypt("Nejaka hodne dlouha veta treba"));
    }


    @Test
    public void testDecrypt() {
        assertEquals("Nejaka hodne dlouha veta treba", aes.decrypt("vcx6eT4UnLze6IuZdpMkU54l8SOWdkB4UfzEJvPIJ6M="));
    }
    
    @Test
    public void testEncryptDecryptTogether(){
        assertEquals(value, aes.decrypt(aes.encrypt(value)));
    }

}
