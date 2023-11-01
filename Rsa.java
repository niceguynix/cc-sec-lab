import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Rsa {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.print("Enter a Prime number: ");
    BigInteger p = sc.nextBigInteger(); // one primenumber
    System.out.print("Enter another prime number: ");
    BigInteger q = sc.nextBigInteger(); // another primenumber
    
    BigInteger n = p.multiply(q);
    BigInteger n2 =
        p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    BigInteger e = generateE(n2);
    BigInteger d = e.modInverse(n2); // Here's themultiplicative inverse
    
    System.out.println("Encryption keys are: " + e + ", " + n);
    System.out.println("Decryption keys are: " + d + ", " + n);
    System.out.print("Enter message: ");
    
    BigInteger m = sc.nextBigInteger();
    BigInteger c = encrypt(m, e, n);

    System.out.println("Ciphertext: " + c);
    System.out.println("Plaintext: " + decrypt(c, d, n));
  }
  public static BigInteger generateE(BigInteger fiofn) {
    int y, intGCD;
    BigInteger e;
    BigInteger gcd;
    Random x = new Random();
    do {
      y = x.nextInt(fiofn.intValue() + 1);
      String z = Integer.toString(y);
      e = new BigInteger(z);
      gcd = fiofn.gcd(e);
      intGCD = gcd.intValue();
    } while (intGCD != 1);
    return e;
  }
  public static BigInteger encrypt(BigInteger m, BigInteger e, BigInteger n) {
    return m.modPow(e, n);
  }
  public static BigInteger decrypt(BigInteger c, BigInteger d, BigInteger n) {
    return c.modPow(d, n);
  }
}
