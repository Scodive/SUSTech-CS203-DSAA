//import java.io.*;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class lab71o {public static void main(String[] args) {
//    QReader in = new QReader();
//    QWriter out = new QWriter();
//    int n = in.nextInt();
//    int m = in.nextInt();
//    int k = in.nextInt();
//    long[] a = new long[n];
//    long[] b = new long[m];
//    long[] ans = new long[k];
//    for (int i = 0; i < n; i++) {
//        a[i] = in.nextLong();
//    }
//    for (int i = 0; i < m; i++) {
//        b[i] = in.nextLong();
//    }
//    Arrays.sort(a);
//    //Arrays.sort(b);
//    //int index = 0;
//    heap heap = new heap(m + k);
//    for (int j = 0; j < m; j++) {
//        long temp = a[0] * b[j];
//        heap.insert(new Node(temp,0,j));
//    }
//    // int ans = 0;
//    for (int i = 0; i < k; i++) {
//        Node q = heap.delete();
//        ans[i] = q.value;
//        if (q.indexA+1 <= n - 1) {
//            heap.insert(new Node( b[(int) q.indexB] * a[(int) (q.indexA+1)],q.indexA+1,q.indexB));
//            //index++;
//        }
//    }
//
//    for (int i = 0; i < k; i++) {
//        out.print(ans[i]+" ");
//    }
//    out.close();
//}
//}
//class Node{
//    long value;
//    long indexA;
//    long indexB;
//
//    public Node(long value, long indexA,long indexB) {
//        this.value=value;
//        this.indexA=indexA;
//        this.indexB=indexB;
//    }
//}
//class heap {
//    Node[] heap;
//    int size = 0;
//    public heap(int n) {
//        heap = new Node[n + 1];
//    }
//
//    public void insert(Node x) {
//        size++;//放到最后
//        heap[size] = x;
//        int temp = size;
//        while (temp > 1) {//交换
//            if (heap[temp / 2].value > heap[temp].value) {
//                Node t = heap[temp / 2];
//                heap[temp / 2] = heap[temp];
//                heap[temp] = t;
//                temp /=2;
//            } else break;
//        }
//    }
//
//    public Node delete() {
//        Node q = heap[1];
//        heap[1] = heap[size];
//        //heap[size].value=0;
//        size--;
//        //把最后一个节点放到根
//        int temp = 1;
//        while (size >= temp*2) {
//            if (temp * 2 + 1 <= size) {
//                if (heap[temp * 2].value < heap[temp].value && heap[temp * 2].value<heap[temp *2 +1].value){
//                    Node t = heap[temp * 2];
//                    heap[temp * 2] = heap[temp];
//                    heap[temp] = t;
//                    temp*=2;
//                } else if (heap[temp * 2 + 1].value < heap[temp].value) {
//                    Node t = heap[temp * 2 + 1];
//                    heap[temp * 2 + 1] = heap[temp];
//                    heap[temp] = t;
//                    temp=temp*2+1;
//                } else return q;
//            } else {
//                if (heap[temp * 2].value < heap[temp].value) {
//                    Node t = heap[temp * 2];
//                    heap[temp * 2] = heap[temp];
//                    heap[temp] = t;
//                    temp*=2;
//                }else return q;
//            }
//        }
//        return q;
//    }
//}
//class QReader {
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private StringTokenizer tokenizer = new StringTokenizer("");
//
//    private String innerNextLine() {
//        try {
//            return reader.readLine();
//        } catch (IOException e) {
//            return null;
//        }
//    }
//
//    public boolean hasNext() {
//        while (!tokenizer.hasMoreTokens()) {
//            String nextLine = innerNextLine();
//            if (nextLine == null) {
//                return false;
//            }
//            tokenizer = new StringTokenizer(nextLine);
//        }
//        return true;
//    }
//
//    public String nextLine() {
//        tokenizer = new StringTokenizer("");
//        return innerNextLine();
//    }
//
//    public String next() {
//        hasNext();
//        return tokenizer.nextToken();
//    }
//
//    public int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    public long nextLong() {
//        return Long.parseLong(next());
//    }
//}
//
//class QWriter implements Closeable {
//    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//    public void print(Object object) {
//        try {
//            writer.write(object.toString());
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    public void println(Object object) {
//        try {
//            writer.write(object.toString());
//            writer.write("\n");
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    @Override
//    public void close() {
//        try {
//            writer.close();
//        } catch (IOException e) {
//            return;
//        }
//    }
//}
//
//
