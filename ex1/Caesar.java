import java.util.Scanner;

class cipher {
  String alphabet = "abcdefghijklmnopqrstuvwxyz";

  String encrypt(String plainText, int shiftKey) {
    plainText = plainText.toLowerCase();
    String cipherText = "";
    for (char c : plainText.toCharArray()) {
      cipherText += alphabet.charAt((((char) c - 97) + shiftKey)%26);
    }
    return cipherText;
  }

  String decrypt(String cipherText, int shiftKey) {
    cipherText = cipherText.toLowerCase();
    String plainText = "";
    for (char c : cipherText.toCharArray()) {
      plainText += alphabet.charAt((((char) c - 97) - shiftKey)%26);
    }
    return plainText;
  }
}

class Caesar {
  public static void main(String[] args) {
    cipher c = new cipher();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the String for Encryption: ");
    String message = sc.next();
    String cipherText = c.encrypt(message, 5);
    System.out.println("Encryption:" + cipherText);
    System.out.println("Decryption:" + c.decrypt(cipherText, 5));
    sc.close();
  }
}