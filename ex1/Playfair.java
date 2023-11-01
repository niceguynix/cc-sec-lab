import java.util.*;

class Playfair{
  static char[][] key;
  public static int[] getPos(char letter){
    if(letter=='j'){
      letter='i';
    }
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        if(key[i][j]==letter){
          return new int[]{i,j};
        }

      }
    }
    return new int[]{0,0};
  }

  public static String getKeyString(){
    String res="";
    for(char[] carr:key){
      for(char c:carr){
        res+=c;
      }
    }
    return res;
  }



  public static String encrypt(String msg){
    if(msg.length()%2!=0){
      msg+="x";
    }

    String emsg="";

    for(int i=0;i<msg.length();i+=2){
      int[] apos=getPos(msg.charAt(i));
      int[] bpos =getPos(msg.charAt(i+1));

      if(apos[0]==bpos[0]){
        int an=(apos[1]+1)%5;
        int bn=(bpos[1]+1)%5;
        emsg=emsg+key[apos[0]][an]+key[bpos[0]][bn];
        // System.out.println(bpos[0]+"gr"+bpos[1]);
      }else if(apos[1]==bpos[1]){
        // System.out.println(bpos[0]+" "+bpos[1]);
        int an=(apos[0]+1)%5;
        int bn=(bpos[0]+1)%5;
        emsg=emsg+key[an][apos[1]]+key[bn][bpos[1]];
      
      }else{
        emsg=emsg+key[apos[0]][bpos[1]]+key[bpos[0]][apos[1]];
      }
    }
    return emsg;
  }

  public static void generateKey(String keyStr){
    int i=0;
    int j=0;
    int c=0;
    key=new char[5][5];
    keyStr=keyStr.replace('j', 'i');
    String al="abcdefghiklmnopqrstuvwxyz";
    do{
      if(c<keyStr.length()){
        char t=keyStr.charAt(c);
        if(getKeyString().indexOf(t)!=-1){
          c+=1;
          continue;
        }
        key[i][j]=keyStr.charAt(c);
      }else{
        for(char ch:al.toCharArray()){
          if(getKeyString().indexOf(ch)==-1){
           key[i][j]=ch;
           break;
          }
        }
      }
    
      if(j==4){
        i+=1;
        j=-1;
      }
      j+=1;
      c+=1;
    }while(c<25);
  }

  public static void main(String args[]){
    String keyStr="manoj";
    String msg="manoj";

    generateKey(keyStr);
    System.out.println(getKeyString());
    System.out.println(encrypt(msg));
  }
}