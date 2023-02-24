import java.util.ArrayList;
import java.util.Scanner;

public class labJ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Node[] nodes = new Node[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        Side[] sides = new Side[m];
        long minc = Long.MAX_VALUE;
        long sum=0;
        int mini = 0;
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            long c = in.nextLong();
            if (c < minc) {
                minc = c;
                mini = i;
            }
            sum+=c;
            nodes[a].children.add(nodes[b]);
            nodes[b].children.add(nodes[a]);
            sides[i] = new Side(a, b, c);
            nodes[a].LengthList.add(sides[i]);
            nodes[b].LengthList.add(sides[i]);
        }

        heap heap = new heap(m);
        //nodes[0].value=0;
        heap.insert(sides[mini]);
        sides[mini].state = 1;
        Side min;
        while (heap.size != 0) {
            min = heap.delete();
            if(nodes[min.point1].isVisited && nodes[min.point2].isVisited){
                continue;
            }
            min.state = 2;
            nodes[min.point1].isVisited = true;
            nodes[min.point2].isVisited = true;

            int child = nodes[min.point1].children.size();
            for (int i = 0; i < child; i++) {
                Side temp = nodes[min.point1].LengthList.get(i);
                if (temp.state == 0) {
                    heap.insert(temp);
                    temp.state = 1;
                }
            }
            child = nodes[min.point2].children.size();
            for (int i = 0; i < child; i++) {
                Side temp = nodes[min.point2].LengthList.get(i);
                if (temp.state == 0) {
                    heap.insert(temp);
                    temp.state = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if((sides[i].state==0 || sides[i].state==1) && sides[i].value>0){
                ans+=sides[i].value;
            }
        }
        System.out.println(sum-ans);


    }
    static class Node{
        //long value;
        boolean isVisited=false;
        //boolean isDeleted=false;
        ArrayList<Node> children;
        ArrayList<Side> LengthList ;


        public Node() {
            // this.value=Long.MAX_VALUE;
            this.children=new ArrayList<>();
            this.LengthList = new ArrayList<>();
        }
    }
    static class Side{
        long value;
        int point1;
        int point2;
        int state=0;
        public Side(int point1,int point2,long value){
            this.value=value;
            this.point1=point1;
            this.point2=point2;
        }
    }
    static class heap {
        Side[] heap;
        int size = 0;
        public heap(int n) {
            heap = new Side[n + 1];
        }

        public void insert(Side x) {
            size++;//放到最后
            heap[size] = x;
            int temp = size;
            while (temp > 1) {//交换
                if (heap[temp / 2].value > heap[temp].value) {
                    Side t = heap[temp / 2];
                    heap[temp / 2] = heap[temp];
                    heap[temp] = t;
                    temp /=2;
                } else break;
            }
        }

        public Side delete() {
            Side q = heap[1];
            heap[1] = heap[size];
            //heap[size].value=0;
            size--;
            //把最后一个节点放到根
            int temp = 1;
            while (size >= temp*2) {
                if (temp * 2 + 1 <= size) {
                    if (heap[temp * 2].value < heap[temp].value && heap[temp * 2].value<heap[temp *2 +1].value){
                        Side t = heap[temp * 2];
                        heap[temp * 2] = heap[temp];
                        heap[temp] = t;
                        temp*=2;
                    } else if (heap[temp * 2 + 1].value < heap[temp].value) {
                        Side t = heap[temp * 2 + 1];
                        heap[temp * 2 + 1] = heap[temp];
                        heap[temp] = t;
                        temp=temp*2+1;
                    } else return q;
                } else {
                    if (heap[temp * 2].value < heap[temp].value) {
                        Side t = heap[temp * 2];
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


