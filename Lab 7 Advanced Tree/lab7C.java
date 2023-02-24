import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        QReader in  = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        if(n==1){
            int tempvalue = in.nextInt();
            out.println(tempvalue);
            //out.close();
        }else if(n==2){
            int tempvalue1 = in.nextInt();
            int tempvalue2 = in.nextInt();
            out.println((tempvalue1^tempvalue2)+1);
        } else  {
            Heap heap = new Heap(n);
            Node heap1[] = new Node[n + 2];
            Node temp;
            for (int j = 0; j < n; j++) {
                int tempvalue = in.nextInt();
                temp = new Node(tempvalue, j + 2);
                heap1[j + 1] = temp;
                //heap.insert(temp);
            }
            Node head = new Node(Integer.MAX_VALUE, 1);
            for (int i = 2; i < n; i++) {
                if (i == 2) {

                    heap1[0] = head;
                    heap1[0].next = heap1[1];
                    heap1[1].pre  = heap1[0];
                    heap1[1].next = heap1[2];
                }
                heap1[i].pre =  heap1[i - 1];
                heap1[i].next = heap1[i + 1];
                if (i == n - 1) {
                    Node tail = new Node(Integer.MAX_VALUE, n + 2);
                    heap1[n + 1] = tail;
                    heap1[n + 1].pre = heap1[n];
                    heap1[n].next = heap1[n + 1];
                    heap1[n].pre = heap1[n - 1];
                }
            }

            for (int i = 0; i < n + 2; i++) {
                heap.insert(heap1[i]);
            }
            // int ans = 0;

            int time = 0;
            heap.addposs();

            while (time < n - 1) {
                Node min = heap.deleteMin();
                //heap.addposs();
                Node min2 = null;
                Node temppre=null, tempnext = null;
                if (min.pre != null && min.next != null) {
                    temppre = min.pre;
                    tempnext = min.next;
                    while (temppre.isDeleted == true) {
                        temppre = temppre.pre;
                    }
                    while (tempnext.isDeleted == true) {
                        tempnext = tempnext.next;
                    }
                    if(temppre.value==Integer.MAX_VALUE){
                        min2=tempnext;
                        tempnext=tempnext.next;
                        while (tempnext.isDeleted == true) {
                            tempnext = tempnext.next;
                        }
                    }else if(tempnext.value==Integer.MAX_VALUE) {
                        min2 = temppre;
                        temppre=temppre.pre;
                        while (temppre.isDeleted == true) {
                            temppre = temppre.pre;
                        }
                    }
                    else if((tempnext.value^min.value)<=(temppre.value^min.value)){
                          min2=temppre;
                        temppre=temppre.pre;
                        while (temppre.isDeleted == true) {
                            temppre = temppre.pre;
                        }
                    }else {
                        min2 = tempnext;
                        tempnext = tempnext.next;
                        while (tempnext.isDeleted == true) {
                            tempnext = tempnext.next;
                        }

                    }
                }
                heap.delete(min2.position);
                //heap.addposs();
                temp = new Node((min.value ^ min2.value) + 1, min.index);
                //temp.position=heap.size;
                //  temp.position=2;
                temp.next=tempnext;
                tempnext.pre=temp;
                temp.pre=temppre;
                temppre.next=temp;
                heap.insert2(temp);
                time++;
            }
            out.println(heap.deleteMin().value);
        }

        out.close();

    }
}
class Node{
    int value;//胡萝卜个数

    int index;//输入的顺序

    int position;//堆里的位置
    boolean isDeleted=false;
    Node pre;
    Node next;
    public Node(int value, int index) {
        this.value=value;
        this.index=index;
    }
}
class Heap {
    Node[] heap;
    //Node[] heap1;
    int size = 0;

    Node temp3,temp4;
    public Heap(int n) {
        heap = new Node[n + 3];
    }

    public void addposs(){
        for (int i = 1; i < size+1; i++) {
            heap[i].position=i;
        }
    }

    public void insert(Node x) {//小顶堆
        size++;//放到最后
        heap[size] = x;
        int temp = size;
        while (temp > 1) {//交换
            if (heap[temp / 2].value > heap[temp].value ) {
                Node t = heap[temp / 2];
                int p = heap[temp].position;
                heap[temp / 2] = heap[temp];
                heap[temp/2].position=t.position;
                heap[temp] = t;
                heap[temp].position = p;
                temp /= 2;
            }
            else if(heap[temp/2].value==heap[temp].value && heap[temp/2].index>heap[temp].index  ) {
                Node t = heap[temp / 2];
                int p = heap[temp].position;
                heap[temp / 2] = heap[temp];
                heap[temp/2].position=t.position;
                heap[temp] = t;
                heap[temp].position = p;
                temp /= 2;
            }
            else break;
        }
    }

