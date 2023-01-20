import java.util.Scanner;
public class lab23 {
    public static int[]num=new int[1000010];
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        //int[] num = new int[m];
        double big=0;
        for (int i = 0; i < m; i++) {
            num[i] = input.nextInt();
            if(num[i]>big) big=num[i];
        }
        System.out.println(String.format("%.7f",MinArea(0,Math.pow(big,2)*Math.PI,n,m)));
    }
        public static double MinArea(double low , double high  , int n, int m){
        double mid=(high + low) / 2;
        int amount=0;
        if(low<high) {
            if (Math.abs(low-high) >= 1E-6) {
                for (int i = 0; i < m; i++) {
                    amount += Math.floor((Math.pow(num[i],2)*Math.PI) / mid);
                }
                if (amount < n) {
                    return MinArea(low, mid,  n, m);
                }
                if(amount==n && Math.abs(low-high)<=1E-6 ){return mid;}
                if(amount==n&&Math.abs(low-high)>1E-6){
                    return MinArea(mid,high,n,m);
                }
                if (amount > n) {
                    return MinArea(mid, high,  n, m);
                }
            }
        }
            return mid;
        }

}
