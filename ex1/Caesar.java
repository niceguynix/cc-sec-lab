import java.util.Scanner;

class cipher {
  String alphabet = "abcdefghijklmnopqrstuvwxyz";
  String encrypt(String plainText, int shiftKey) {
    plainText = plainText.toLowerCase();
    String cipherText = "";
    for (int i = 0; i < plainText.length(); i++) {
      int charPosition = alphabet.indexOf(plainText.charAt(i));
      int keyVal = (shiftKey + charPosition) % 26;
      char replaceVal = alphabet.charAt(keyVal);
      cipherText += replaceVal;
    }
    return cipherText;
  }
  String decrypt(String cipherText, int shiftKey) {
    cipherText = cipherText.toLowerCase();
    String plainText = "";
    for (int i = 0; i < cipherText.length(); i++) {
      int charPosition = alphabet.indexOf(cipherText.charAt(i));
      int keyVal = (charPosition - shiftKey) % 26;
      if (keyVal < 0) {
        keyVal = alphabet.length() + keyVal;
      }
      char replaceVal = alphabet.charAt(keyVal);
      plainText += replaceVal;
    }
    return plainText;
  }
}

class Caesar {
  public static void main(String[] args) {
    cipher c = new cipher();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the String for Encryption: ");
    String message = new String();
    message = sc.next();
    String cipherText = new String();
    cipherText = c.encrypt(message, 3);
    System.out.println("Encryption:");
    System.out.println(cipherText);
    System.out.println("Decryption:");
    System.out.println(c.decrypt(cipherText, 3));
    sc.close();
  }
}