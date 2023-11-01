import java.util.*;

class RailFence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String msg = new String();
    System.out.println("Enter the message:");
    msg = sc.next();
    int i, ptr;
    char a[] = new char[20];
    char b[] = new char[20];
    String enmsg = "";
    String pltxt = "";
    i = 0;
    for (ptr = 0; ptr < msg.length(); ptr = ptr + 2) {
      a[i] = msg.charAt(ptr);
      i++;
    }
    i = 0;
    for (ptr = 1; ptr < msg.length(); ptr = ptr + 2) {
      b[i] = msg.charAt(ptr);
      i++;
    }
    i = 0;
    for (ptr = 0; ptr < msg.length() / 2; ptr++) {
      enmsg += a[i];
      i++;
    }
    i = 0;
    for (ptr = 0; ptr < msg.length() / 2; ptr++) {
      enmsg += b[i];
      i++;
    }
    System.out.println("Cipher Text:" + enmsg);
    i = 0;
    for (ptr = 0; ptr < msg.length() / 2; ptr++) {
      pltxt += a[i];
      pltxt += b[i];
      i++;
    }
    System.out.println("Plain Text:" + pltxt);
  }
}
