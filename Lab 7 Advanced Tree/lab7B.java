import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class lab72 {
    private static long sum = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long cases = sc.nextLong();
        while (cases > 0){
            sum = 0;
            Queue<Long> num = new PriorityQueue<>();
            long nums = sc.nextLong();
            for (int i = 0;i < nums;i++){
                num.add(sc.nextLong());
            }
            addAll(num);
            System.out.println(sum);

            cases--;
        }

    }


    private static void addAll(Queue<Long> num){
        long first,second,sums;
        if (!num.isEmpty()){
            first = num.poll();
            if (!num.isEmpty()){
                second = num.poll();
                sums = first + second;
                sum += sums;
                num.add(sums);
                addAll(num);
            }
        }
    }

}
