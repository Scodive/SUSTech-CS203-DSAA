public class lab23 {public static int n;
    public static long res;
    public static long num[] = new long[1000002];
    public static long num2[] = new long[1000002];

        public static void main (String[]args){
            QReader in = new QReader();
            QWriter out = new QWriter();
            n = in.nextInt();
            long ans = 0;
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            MergeArray(0, n - 1);
            long a = n % 3;
            long b = n / 3;
            ans = b;

            for (int i = 0; i < n; i++) {
                num2[i] = -1;
            }
            for (int i = 0; i < n - a; i = i + 3) {
                num2[i] = num[i / 3];
            }
            int j = 0;
            for (int i = 1; i < n; i++) {

                if (num2[i] == -1) {
                    num2[i] = num[(int) b + j];
                    j++;
                }
            }
            out.println(num[(int) ans]);
            for (int i = 0; i < n; i++) {
                out.print(num2[i] + " ");
            }
            out.close();
        }


    public static long[] MergeArray(int left , int right){
        if(left<right){//找中间点
            int mid=(left+right)/2;
            MergeArray(left,mid);//递归划分左半边
            MergeArray(mid+1,right);
            MergeSort(left,right);
        }else return num;
        return num;
    }

    public static long[] MergeSort(int left , int right){
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
        }else return num;
        return num;
    }
}


