import java.io.*;
import java.util.StringTokenizer;

public class lab21{
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        long n = in.nextInt();
        long[] A = new long[(int) n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        A=MergeSort(A, n);
        for (int i = 0; i < n / 2; i++) {
            ans += A[i] * A[(int)(n - 1 - i)];
        }
        out.println(ans);
        out.close();
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
}

