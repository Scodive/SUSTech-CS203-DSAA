/*样例输入
2
1 1 1
6 2 4
样例输出
..+-+
././|
+-+.+
|.|/.
+-+..
....+-+-+-+-+-+-+
.../././././././|
..+-+-+-+-+-+-+.+
./././././././|/|
+-+-+-+-+-+-+.+.+
|.|.|.|.|.|.|/|/|
+-+-+-+-+-+-+.+.+
|.|.|.|.|.|.|/|/|
+-+-+-+-+-+-+.+.+
|.|.|.|.|.|.|/|/.
+-+-+-+-+-+-+.+..
|.|.|.|.|.|.|/...
+-+-+-+-+-+-+....

*/
import java.util.Scanner;
public class print {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cs = input.nextInt();
        for(int w=0 ; w<cs ; w++){
        int c = input.nextInt();//长
        int k = input.nextInt();//宽
        int g = input.nextInt();//高
        int d1 = (k-1)*2+2;//第一行前面点数
        int zk = d1+c*2+1;//行有多长
        int zc = d1+g*2+1;//列有多长
        int[][] graph = new int[zc+1][zk+1];//0=. 1=+ 2=- 3=/ 4=｜
        for(int a=0 ; a<zc ; a++){
            for(int b=0 ; b <zk ; b++ ){
                graph[zc][zk]=0;
            }
        }
       for(int i=0 ; i<c*2+1 ; i++){
           for(int j = 0 ; j <k*2+1 ; j++){
               for(int e = 0 ; e <g*2+1 ; e++ ){
                   if(i==0 || j==0 || e==0) {
                       if(i%2==0 && j%2==0 && e%2==0)graph[d1-j+e][c*2-i+j]=1;
                       if(i%2==1 && j%2==0 && e%2==0)graph[d1-j+e][c*2-i+j]=2;
                       if(i%2==0 && j%2==1 && e%2==0)graph[d1-j+e][c*2-i+j]=3;
                       if(i%2==0 && j%2==0 && e%2==1)graph[d1-j+e][c*2-i+j]=4;
                   }
               }
           }
       }
        for(int i =0; i<zc ; i++) {
            for (int j = 0; j < zk; j++) {
                if (graph[i][j]==0)System.out.print(".");
                if (graph[i][j]==1)System.out.print("+");
                if (graph[i][j]==2)System.out.print("-");
                if (graph[i][j]==3)System.out.print("/");
                if (graph[i][j]==4)System.out.print("|");
            }System.out.println("");
        }
        }
    }
}
