import java.util.Scanner;

public class lab81 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int [][] graph = new int[n][m];
        for (int i = 0; i < m; i++) {
            int temp1 = in.nextInt();
            int temp2 = in.nextInt();
            graph[temp1-1][temp2-1]=1;
            graph[temp2-1][temp1-1]=1;
        }
        for (int i = 0; i < k; i++) {
            int temp1 = in.nextInt();
            int temp2 = in.nextInt();
            if(graph[temp1-1][temp2-1]==1){
                System.out.println("Yes");
            }else System.out.println("No");
        }
    }

}
