import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static long []strHash = new long[500000];
    public static long []strHash2 = new long[500000];
    public static long []strHash3 = new long[500000];
    public static long []strHash4 = new long[500000];
    public static long []ans1 = new long[500000];
    public static long []ans2 = new long[500000];
    public static long []ans3 = new long[500000];
    public static long []ans4 = new long[500000];
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        String s1 = in.next();
        String s2 = in.next();
        int D = 31, M = 100000007;
        if (s1.length() > s2.length()) {//s1为较短的字符串
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }
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
        int k;
        if (s1l % 2 != 0) {//s1长度为奇数
             k = (s1l - 1) / 2;
        } else k = s1l /2;
        //out.println(CheckHash(5,chars1,chars1re,chars2,chars2re,D,M,s1l,s2l));

        out.println(Math.max(Binary(0,k,chars1,chars1re,chars2,chars2re,D,M,s1l, s2l),Binary2(0,k,chars1,chars1re,chars2,chars2re,D,M,s1l, s2l)));
        out.close();
    }

        public static int Binary(int low , int high  ,char []chars1 , char[] chars1re , char[] chars2 , char[] chars2re,int D , int M ,int s1l,int s2l){
           int mid=0,ans=0,check1=0,check2=0;
           while(low<=high) {
               check1++;
               mid = low+(high-low)/2;
               if(s1l==3){
                   if(CheckHash(mid*2+1, chars1, chars1re, chars2, chars2re, D, M, s1l, s2l) != true){
                     return 0;
                   }else {
                       mid = 1;
                       check2++;
                       break;
                   }
               }
               if(mid==0){
                   if(CheckHash(mid*2+1, chars1, chars1re, chars2, chars2re, D, M, s1l, s2l) == true){
                       check2++;
                   }
                   break;
               }
               if (CheckHash(mid*2+1, chars1, chars1re, chars2, chars2re, D, M, s1l, s2l) == true) {
                  low=mid+1;
                  ans=mid;
                  check2++;
               }else{
                   high=mid-1;
                   check2++;
               }
           }
           if(check1==0 && chars1[0]!=chars2[0] ){
              return 0;
         }
           if(check1==1 && ans==0 && check2==0){
               return 0;
           }

           return ans*2+1;
        }
      public static int Binary2(int low , int high  ,char []chars1 , char[] chars1re , char[] chars2 , char[] chars2re,int D , int M ,int s1l,int s2l){
        int mid=0,ans=0;
        while(low<=high) {
            if(high==0){
                break;
            }
            if(low==high){
                mid=high;
            }else {
                mid = low+(high-low)/2;
            }
            if(low==0 && high==1){
                mid=1;
            }
            if(mid==0){
                break;
            }
            if (CheckHash(mid*2, chars1, chars1re, chars2, chars2re, D, M, s1l, s2l) == true) {
                low=mid+1;
                ans=mid;
            }else{
                high=mid-1;
            }
        }
        return ans*2;
    }

        public static boolean CheckHash(int slength , char []chars1 , char[] chars1re , char[] chars2 , char[] chars2re,int D , int M ,int s1l,int s2l){
            FindHash(slength,chars1,strHash,D,M,s1l);
            FindHash(slength,chars1re,strHash2,D,M,s1l);
            int j=0,k=0;
            for(int i=0 ; i<s1l-slength+1 ; i++){
                if(strHash[i]==strHash2[s1l-slength-i] || Math.abs(strHash[i])+Math.abs(strHash2[s1l-slength-i])==M){

                    ans1[j] = strHash[i];
                    j++;
                }
            }
            if(j==0){
                return false;
            }
            FindHash(slength,chars2,strHash3,D,M,s2l);
            FindHash(slength,chars2re,strHash4,D,M,s2l);
            for(int i=0 ; i<s2l-slength+1 ; i++){
                if(strHash3[i]==strHash4[s2l-slength-i] || Math.abs(strHash3[i])+Math.abs(strHash4[s2l-slength-i])==M){
                    ans2[k]=strHash3[i];
                    k++;
                }
            }


            ans3=MergeSort(ans1,j);
            ans4=MergeSort(ans2,k);
            int o=0,p=0;
            while(o!=j && p!=k) {
                if (ans3[o] == ans4[p] || Math.abs(ans3[o]) + Math.abs(ans4[p]) == M) {
                    return true;
                } else {
                    if (ans3[o] < ans4[p]) {
                        o++;
                    } else p++;
                }
            }
            return false;
        }
    public static long[] MergeSort(long[] A, long n) {
        long[] res=A;
        if (n > 1) {
            long p = n / 2;
            long[] B = new long[(int)p];
            long[] C = new long[(int)(n - p)];
            for (int i = 0; i < p; i++) {
                B[i] = A[i];
            }
            for (int j = 0; j < n - p; j++) {
                C[j] = A[(int) (j + p)];
            }
            long[] E = MergeSort(B, p);
            long[] F = MergeSort(C, n - p);
            res = Combine(E, p, F, n);
        }else return res;
        return res;
    }

    public static long[] Combine(long[] B, long p, long[] C, long n) {
        long[] D = new long[(int) n];
        int i = 0, j = 0;
        int check = 0;
        for (int k = 0; k < n; k++) {
            if (i<=p-1&&(j > n - p-1 ||B[i] <= C[j] ) ) {
                D[k]=B[i];
                i++;
            }else {
                D[k]=C[j];
                j++;
            }
        }
        return D;
    }
        public static void FindHash(int slength, char[] chars1 , long[] strHasha,int D ,int M,int s1l){//slength为二分的k
        long[] ass = new long[slength];
        ass[slength-1]=1;
        for(int i=0 ; i<=slength-2 ; i++){
                ass[slength-i-2]=ass[slength-i-1]*D;
        }
            strHasha[0]=0;
            for(int j=0 ; j < slength ; j++) {
            strHasha[0]+=chars1[j]*ass[j];
            strHasha[0]=strHasha[0]%M;
        }
            for(int i=1 ; i<=s1l-slength ;i++){
                strHasha[i] = strHasha[i - 1];
                strHasha[i] -= chars1[i-1] * ass[0];
                strHasha[i] = strHasha[i] % M;
                strHasha[i] *= D;
                strHasha[i] = strHasha[i] % M;
                strHasha[i] += chars1[i+slength-1];
                strHasha[i] = strHasha[i] % M;
            }
        }
}
class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}
