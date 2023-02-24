import java.util.ArrayList;
import java.util.Scanner;

public class labH {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int  n = in.nextInt();
        int  m  = in.nextInt();
        int[][] store= new int[n][m];
        Node[] nodes = new Node[n*m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nodes[i+j*m]= new Node(in.nextInt());
                store[n][m]=nodes[i].value;
            }
        }
        for (int i = 0; i <n*m ; i++) {
            if((i+1)/m==0){
                if((i+1)%m==1){
                    nodes[i].children.add(nodes[m-1]);
                    nodes[i].children.add(nodes[i+1]);
                    nodes[i].children.add(nodes[i+m]);
                }else if((i+1)%m==0){
                    nodes[i].children.add(nodes[0]);
                    nodes[i].children.add(nodes[i-1]);
                    nodes[i].children.add(nodes[i+m]);
                }else {
                    nodes[i].children.add(nodes[i-1]);
                    nodes[i].children.add(nodes[i+1]);
                    nodes[i].children.add(nodes[i+m]);
                }
            }else if()
            nodes[i].children.add(nodes[i+1]);
            nodes[i].children.add(nodes[i-1]);
            nodes[i].children.add(nodes[i+m]);
            nodes[i].children.add(nodes[i-m]);
        }

    }
    static class Node{
        int value;
        boolean isVisited=false;
        ArrayList<Node> children;
        public Node(int index) {
            this.children=new ArrayList<>();
            this.value=index;
        }
    }
}
