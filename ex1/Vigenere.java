import java.util.*;

class Vigenere {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    char T[][] = new char[26][26];
    String key = new String();
    String msg = new String();
    System.out.println("\nEnter the key and plaintext");
    key = sc.next();
    msg = sc.next();
    String enmsg = "";
    String plmsg = "";
    int i, j, count, m = 0, h = 1;
    for (i = 0; i < 26; i++) {
      count = i;
      for (j = 0; j < 26; j++) {
        T[i][j] = alpha.charAt(count);
        count = (count + 1) % 26;
      }
    }
    // key generation
    int len = msg.length();
    int klen = key.length();
    count = 0;
    while (klen < len) {
      key += key.charAt(count);
      count++;
      klen++;
    }
    System.out.println("Message :\t" + msg);
    System.out.println("Key Text :\t" + key);
    // encryption
    while (m < len) {
      i = alpha.indexOf(key.charAt(m));
      j = alpha.indexOf(msg.charAt(m));
      enmsg += T[i][j];
      m++;
    }
    System.out.println("Cipher Text:\t" + enmsg);
    // decryption
    m = 0;
    while (m < len) {
      i = 0;
      j = alpha.indexOf(key.charAt(m));
      char k = enmsg.charAt(m);
      while (h == 1) {
        if (T[i][j] == k)
          break;
        else
          i++;
      }
      plmsg += alpha.charAt(i);
      m++;
    }
    System.out.println("Plain Text:\t" + plmsg);
  }
}
