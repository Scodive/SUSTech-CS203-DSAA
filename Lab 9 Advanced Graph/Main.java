import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int S = in.nextInt()-1;
        Node[] nodes  = new Node[n];
        Node[] renode = new Node[n];
        int[] reverse = new int[n];
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
        stack.push(renode[0]);
        renode[0].state=1;
        int count=1,num=1,revcon=0;
        while(!stack.isEmpty() || count!=n) {
            if(stack.isEmpty()){
                while(renode[num].isVisited){
                    num++;
                }
                stack.push(renode[num]);
                renode[num].isVisited=true;
                count++;
            }
            Node temp = stack.peek();
            //stack.pop();
            int stay=count;

            int child = temp.children.size();
            for (int i = 0; i < child; i++) {
                if(!temp.children.get(i).isVisited){
                    stack.push(temp.children.get(i));
                    count++;
                    temp.children.get(i).isVisited=true;
                }
            }
            if(stay==count){
                stack.pop();
                reverse[revcon++]=temp.index;
            }
        }
        int sccont=1,check=1;
        stack.push(nodes[reverse[--count]]);
        if(count==0){
            System.out.println("0");
        }else {
            nodes[reverse[count--]].isVisited = true;
            while (!stack.isEmpty() || check == 1) {
                if (stack.isEmpty()) {
                    sccont++;
                    while (nodes[reverse[count]].isVisited) {
                        count--;
                        if (count < 0) {
                            check = 0;
                            break;
                        }
                    }
                    if (check == 0) break;
                    stack.push(nodes[reverse[count]]);
                    nodes[reverse[count]].isVisited = true;
                }

                Node temp = stack.peek();
                int ceo=0;
                int child = temp.children.size();
                for (int i = 0; i < child; i++) {
                    if (!temp.children.get(i).isVisited) {
                        ceo++;
                        stack.push(temp.children.get(i));
                        temp.children.get(i).isVisited = true;
                    }
                }
                if(ceo==0){
                    temp.scc = sccont;
                    stack.pop();
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

