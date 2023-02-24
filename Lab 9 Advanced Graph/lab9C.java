//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class lab93 {public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    int n = in.nextInt();
//    int m = in.nextInt();
//    int k = in.nextInt();
//    int c = in.nextInt();
//    Main.Node[] nodes = new Main.Node[n + 1];
//    for (int i = 0; i < n; i++) {
//        int am = in.nextInt();
//        nodes[i] = new Main.Node(am, k);
//    }
//    for (int i = 0; i < m; i++) {
//        int a = in.nextInt() - 1;
//        int b = in.nextInt() - 1;
//        nodes[a].children.add(nodes[b]);
//        nodes[b].children.add(nodes[a]);
//    }
//    for (int i = 1; i <= k; i++) {
//        Main.Node[] queue = new Main.Node[n];
//        int front = 0, rear = 0;
//        for (int j = 0; j < n; j++) {
//            if (nodes[j].color == i) {
//                queue[front++] = nodes[j];
//                nodes[j].waystep++;
//                nodes[j].way[nodes[j].waystep] = 0;
//                nodes[j].state = 1;
//            }
//        }
//        while (rear != front) {
//            Main.Node temp = queue[rear++];
//            int size = temp.children.size();
//            for (int j = 0; j < size; j++) {
//                if (temp.children.get(j).state == 0 && temp.children.get(j).statestep==i) {
//                    temp.children.get(j).waystep++;
//                    temp.children.get(j).way[temp.children.get(j).waystep] = temp.way[temp.waystep] + 1;
//                    queue[front++] = temp.children.get(j);
//                    temp.children.get(j).state = 1;
//                }
//            }
//            temp.state = 0;
//            temp.statestep++;
//        }
//
//    }
//    for (int i = 0; i < n; i++) {
//        int ans =0;
//        Arrays.sort(nodes[i].way);
//        for (int j = 0; j < c; j++) {
//            ans+=nodes[i].way[j];
//        }
//        System.out.print(ans+" ");
//    }
//
//
//}
//    static class Node{
//        long value;
//        int color;
//        int statestep=1;
//        int state=0;//0白色 1黄色 2红色
//        int[] way;
//        int waystep=-1;
//        boolean isVisited=false;
//        ArrayList<Main.Node> children;
//        //ArrayList<Long> LengthList ;
//
//
//        public Node(int color,int k) {
//            this.value=Long.MAX_VALUE;
//            this.color=color;
//            this.way=new int[k];
//            this.children =new ArrayList<>();
//            //this.LengthList = new ArrayList<>();
//        }
//    }
//}
