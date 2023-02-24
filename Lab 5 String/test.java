import java.util.Scanner;

public class test {
    public static long []strHash = new long[400000];
    public static long []strHash2 = new long[400000];
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int s1l = s1.length();
        int s2l = s2.length();
        char[] chars1 = new char[s1l];
        for(int i=0 ; i<s1l ; i++){
            chars1[i]=s1.charAt(i);
        }
        char[] chars1re = new char[s1l];
        for(int i=0 ; i<s1l ; i++){
            chars1re[i]=s1.charAt(s1l-i-1);
        }
        char[] chars2 = new char[s2l];
        for(int i=0 ; i<s2l ; i++){
            chars2[i]=s2.charAt(i);
        }
        char[] chars2re = new char[s2l];
        for(int i=0 ; i<s2l ; i++){
            chars2re[i]=s2.charAt(s2l-i-1);
        }
        FindHash(2,chars1,strHash,31,100000007,s1l);
        FindHash(2,chars1re,strHash2,31,100000007,s2l);
        System.out.println("1");
    }
    public static void FindHash(int slength, char[] chars1 , long[] strHasha,int D ,int M,int s1l){//slength为二分的k
        for(int j=0 ; j < slength ; j++) {
            long value = chars1[j];
            for (int i = 0; i < slength-j-1; i++) {
                value *= D;
                value = value % M;
            }
            if(slength-j-1!=0) {
                strHasha[0] += value;
                strHasha[0] = strHasha[0] % M;
            }else {
                strHasha[0] += chars1[j];
                strHasha[0] = strHasha[0] % M;
            }
        }
        for(int i=1 ; i<=s1l-slength ;i++){
            strHasha[i] = strHasha[i - 1];
            long value = chars1[i-1];
            for(int j=0 ; j<slength-1 ; j++) {
                value *= D;
                value = value % M;
            }
            strHasha[i] -= value;
            strHasha[i] = strHasha[i] % M;
            strHasha[i] *= D;
            strHasha[i] = strHasha[i] % M;
            strHasha[i] += chars1[i+slength-1];
            strHasha[i] = strHasha[i] % M;
        }
    }

}
