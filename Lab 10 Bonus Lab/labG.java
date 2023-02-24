//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class labG {
//    public static void main(String[] args) {
//        QReader in  = new QReader();
//        QWriter out = new QWriter();
//        int N = in.nextInt();
//        for (int z = 0; z < N; z++) {
//            int m = in.nextInt();
//            Main.Tree[] trees = new Main.Tree[2 * m + 1];
//            for (int i = 0; i < 2 * m + 1; i++) {
//                trees[i] = new Main.Tree();
//            }
//            int count = 0;
//            for (int i = 0; i < m; i++) {
//                int a = in.nextInt() - 1;
//                int b = in.nextInt() - 1;
//                if (a == -1) {
//                    trees[count].left = null;
//                } else {
//                    trees[count].left = trees[a];
//                    trees[a].father=trees[count];
//                }
//                if (b == -1) {
//                    trees[count].right = null;
//                } else {
//                    trees[count].right = trees[b];
//                    trees[b].father=trees[count];
//                }
//                count++;
//            }
//            Main.Tree[] queue = new Main.Tree[2*m+1];
//            int front = 0, rear = 0,check=0,c=0;
//            Main.Tree temp1 = trees[0];
//            while(temp1.father!=null){
//                temp1=temp1.father;
//            }
//            queue[rear++] = temp1;
//            while (rear != front) {
//                Main.Tree temp = queue[front++];
//                if (check == 0) {
//                    if (temp.left == null) {
//                        if (temp.right != null) {
//                            System.out.println("No");
//                            c++;
//                            break;
//                        } else check++;
//                    } else {
//                        queue[rear++] = temp.left;
//                    }
//                    if (temp.right == null) {
//                        check++;
//                    } else {
//                        queue[rear++] = temp.right;
//                    }
//                }else {
//                    if(temp.left!=null || temp.right!=null){
//                        System.out.println("No");
//                        c++;
//                        break;
//                    }
//                }
//            }
//            if(c==0) {
//                System.out.println("Yes");
//            }
//
//
//        }
//    }
////    boolean isCBT(Tree root){
////        if(root==null) {
////            return true;
////        }
////        boolean check = false;
////        Queue<Tree> queue = new LinkedList();
////        queue.offer(root);
////        while(!queue.isEmpty()){
////            Tree temp = queue.remove();
////            if(check && (temp.left!=null || temp.right!=null))
////        }
////    }
//
//    public static class Tree{
//        boolean isVisited;
//        Main.Tree father=null;
//        Main.Tree left;
//        Main.Tree right;
//        ArrayList<Main.Tree> children = new ArrayList<>();
//    }
//}
//class QReader {
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private StringTokenizer tokenizer = new StringTokenizer("");
//
//    private String innerNextLine() {
//        try {
//            return reader.readLine();
//        } catch (IOException e) {
//            return null;
//        }
//    }
//
//    public boolean hasNext() {
//        while (!tokenizer.hasMoreTokens()) {
//            String nextLine = innerNextLine();
//            if (nextLine == null) {
//                return false;
//            }
//            tokenizer = new StringTokenizer(nextLine);
//        }
//        return true;
//    }
//
//    public String nextLine() {
//        tokenizer = new StringTokenizer("");
//        return innerNextLine();
//    }
//
//    public String next() {
//        hasNext();
//        return tokenizer.nextToken();
//    }
//
//    public int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    public long nextLong() {
//        return Long.parseLong(next());
//    }
//}
//
//class QWriter implements Closeable {
//    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//    public void print(Object object) {
//        try {
//            writer.write(object.toString());
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    public void println(Object object) {
//        try {
//            writer.write(object.toString());
//            writer.write("\n");
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    @Override
//    public void close() {
//        try {
//            writer.close();
//        } catch (IOException e) {
//            return;
//        }
//    }
//}
