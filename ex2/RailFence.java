import java.util.*;

class RailFence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String msg = new String();
    String enmsg = "";
    String pltxt = "";

    System.out.println("Enter the message:");
    msg = sc.next();
    sc.close();

    int depth=2;

    for(int i=0;i<depth;i++){
      for(int j=i;j<msg.length();j+=depth){
        enmsg+=msg.charAt(j);
      }
    }

    double s=enmsg.length()*1.0/depth;
    int x=(int) java.lang.Math.ceil(s);
    for(int i=0;i<x;i++){
      for(int j=i;j<enmsg.length();j+=x){
        pltxt+=enmsg.charAt(j);
      }
    }
    System.out.println(enmsg);
    System.out.println(pltxt);

  }
}
