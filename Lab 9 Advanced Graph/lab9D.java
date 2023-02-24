import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class lab94 {
    static int[] reverse;
    static int index;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int S = in.nextInt()-1;
        Node[] nodes  = new Node[n];
        Node[] renode = new Node[n];

        long ans = 0;
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
            renode[i] = new Node(i);
        }
        int side[][] = new int[m][2];
        int sidec=0;
        for (int i = 0; i < m; i++) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            side[sidec][0]=a;
            side[sidec++][1]=b;
            nodes[a].children.add(nodes[b]);
            renode[b].children.add(renode[a]);
        }
        Stack<Node> stack = new Stack<Node>();
        index=n-1;
        reverse=new int[n];
        for (int i = 0; i < n; i++) {
            if(renode[i].state==0){
                dfs(i,renode);
            }
        }
        index=0;
        int sccont=1,check=0;
        for (int i = 0; i <n ; i++) {
            check=0;
           if(nodes[reverse[i]].state==0){
               dfs2(reverse[i],nodes,sccont);
               check++;
           }
           if(check!=0){
               sccont++;
           }
        }
        int[] scc = new int[sccont];//每个大点的入度
        for (int i = 0; i < m; i++) {
            if (nodes[side[i][0]].scc != nodes[side[i][1]].scc || side[i][0]==side[i][1]) {
                scc[nodes[side[i][1]].scc]++;
            }
        }
        int k = 0;
        for (int i = 1; i < sccont; i++) {
            if (scc[i] == 0) {
                k++;
            }
        }
        if (scc[nodes[S].scc] == 0) {
            System.out.println(k - 1);
        } else System.out.println(k);
    }
    public static void dfs(int a, Node[] nodes){
        Node temp = nodes[a];
        temp.state=1;
        int children = temp.children.size();
        for (int i = 0; i < children; i++) {
            if(temp.children.get(i).state==0){
                dfs(temp.children.get(i).index,nodes);
            }
        }
        temp.state=2;
        reverse[index--]= temp.index;
    }
    public static void dfs2(int a, Node[] nodes,int cc){
        Node temp = nodes[a];
        temp.state=1;
        int children = temp.children.size();
        for (int i = 0; i < children; i++) {
            if(temp.children.get(i).state==0){
                dfs2(temp.children.get(i).index,nodes,cc);
            }
        }
        temp.state=2;
        temp.scc=cc;
    }
    static class Node{
        int scc;
        int index;
        int state=0;
        boolean isVisited=false;
        ArrayList<Node> children;
        public Node(int index) {
            this.children=new ArrayList<>();
            this.index=index;
        }
    }
}
