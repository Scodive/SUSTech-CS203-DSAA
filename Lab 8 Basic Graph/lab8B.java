import java.util.ArrayList;

//import java.util.Scanner;
//
//public class lab82 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        Main.Tree[] trees = new Main.Tree[n + 1];
//        for (int i = 0; i < n+1; i++) {
//            trees[i] = new Main.Tree();
//            trees[i].value=i;
//        }
//
//        for (int i = 0; i < m; i++) {
//            int a = in.nextInt();
//            int b = in.nextInt();
//
//            trees[b].children.add(trees[a]);
//        }
//
//
//        //trees[0].weight = 0;
//        for (int j = n; j > 0 ; j--) {
//            if (!trees[j].isVisited) {
//                Main.Tree[] queue = new Main.Tree[j];
//                int front = 0, rear = 0, count = 0;
//                queue[rear++] = trees[j];
//                trees[j].isVisited = true;
//                while (rear != front) {
//                    Main.Tree temp = queue[front++];
//                    for (int i = 0; i < temp.children.size(); i++) {
//                        if (!temp.children.get(i).isVisited) {
//                            //temp.children.get(i).weight = temp.weight + temp.length.get(i);
//                            if (temp.value > temp.children.get(i).value) {
//                                temp.children.get(i).value = temp.value;
//                                temp.children.get(i).isVisited = true;
//                            }
//                            queue[rear++] = temp.children.get(i);
//                            //temp.children.get(i).isVisited = true;
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = 1; i <= n; i++) {
//            System.out.print(trees[i].value+" ");
//        }}
//}
//public static class Tree{
//    int weight;
//    int value;
//    boolean isVisited;
//    ArrayList<Main.Tree> children = new ArrayList<>();
//    //ArrayList<Integer> length = new ArrayList<>();
//}
