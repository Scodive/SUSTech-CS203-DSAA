import java.util.Scanner;

public class lab43 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        Long[] stack = new Long[200000];
        Long[] queue = new Long[200000];
        int front = 1, rear = 0;
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        long[]ansarr = new long[200000];
        for(int i=1 ; i<=n ;i++){
            stack[i]=in.nextLong();
            while(front<=rear && queue[front]<=i-k){
                front++;
            }
            while(front<=rear && stack[Math.toIntExact(queue[rear])]<=stack[i]) {
                rear--;
            }
            queue[++rear] = (long) i;
            if(i>=k){
                ansarr[i]=stack[Math.toIntExact(queue[front])];
            }
        }
        for(int i=1; i <=q ; i++){
            int sh = in.nextInt();
            System.out.println(ansarr[sh+k-1]);
        }
    }
}
