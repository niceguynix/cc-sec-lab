import java.util.*;
class Playfair {
  public static void main(String[] args) {
    int j, i, m = 0, k = 0, val, z = 0, flag = 0, count = 0;
    char T[][] = new char[5][5];
    String enmsg = "";
    String plainmsg = "";
    String alpha = "abcdefghiklmnopqrstuvwxyz";
    Scanner sc = new Scanner(System.in);
    System.out.println("\n\nenter the msg:\t");
    String msg = sc.next();
    System.out.println("\n\nenter the key:\t");
    String key = sc.next();
    char p[] = new char[26];
    for (i = 0; i < alpha.length(); i++) {
      for (j = 0; j < key.length(); j++) {
        if (alpha.charAt(i) == key.charAt(j)) {
          flag = 1;
          break;
        }
      }
      if (flag == 0) {
        p[z] = alpha.charAt(i);
        z++;
      }
      flag = 0;
    }
    System.out.println(p);
    z = 0;
    for (i = 0; i < 5; i++) {
      for (j = 0; j < 5; j++) {
        if (count == key.length()) {
          T[i][j] = p[z];
          z++;
        } else {
          T[i][j] = key.charAt(m);
          m++;
          count++;
        }
      }
    }
    System.out.println("\n\nThe matrix:\n");
    for (i = 0; i < 5; i++) {
      for (j = 0; j < 5; j++) {
        System.out.print(T[i][j]);
        System.out.print("\t");
      }
      System.out.println("\n");
    }
    val = msg.length();
    if ((val % 2) == 1)
      msg += 'x';
    int I1 = 0, I2 = 0, J1 = 0, J2 = 0, c, flag1 = 0, flag2 = 0;
    m = 0;
    // encryption
    do {
      for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
          if (T[i][j] == msg.charAt(m)) {
            I1 = i;
            J1 = j;
            flag1 = 1;
          }
          if (T[i][j] == msg.charAt(m + 1)) {
            I2 = i;
            J2 = j;
            flag2 = 1;
          }
          if (flag1 == 1 && flag2 == 1)
            break;
        }
        if (flag1 == 1 && flag2 == 1) {
          if (I1 == I2)
            c = 1;
          else if (J1 == J2)
            c = 2;
          else
            c = 3;
          switch (c) {
            case 1:
              if ((J1 + 1) == 5)
                enmsg += T[I1][0];
              else
                enmsg += T[I1][J1 + 1];
              if ((J2 + 1) == 5)
                enmsg += T[I2][0];
              else
                enmsg += T[I2][J2 + 1];
              break;
            case 2:
              if ((I1 + 1) == 5)
                enmsg += T[0][J1];
              else
                enmsg += T[I1 + 1][J1];
              if ((I2 + 1) == 5)
                enmsg += T[0][J2];
              else
                enmsg += T[I2 + 1][J2];
              break;
            case 3:
              enmsg += T[I1][J2];
              enmsg += T[I2][J1];
              break;
          } // switch end
          break;
        } // if end
      } // i loop end
      m = m + 2;
      flag1 = 0;
      flag2 = 0;
    } while (m < msg.length());
    System.out.println("\n\nPlayfair Cipher Text:\n\t" + enmsg);
    m = 0;
    // decryption
    flag1 = 0;
    flag2 = 0;
    do {
      for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
          if (T[i][j] == enmsg.charAt(m)) {
            I1 = i;
            J1 = j;
            flag1 = 1;
          }
          if (T[i][j] == enmsg.charAt(m + 1)) {
            I2 = i;
            J2 = j;
            flag2 = 1;
          }
          if (flag1 == 1 && flag2 == 1)
            break;
        }
        if (flag1 == 1 && flag2 == 1) {
          if (I1 == I2)
            c = 1;
          else if (J1 == J2)
            c = 2;
          else
            c = 3;
          switch (c) {
            case 1:
              if (J1 == 0)
                plainmsg += T[I1][4];
              else
                plainmsg += T[I1][J1 - 1];
              if (J2 == 0)
                plainmsg += T[I2][4];
              else
                plainmsg += T[I2][J2 - 1];
              break;
            case 2:
              if (I1 == 0)
                plainmsg += T[4][J1];
              else
                enmsg += T[I1 - 1][J1];
              if (I2 == 0)
                plainmsg += T[4][J2];
              else
                plainmsg += T[I2 - 1][J2];
              break;
            case 3:
              plainmsg += T[I1][J2];
              plainmsg += T[I2][J1];
              break;
          } // switch end
          break;
        } // if end
      } // i loop end
      m = m + 2;
      flag1 = 0;
      flag2 = 0;
    } while (m < enmsg.length());
    System.out.println("\n\nPlayfair Plain Text:\n\t" + plainmsg);
  }
}