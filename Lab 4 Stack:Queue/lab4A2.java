import java.io.*;
import java.util.StringTokenizer;
public class lab41B {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        Long[] stack = new Long[200000];
        int point = 0;
        String s;
        long ans = 0;
        s = in.next();
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (ch[i] == '(') {
                stack[point] = (long) -1;
                point++;
            } else {
                if (stack[point - 1] == (long) -1) {
                    stack[point - 1] = (long) 0;
                    point--;
                    if (stack[0] == (long) 0) {
                        stack[0] = ((long) 1);
                        point++;
                    } else if (stack[point - 1] > 0) {
                        ans = stack[point - 1];
                        stack[point - 1] = (long) 0;
                        point--;
                        while (stack[0] != 0 && stack[point - 1] > 0) {
                            ans += stack[point - 1];
                            ans %= 514329;
                            stack[point - 1] = (long) 0;
                            point--;
                        }
                        point++;
                        stack[point - 1] = ((ans + 1) % 514329);
                    } else {
                        stack[point] = ((long) 1);
                        point++;
                        continue;
                    }
                } else {
                    ans = stack[point - 1];
                    stack[point - 1] = (long) 0;
                    point--;
                    while (point >= 0 && stack[point - 1] > 0) {
                        ans += stack[point - 1];
                        stack[point - 1] = (long) 0;
                        point--;
                        ans %= 514329;
                    }
                    ans *= 2;
                    ans %= 514329;
                    stack[point - 1] = (long) 0;
                    stack[point - 1] = (ans);
                }
            }
        }
        ans = stack[point - 1] % 514329;
        out.println(ans);
        out.close();
    }
}