    public void insert2(Node x) {//小顶堆
        size++;//放到最后
        heap[size] = x;
        heap[size].position=size;
        int temp = size;
        while (temp > 1) {//交换
            if (heap[temp / 2].value > heap[temp].value ) {
                Node t = heap[temp / 2];
                int p = heap[temp].position;
                heap[temp / 2] = heap[temp];
                heap[temp/2].position=t.position;
                heap[temp] = t;
                heap[temp].position = p;
                temp /= 2;
            }
            else if(heap[temp/2].value==heap[temp].value && heap[temp/2].index>heap[temp].index ) {
                Node t = heap[temp / 2];
                int p = heap[temp].position;
                heap[temp / 2] = heap[temp];
                heap[temp/2].position=t.position;
                heap[temp] = t;
                heap[temp].position = p;
                temp /= 2;
            }
            else break;
        }
    }

    public  Node deleteMin() {
        while(heap[1].isDeleted) {
            heap[1] = heap[size];
            heap[1].position=1;
            //heap[size].value=0;
            size--;
            //把最后一个节点放到根
            int temp = 1;
            while (size >= temp * 2) {
                if (temp * 2 + 1 <= size) {
                    if (heap[temp * 2].value < heap[temp].value && (heap[temp * 2].value < heap[temp * 2 + 1].value ||(heap[temp * 2].value == heap[temp * 2 + 1].value && heap[temp*2].index<heap[temp*2+1].index))) {
                        Node t = heap[temp * 2];
                        int p = heap[temp].position;
                        heap[temp * 2] = heap[temp];
                        heap[temp*2].position=t.position;
                        heap[temp] = t;
                        heap[temp].position = p;
                        temp *= 2;
                    } else if (heap[temp * 2 + 1].value < heap[temp].value || (heap[temp * 2 + 1].value == heap[temp].value && heap[temp * 2 + 1].index < heap[temp].index)) {
                        Node t = heap[temp * 2 + 1];
                        int p = heap[temp].position;
                        heap[temp * 2 + 1] = heap[temp];
                        heap[temp*2+1].position=t.position;
                        heap[temp] = t;
                        heap[temp].position = p;
                        temp = temp * 2 + 1;
                    }else break;
                } else {
                    if (heap[temp * 2].value < heap[temp].value) {
                        Node t = heap[temp * 2];
                        int p = heap[temp].position;
                        heap[temp * 2] = heap[temp];
                        heap[temp*2].position=t.position;
                        heap[temp] = t;
                        heap[temp].position = p;
                        temp *= 2;
                    } else if(heap[temp * 2].value == heap[temp].value && heap[temp*2].index<heap[temp].index){
                        Node t = heap[temp * 2];
                        int p = heap[temp].position;
                        heap[temp * 2] = heap[temp];
                        heap[temp*2].position=t.position;
                        heap[temp] = t;
                        heap[temp].position = p;
                        temp *= 2;
                    }
                    else break;

                }
            }
        }
        Node q = heap[1];
        temp3=heap[1].pre;
        temp4=heap[1].next;
        while(temp3.isDeleted==true){
            temp3=temp3.pre;
        }
        while(temp4.isDeleted==true){
            temp4=temp4.next;
        }
        temp3.next=temp4;
        temp4.pre=temp3;
        //preindex = heap[1].pre.position;
        //temp3=heap[1].pre;
        //heap[1].next.pre = heap[1].pre;
        heap[1] = heap[size];
        heap[1].position=1;
        //heap[size].value=0;
        size--;
        //把最后一个节点放到根
        int temp = 1;
        while (size >= temp * 2) {
            if (temp * 2 + 1 <= size) {
                if (heap[temp * 2].value < heap[temp].value && (heap[temp * 2].value < heap[temp * 2 + 1].value ||(heap[temp * 2].value == heap[temp * 2 + 1].value && heap[temp*2].index<heap[temp*2+1].index))) {
                    Node t = heap[temp * 2];
                    int p = heap[temp].position;
                    heap[temp * 2] = heap[temp];
                    heap[temp*2].position=t.position;
                    heap[temp] = t;
                    heap[temp].position = p;
                    temp *= 2;
                } else if (heap[temp * 2 + 1].value < heap[temp].value || (heap[temp * 2 + 1].value == heap[temp].value && heap[temp * 2 + 1].index < heap[temp].index)) {
                    Node t = heap[temp * 2 + 1];
                    int p = heap[temp].position;
                    heap[temp * 2 + 1] = heap[temp];
                    heap[temp*2+1].position=t.position;
                    heap[temp] = t;
                    heap[temp].position = p;
                    temp = temp * 2 + 1;
                }else return q;
            } else {
                if (heap[temp * 2].value < heap[temp].value) {
                    Node t = heap[temp * 2];
                    int p = heap[temp].position;
                    heap[temp * 2] = heap[temp];
                    heap[temp*2].position=t.position;
                    heap[temp] = t;
                    heap[temp].position = p;
                    temp *= 2;
                } else if(heap[temp * 2].value == heap[temp].value && heap[temp*2].index<heap[temp].index){
                    Node t = heap[temp * 2];
                    int p = heap[temp].position;
                    heap[temp * 2] = heap[temp];
                    heap[temp * 2].position=t.position;
                    heap[temp] = t;
                    heap[temp].position = p;
                    temp *= 2;
                }
                else return q;
            }
        }
        return q;
    }
    public void delete(int position) {
        heap[position].isDeleted=true;
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
