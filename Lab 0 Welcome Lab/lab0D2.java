import java.util.Objects;
import java.util.Scanner;
public class mahjong2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int zcs = input.nextInt();
        for (int cs = 0; cs < zcs; cs++) {
         String s = input.next();
         int shoupai[]=new int[40];

         for(int i=0 ; i<14 ; i++){
             switch (s.charAt(2*i+1)){
                 case'b':
                     shoupai[s.charAt(2*i)-48]++;break;
                 case's':
                     shoupai[s.charAt(2*i)-38]++;break;
                 case'w':
                     shoupai[s.charAt(2*i)-28]++;break;
                 case'z':
                     shoupai[s.charAt(2*i)-18]++;break;
             }
           }
         if(check(shoupai)){
             System.out.println("Blessing of Heaven");
         }else System.out.println("Bad luck");
        }
    }
    public static boolean check(int []shoupai){
        /*int shoupai1[]=new int[40];
        for(int k=0 ;k<40 ;k++){
            shoupai1[k]=shoupai[k];
        }*/
        for(int i=0 ; i<40 ; i++){
            if(shoupai[i]>=2){
                shoupai[i]=shoupai[i]-2;
        if(checksan1(shoupai)){
            return true;
        }else shoupai[i]=shoupai[i]+2;
            /*for(int j=0;j<40;j++){
                shoupai[j]=shoupai1[j];
               }*/
            }
        }
        return false;
    }
    public static boolean checksan1(int[]shoupai){
        if(check0(shoupai))return true;
        for(int i=0 ; i<40 ; i++){
            if(shoupai[i]>=3) {
                shoupai[i] = shoupai[i] - 3;
        if(checksan1(shoupai)) {
                return true;
            }
            shoupai[i]=shoupai[i]+3;}
            if (shoupai[i] >= 1 && shoupai[i + 1] >= 1 && shoupai[i + 2] >= 1 && i<28) {
                shoupai[i]--;
                shoupai[i + 1]--;
                shoupai[i + 2]--;
            if(checksan1(shoupai))return true;
                shoupai[i]++;
                shoupai[i + 1]++;
                shoupai[i + 2]++;
            }
        }
        return false;
    }

    public static boolean check0(int[]shoupai){
        int jiancha=0;
        for(int j=0;j<40;j++){
            if(shoupai[j]==0){
                jiancha++;
            }
        }if(jiancha==40){return true;}
        return false;
    }
}


