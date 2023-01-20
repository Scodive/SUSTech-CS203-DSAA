import java.util.Scanner;

public class path2 {
    public static void  main(String[] args) {
        Scanner input = new Scanner(System.in);
        long x1 = input.nextInt();
        long y1 = input.nextInt();
        long x2 = input.nextInt();
        long y2 = input.nextInt();
        int M = input.nextInt();
        long m = x2 - x1 ;
        //m=m%M;
        long n = y2 - y1 ;
        //n=n%M;
      long a=1,b=1,c=n;
        long result;
        long s = m+n;
        long d,e;
        for(int i = 0 ; i < n ; i++){
            //d=s%M;
            a*=s;
            //a=a%M;
            //e=c%M;
            b*=c;
            //b=b%M;
            s--;
            c--;
        }
        result=(a/b)%M;
        System.out.println(result);
    }
}
