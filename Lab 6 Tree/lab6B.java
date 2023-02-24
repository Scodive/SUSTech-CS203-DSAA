//import java.util.ArrayList;
//
//public class lab62 {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//        int n = in.nextInt();
//
//        Main.Tree[] trees = new Main.Tree[n+1];
//        for (int i = 0; i <n ; i++) {
//            trees[i] = new Main.Tree();
//        }
//
//        for(int i=0 ; i<n-1 ;i++){
//            int a = in.nextInt()-1;
//            int b = in.nextInt()-1;
//            trees[a].children.add(trees[b]);
//            trees[b].children.add(trees[a]);
//            trees[a].length.add(1);
//            trees[b].length.add(1);
//        }
//        int m = in.nextInt();
//
//        for (int i = 0; i < m; i++) {
//            int temp = in.nextInt();
//            trees[temp-1].have=true;
//        }
//        int branch = trees[0].children.size();
//        int ans=0;
//        trees[0].isVisited=true;
//        for (int j = 0; j < branch; j++) {
//            int front = 0, rear = 0, count = 2, a = 0;
//            int[] index = new int[1000000];
//            if (trees[0].children.get(j).have) {
//                index[a++] = 1;
//            }
//            Main.Tree[] queue = new Main.Tree[n];
//            trees[0].weight=0;
//            trees[0].children.get(j).isVisited = true;
//            queue[rear++] = trees[0].children.get(j);
//            trees[0].children.get(j).weight=1;
//            while (rear != front) {
//                Main.Tree temp = queue[front++];
//                for (int i = 0; i < temp.children.size(); i++) {
//                    if (temp.children.get(i).isVisited == false) {
//                        temp.children.get(i).weight = temp.weight+temp.length.get(i);
//                        queue[rear++] = temp.children.get(i);
//                        if (temp.children.get(i).have) {
//                            index[a++] = temp.children.get(i).weight;
//                        }
//                        temp.children.get(i).isVisited = true;
//                    }
//                }//换层问题
//                // count++;//第几层
//            }
//            if (a > 0) {
//                if (a == 1) {
//                    if(ans<index[0]) {
//                        ans = index[0];
//                    }
//                } else {
//                    for (int i = 1; i < a; i++) {
//                        if (index[i] <= index[i - 1]) {
//                            index[i] = index[i-1]+1;
//                        }
//                    }
//                    if (ans < index[a - 1]) {
//                        ans = index[a - 1];
//                    }
//                }
//            }
//        }
//        out.println(ans);
//        out.close();
//    }
//    public static class Tree{
//        int weight;
//        boolean have;
//        boolean isVisited;
//        ArrayList<Main.Tree> children = new ArrayList<>();
//        ArrayList<Integer> length = new ArrayList<>();
//    }
//}
