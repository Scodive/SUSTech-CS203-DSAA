import java.util.Scanner;
public class checklab22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s= in.nextInt();
        for(int k=0;k<s ;k++) {
            int n = in.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            boolean flag = true;
            int res = 0;
            while (flag) {
                int count = 0;
                for (int j = 1; j < num.length; j++) {
                    if (num[j - 1] > num[j]) {
                        int temp = num[j];
                        num[j] = num[j - 1];
                        num[j - 1] = temp;
                        count++;
                        res++;
                    }
                }
                if (count == 0) {
                    flag = false;
                }
            }
            System.out.println(res);
        }
    }
}
