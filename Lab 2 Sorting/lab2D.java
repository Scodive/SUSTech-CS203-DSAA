import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static long n;
    public static long res;
    public static long num[][] = new long[300001][11];
    public static long zhi[] = new long[4000001];
    public static long zhi2[] = new long[4000001];

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        n = in.nextInt();
        long m = in.nextInt();
        long S = in.nextInt();
        long shun=0;
        long ans=0;
        for (int i = 0; i < n; i++) {
            long number = in.nextInt();
            ans += number;
            //int j = 0;


            if (number < 0) {
                number = Math.abs(number);
                String c = String.valueOf(number);
                int wei = c.length();
                while (number > 0) {
                    long yu = number % 10;//取余
                    num[i][wei - 1] = yu;
                    wei--;
                    number = number / 10;//相除，让num变量/10，得到的结果再保存到num变量中
                }

                wei = c.length();
                long cha1, cha2;
                long check = 0, minint = 0;


                while (check < wei) {
                    long min = (long) 1E11, pan = 0;
                    for (long j = check; j < wei; j++) {//加循环

                        if (num[i][(int) j] < min && j != check) {
                            min = num[i][(int) j];
                            minint = j;
                            pan++;
                        }
                    }
                    if (num[i][(int) check] < num[i][(int) minint]) {
                        check++;
                    } else {
                        if (pan == 0) break;
                        cha1 = num[i][(int)check] - num[i][(int) minint];
                        cha2 = 10 - cha1;
                        zhi2[(int) shun] = (int) ((cha1 - 1) * Math.pow(10, wei - check - 1)) + (int) (cha2 * Math.pow(10, wei - minint - 1));
                        for (long k = wei - check - 2; k > wei - minint - 1; k--) {
                            zhi2[(int) shun] += 9 * Math.pow(10, k);
                        }
                        zhi2[(int) shun] -= S;
                        num[i][(int) minint] = num[i][(int) check];
                        num[i][(int) check] = min;
                        check++;
                        shun++;
                    }
                }

            } else {
                String c = String.valueOf(number);
                int wei = c.length();


                while (number > 0) {
                    long yu = number % 10;//取余
                    num[i][wei - 1] = yu;
                    wei--;
                    number = number / 10;//相除，让num变量/10，得到的结果再保存到num变量中
                }

                wei = c.length();
                long cha1, cha2;
                long check = 0, maxint = 0;


                while (check < wei) {
                    long max = 0, pan = 0;
                    for (long j = check; j < wei; j++) {//加循环

                        if (num[i][(int) j] > max && j != check) {
                            max = num[i][(int) j];
                            maxint = j;
                            pan++;
                        }
                    }
                    if (num[i][(int) check] > num[i][(int) maxint]) {
                        check++;
                    } else {
                        if (pan == 0) break;
                        cha1 = num[i][(int) maxint] - num[i][(int) check];
                        cha2 = 10 - cha1;
                        zhi2[(int) shun] = (int) ((cha1 - 1) * Math.pow(10, wei - check - 1)) + (int) (cha2 * Math.pow(10, wei - maxint - 1));
                        for (long k = wei - check - 2; k > wei - maxint - 1; k--) {
                            zhi2[(int) shun] += 9 * Math.pow(10, k);
                        }
                        zhi2[(int) shun] -= S;
                        num[i][(int) maxint] = num[i][(int) check];
                        num[i][(int) check] = max;
                        check++;
                        shun++;
                    }
                }
            }
        }
       /*for(int i =0 ; i<10 ; i++){
           out.print(zhi2[i]);
           out.print(" ");
       }*/
        MergeArray(0, (int) (shun-1));

        /*for(int i =0 ; i<10 ; i++){
            out.print(zhi2[i]);
            out.print(" ");
        }*/

        for(long i=shun-1 ; i>shun-1-m ;i-- ){
            if(i>=0){
                if(zhi2[(int) i]>=0){
                    ans+=zhi2[(int) i];
                }
            }
        }
        out.println(ans);
        out.close();
    }


   public static long[] MergeArray(int left , int right){
        if(left<right){//找中间点
            int mid=(left+right)/2;
            MergeArray(left,mid);//递归划分左半边
            MergeArray(mid+1,right);
            MergeSort(left,right);
        }else return zhi2;
        return zhi2;
    }

    public static long[] MergeSort(int left , int right){
        if(left<right) {
            int mid = (left + right) / 2;
            int i = left;//标记左半区第一个未排序的元素
            int j = mid + 1;
            int k = 0;//临时数组元素的下标
            while (i <= mid && j <= right) {
                if (zhi2[i] > zhi2[j]) {
                    zhi[k] = zhi2[j];//右半区第一个元素小
                    k++;
                    j++;
                    res += mid - i + 1;
                } else {
                    zhi[k] = zhi2[i];//左半区第一个元素小
                    k++;
                    i++;
                }
            }
            while (i <= mid) {//合并左半区剩余的元素
                zhi[k] = zhi2[i];
                k++;
                i++;
            }
            while (j <= right) {//合并右半区剩余的元素
                zhi[k] = zhi2[j];
                k++;
                j++;
            }
            for (i = 0; i < k; i++) {
                zhi2[i + left] = zhi[i];
            }
        }else return zhi2;
        return zhi2;
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
