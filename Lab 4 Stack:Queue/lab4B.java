import java.util.Scanner;

public class lab42 {public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] queue = new int[10000000];
    int front = 0, rear = 0;
    int s = in.nextInt();
    int num;
    String ch;
    for (int i = 0; i < s; i++) {
        ch = in.next();
        num = in.nextInt();
        if (ch.equals("E")) {
            queue[rear] = num;
            rear++;
        }
        if (ch.equals("D")) {
            //int xx=1/num;
            for (int j = 0; j < num; j++) {
                queue[front] = 0;
                front++;

            }
            System.out.println(queue[front]);
        }
    }

}
}
