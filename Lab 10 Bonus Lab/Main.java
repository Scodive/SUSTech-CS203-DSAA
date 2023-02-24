import java.io.*;
import java.util.*;

public class Main {
        static int index;
        static int[] result;
        static int check=0,count=0;
        static int[] reverse;
        static boolean cycle=true;
        static Heap heap;
        public static void main(String[] args) {
            QReader in  = new QReader();
            QWriter out = new QWriter();
            int N= in.nextInt();
            for (int z = 0; z <N ; z++) {
                int n = in.nextInt();
                int m = in.nextInt();
                cycle=true;
                result = new int[n];
                reverse = new int[n];
                index = 0;
                Node[] nodes = new Node[n];
                Node[] renode = new Node[n];
                heap = new Heap(n);
                for (int i = 0; i < n; i++) {
                    nodes[i] = new Node(i);
                    renode[i] = new Node(i);
                }
                for (int i = 0; i < m; i++) {
                    int a = in.nextInt() - 1;
                    int b = in.nextInt() - 1;
                    nodes[a].children.add(nodes[b]);
                    renode[b].children.add(renode[a]);
                }
                for (int i = 0; i < n && cycle; i++) {
                    if (renode[i].state == 0) {
                        dfs(i, renode);
                    }
                }
                if (!cycle) {
                    out.println("impossible");
                } else {
                    in
                    out.println("");
                }
            }
            out.close();
        }
    public static void dfs(int a, Node[] nodes){
        Node temp = nodes[a];
        temp.state=1;
        int children = temp.children.size();
        for (int i = 0; i < children; i++) {
            if(temp.children.get(i).state==0){
                dfs(temp.children.get(i).value,nodes);
                if(!cycle){
                    return;
                }
            }else if(temp.children.get(i).state==1){
                cycle=false;
                return;
            }
        }
        temp.state=2;
            reverse[index++] = temp.value;
    }

    static class Node{
        int value;
        int state=0;
        boolean isVisited=false;
        ArrayList<Node> children;
        public Node(int index) {
            this.children=new ArrayList<>();
            this.value=index;
        }
    }
    static class Heap {
    Node[] heap;
    int size = 0;
    public Heap(int n) {
        heap = new Node[n + 1];
    }

    public void insert(Node x) {
        size++;//放到最后
        heap[size] = x;
        int temp = size;
        while (temp > 1) {//交换
            if (heap[temp / 2].value > heap[temp].value) {
                Node t = heap[temp / 2];
                heap[temp / 2] = heap[temp];
                heap[temp] = t;
                temp /=2;
            } else break;
        }
    }

    public Node delete() {
        Node q = heap[1];
        heap[1] = heap[size];
        //heap[size].value=0;
        size--;
        //把最后一个节点放到根
        int temp = 1;
        while (size >= temp*2) {
            if (temp * 2 + 1 <= size) {
                if (heap[temp * 2].value < heap[temp].value && heap[temp * 2].value<heap[temp *2 +1].value){
                    Node t = heap[temp * 2];
                    heap[temp * 2] = heap[temp];
                    heap[temp] = t;
                    temp*=2;
                } else if (heap[temp * 2 + 1].value < heap[temp].value) {
                    Node t = heap[temp * 2 + 1];
                    heap[temp * 2 + 1] = heap[temp];
                    heap[temp] = t;
                    temp=temp*2+1;
                } else return q;
            } else {
                if (heap[temp * 2].value < heap[temp].value) {
                    Node t = heap[temp * 2];
                    heap[temp * 2] = heap[temp];
                    heap[temp] = t;
                    temp*=2;
                }else return q;
            }
        }
        return q;
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


