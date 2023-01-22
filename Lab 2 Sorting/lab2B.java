import java.io.*;
import java.util.StringTokenizer;

public class lab22 {
    public static int n;
    public static long res;
    public static int num[] = new int[100002];
    public static int num2[] = new int[100002];
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int s= in.nextInt();
        for(int k=0;k<s ;k++) {
            n = in.nextInt();
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            MergeArray(0,n-1);
            out.println(res);
            res=0;
        }
        out.close();
    }
    public static void MergeArray(int left , int right){
        if(left<right){//找中间点
        int mid=(left+right)/2;
        MergeArray(left,mid);//递归划分左半边
        MergeArray(mid+1,right);
        MergeSort(left,right);
        }else return;
    }

    public static void MergeSort(int left , int right){
        if(left<right) {
            int mid = (left + right) / 2;
            int i = left;//标记左半区第一个未排序的元素
            int j = mid + 1;
            int k = 0;//临时数组元素的下标
            while (i <= mid && j <= right) {
                if (num[i] > num[j]) {
                    num2[k] = num[j];//右半区第一个元素小
                    k++;
                    j++;
                    res += mid - i + 1;
                } else {
                    num2[k] = num[i];//左半区第一个元素小
                    k++;
                    i++;
                }
            }
            while (i <= mid) {//合并左半区剩余的元素
                num2[k] = num[i];
                k++;
                i++;
            }
            while (j <= right) {//合并右半区剩余的元素
                num2[k] = num[j];
                k++;
                j++;
            }
            for (i = 0; i < k; i++) {
                num[i + left] = num2[i];
            }
        }else return;
    }
}


