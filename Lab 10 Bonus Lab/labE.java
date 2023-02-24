import java.util.Scanner;

public class labE{
    public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     int N = in.nextInt();
        for (int z = 0; z < N; z++) {
            String s = in.next();
            int next[] = new int[200005];
            int len = s.length();
            int a=0,b=1;
            while(b<len){
                if(s.charAt(b)==s.charAt(a)){
                    next[b++]=++a;
                }else {
                    if(a!=0){
                        a=next[a-1];
                    }else{
                        next[b++]=a;
                    }
                }
            }
            int max = len - next[len-1];
            int result2 = (max - len % max) % max;
            if(max == len){
                System.out.println(len);
            }else if(next[len-1]!=0){
                System.out.println(result2);
            }else System.out.println("0");

        }
    }
}