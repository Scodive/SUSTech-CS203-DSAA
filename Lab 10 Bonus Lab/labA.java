import java.util.Scanner;

public class labA {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    for (int k = 0; k < m; k++) {


        int n = in.nextInt();

        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();

        }
        int max = num[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int temp = max - num[i];
            if (temp > ans) {
                ans = temp;
            }
            if (max < num[i]) {
                max = num[i];
            }
        }

        System.out.println(ans);
    }

}
}