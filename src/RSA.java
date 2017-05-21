
/**
 *
 * @author Larisa Konina
 * 23501/3
 */
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger mod;

    // key generation 
    RSA(int N) {
        BigInteger p = BigInteger.probablePrime(N / 2, random);  //return probably simple BigInteger
        BigInteger q = BigInteger.probablePrime(N / 2, random);  // length of N/2 bit
        mod = p.multiply(q);                                     // mod = p*q       
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one)); //calculation of the Euler function

        publicKey = new BigInteger("65537");     //public exponent, common value in practice = 2^16 + 1
        privateKey = publicKey.modInverse(phi);  //secret exponent, multiplicatively inverse to publicKey
    }

    BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, mod);
    }

    BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(privateKey, mod);
    }

   
    public static void main(String[] args) {

    }
}
