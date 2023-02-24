import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long sum = 0;
        boolean check1, check2 = false, check3, check4;
        int checka0=0;
        long degree[] = new long[n+1];
        long inverse[] = new long[n+1];
        for (int i = 1; i <= n; i++) {
            long temp = in.nextLong();
            degree[i] = temp;
            sum += temp;
            if(temp>0){
                checka0++;
            }
        }
        Arrays.sort(degree);
        for (int i = 1; i <= n; i++) {
            inverse[n+1-i]=degree[i];
        }

        int pointeri = 0, pointerk=n,sumin=0;
        for (int i = 1; i <= n; i++) {
            sumin += inverse[n+1-i];
            degree[n+1-i]=sumin;
        }
        for (int i = 0; i < n; i++) {
            long need=0,supply=0;
            pointeri++;
            while(inverse[pointerk]<pointeri && pointerk>pointeri){
                pointerk--;
            }
            if(pointeri>pointerk){
                pointerk=pointeri;
            }
            if(pointeri+1<=n) {
                need = degree[1] - degree[pointeri + 1];
            }else need=degree[1];
            if(pointeri==n){
                supply = (long) pointeri * (pointeri - 1);
            }
            else if(pointerk+1>n) {
                supply = (long) pointeri * (pointeri - 1) + (long) (pointerk - pointeri) * pointeri;
            }
            else {
                supply = (long) pointeri * (pointeri - 1) + (long) (pointerk - pointeri) * pointeri + degree[pointerk + 1];
            }
            if(need<=supply){
                check2=true;
            }else{
                check2=false;
                break;
            }
        }

        if(check1method(sum)){
            check1=true;
        }else check1=false;
        if(check3method(sum,n)){
            check3=true;
        }else check3=false;
        if(checka0==n){
            check4=true;
        }else check4=false;
        

        if(check1){
            System.out.println("YES");
         }else System.out.println("NO");
        if(check1 && check2 ){
            System.out.println("YES");
         }else System.out.println("NO");
        if(check1 && check2 && check3 && check4){
            System.out.println("YES");
         }else System.out.println("NO");


    }
    public static boolean check1method (long sum) {
         if(sum%2==0) {
             return true;
         }else return false;
    }
    public static boolean check3method (long sum,int n) {
        if(sum==2*n-2) {
            return true;
        }else return false;
    }

}



