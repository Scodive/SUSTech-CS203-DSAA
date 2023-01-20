import java.util.Scanner;
public class path {
    public static void  main(String[] args) {
        Scanner input = new Scanner(System.in);
        long x1 = input.nextInt();
        long y1 = input.nextInt();
        long x2 = input.nextInt();
        long y2 = input.nextInt();
        int M = input.nextInt();
        long m = x2 - x1 + 1;//间隔为n 总共n+1个点
        //m=m%M;
        long n = y2 - y1 + 1;
        //n=n%M;
        long[] dp = new long[(int) n];//每个点可能路径为该点上加右侧点路径只和
        dp[0] = 1;//直线到达路径都只有1种
        for (int i = 0; i < m; i++) {//循环m次
            for (int j = 1; j < n; j++) {//只需要循环后面n个点
                dp[j] += dp[j - 1];
                dp[j]=dp[j]%M;//取模降低数字大小
            }
        }
        System.out.print(dp[(int) (n - 1)]);
    }}



