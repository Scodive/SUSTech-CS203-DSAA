import java.io.*;
import java.util.StringTokenizer;
public class Main {
        public static int [] sum = new int[2000000];
        public static int [] sum2 = new int[2000000];
        public static int [] queue = new int[2000000];
        public static int [] queue2 = new int[2000000];
        public static void main(String[] args) {
            QReader in = new QReader();
            QWriter out = new QWriter();
            int front = 1, rear = 0;
            int n = in.nextInt();
            int ans=0,min=1000000;
            for (int i = 1; i <= n; i++) {
                queue[i] = in.nextInt();
                sum[i] = sum[i - 1] + queue[i];
                queue[i]=i;
            }
            MergeArray(0,n);
            for(int i=0 ; i<=n ; i++){
                if(queue[i]<min){
                    min=queue[i];
                }
                if(queue[i]-min>ans){
                    ans=queue[i]-min;
                }
            }
            out.println(ans);
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
                if (sum[i] > sum[j]) {
                    sum2[k] = sum[j];
                    queue2[k]=queue[j]; //右半区第一个元素小
                    k++;j++;
                } else {
                    sum2[k] = sum[i];//左半区第一个元素小
                    queue2[k]=queue[i];
                    k++;i++;
                }
            }
            while (i <= mid) {//合并左半区剩余的元素
                sum2[k] = sum[i];
                queue2[k]=queue[i];
                k++;i++;
            }
            while (j <= right) {//合并右半区剩余的元素
                sum2[k] = sum[j];
                queue2[k]=queue[j];
                k++;j++;
            }
            for (i = 0; i < k; i++) {
                sum[i + left] = sum2[i];
                queue[i+left] = queue2[i];
            }
        }else return;
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
