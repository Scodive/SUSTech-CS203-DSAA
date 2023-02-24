import java.util.Objects;
import java.util.Scanner;

public class labD {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    for (int k = 0; k < m; k++) {
        int n = in.nextInt();
        String string = in.next();
        String[] num = new String[n];
        int pointer = 0, say = 0;
        for (int i = 0; i < string.length(); i++) {
            String w = string.substring(i, i + 1);
            if (pointer == 0) {
                num[pointer++] = w;
                continue;
            }
            if (w.equals(String.valueOf('}'))) {
                if (!Objects.equals(num[--pointer], String.valueOf('{'))) {
                    System.out.println("NO");
                    say++;
                    break;
                }
            } else if (w.equals(String.valueOf(']'))) {
                if (!Objects.equals(num[--pointer], String.valueOf('['))) {
                    System.out.println("NO");
                    say++;
                    break;
                }
            } else if (w.equals(String.valueOf(')'))) {
                if (!Objects.equals(num[--pointer], String.valueOf('('))) {
                    System.out.println("NO");
                    say++;
                    break;
                }
            } else num[pointer++] = w;
        }
        if (say == 0) {
            if (pointer == 0 ) {
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }
}
}