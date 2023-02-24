//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class lab91 { public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    int n = in.nextInt();
//    int m = in.nextInt();
//    Main.Node[] nodes = new Main.Node[n+1];
//    for (int i = 0; i <n ; i++) {
//        nodes[i] = new Main.Node();
//    }
//    for(int i=0 ; i<m ;i++){
//        int a = in.nextInt()-1;
//        int b = in.nextInt()-1;
//        long c = in.nextLong();
//        nodes[a].children.add(nodes[b]);
//        nodes[a].LengthList.add(c);
//    }
//    Main.heap heap = new Main.heap(n);
//    nodes[0].value=0;
//    heap.insert(nodes[0]);
//    Main.Node min;
//    while(heap.size!=0){
//        min = heap.delete();
//        if(min.isVisited){
//            continue;
//        }
//        min.isVisited=true;
//        int child = min.children.size();
//        for (int i = 0; i < child; i++) {
//            Main.Node temp = min.children.get(i);
//            if(!temp.isVisited){
//                if(temp.value>min.LengthList.get(i)+min.value){
//                    temp.value=min.LengthList.get(i)+min.value;
//                }
//                heap.insert(temp);
//            }
//        }
//    }
//    if(nodes[n-1].value==Long.MAX_VALUE){
//        System.out.println("-1");
//    }else System.out.println(nodes[n-1].value);
//}
//    static class Node{
//        long value;
//        boolean isVisited=false;
//        ArrayList<Main.Node> children;
//        ArrayList<Long> LengthList ;
//
//
//        public Node() {
//            this.value=Long.MAX_VALUE;
//            this.children=new ArrayList<>();
//            this.LengthList = new ArrayList<>();
//        }
//    }
//    static class heap {
//        Main.Node[] heap;
//        int size = 0;
//        public heap(int n) {
//            heap = new Main.Node[n + 1];
//        }
//
//        public void insert(Main.Node x) {
//            size++;//放到最后
//            heap[size] = x;
//            int temp = size;
//            while (temp > 1) {//交换
//                if (heap[temp / 2].value > heap[temp].value) {
//                    Main.Node t = heap[temp / 2];
//                    heap[temp / 2] = heap[temp];
//                    heap[temp] = t;
//                    temp /=2;
//                } else break;
//            }
//        }
//
//        public Main.Node delete() {
//            Main.Node q = heap[1];
//            heap[1] = heap[size];
//            //heap[size].value=0;
//            size--;
//            //把最后一个节点放到根
//            int temp = 1;
//            while (size >= temp*2) {
//                if (temp * 2 + 1 <= size) {
//                    if (heap[temp * 2].value < heap[temp].value && heap[temp * 2].value<heap[temp *2 +1].value){
//                        Main.Node t = heap[temp * 2];
//                        heap[temp * 2] = heap[temp];
//                        heap[temp] = t;
//                        temp*=2;
//                    } else if (heap[temp * 2 + 1].value < heap[temp].value) {
//                        Main.Node t = heap[temp * 2 + 1];
//                        heap[temp * 2 + 1] = heap[temp];
//                        heap[temp] = t;
//                        temp=temp*2+1;
//                    } else return q;
//                } else {
//                    if (heap[temp * 2].value < heap[temp].value) {
//                        Main.Node t = heap[temp * 2];
//                        heap[temp * 2] = heap[temp];
//                        heap[temp] = t;
//                        temp*=2;
//                    }else return q;
//                }
//            }
//            return q;
//        }
//    }
//}
//
