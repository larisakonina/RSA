
import java.math.BigInteger;
import java.security.SecureRandom;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Larisa Konina 23501/3
 */
public class RSAtest {

    private static SecureRandom rand = new SecureRandom();
    BigInteger encrypt;
    BigInteger decrypt;

    @Test
    public void test() {

        int N = 1024;

        RSA key = new RSA(N);
        BigInteger message = new BigInteger(N - 1, rand);

        encrypt = key.encrypt(message);
        decrypt = key.decrypt(encrypt);

        assertEquals(message, decrypt);
        rand = new SecureRandom();

        N = 128;
        key = new RSA(N);

        message = new BigInteger(N - 1, rand);

        encrypt = key.encrypt(message);
        decrypt = key.decrypt(encrypt);

        assertEquals(message, decrypt);
        assertFalse(message == encrypt);

        N = 512;
        key = new RSA(N);

        message = new BigInteger(N - 1, rand);

        encrypt = key.encrypt(message);
        decrypt = key.decrypt(encrypt);
        assertEquals(message, decrypt);

    }

}
