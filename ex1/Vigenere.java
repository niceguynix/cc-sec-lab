import java.util.*;

class Vigenere {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the key:");
    String key = sc.next();
    System.out.print("Enter the plaintext:");
    String msg = sc.next();
    String enmsg = "";
    String plmsg = "";
    sc.close();

    // key generation

    // encryption
    for (int i = 0; i < msg.length(); i++) {
      int t = ((msg.charAt(i) + key.charAt(i % key.length()) - 97 * 2) % 26);
      enmsg += (char) (t + 97);
    }
    // decryption
    for (int i = 0; i < enmsg.length(); i++) {
      int t = ((enmsg.charAt(i) - key.charAt(i % key.length())) % 26);
      if (t < 0) {
        t += 26;
      }
      plmsg += (char) (t + 97);
    }

    System.out.println("\nCipher Text:" + enmsg);
    System.out.println("Plain Text:" + plmsg);
  }
}
