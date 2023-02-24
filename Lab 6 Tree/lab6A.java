//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class lab61 {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//        int n = in.nextInt();
//        int m = in.nextInt();
//        Tree[] trees = new Tree[n+1];
//        for (int i = 0; i <n ; i++) {
//           trees[i] = new Tree();
//        }
//        for(int i=0 ; i<n-1 ;i++){
//            int a = in.nextInt()-1;
//            int b = in.nextInt()-1;
//            int c = in.nextInt();
//            trees[a].children.add(trees[b]);
//            trees[b].children.add(trees[a]);
//            trees[a].length.add(c);
//            trees[b].length.add(c);
//        }
//        Tree[] queue = new Tree[n];
//        int front=0,rear=0,count=0;
//        queue[rear++]=trees[0];
//        trees[0].isVisited=true;
//        trees[0].weight=0;
//        while(rear != front){
//            Tree temp = queue[front++];
//            for (int i = 0; i < temp.children.size(); i++) {
//                if(!temp.children.get(i).isVisited){
//                    temp.children.get(i).weight = temp.weight+temp.length.get(i);
//                    if(temp.children.get(i).weight==m && temp.children.get(i).children.size()==1) {
//                        count++;
//                    }
//                        queue[rear++] = temp.children.get(i);
//                        temp.children.get(i).isVisited = true;
//
//                }
//            }
//        }
//        out.println(count);
//        out.close();
//    }
//    public static class Tree{
//        int weight;
//        boolean isVisited;
//        ArrayList<Tree> children = new ArrayList<>();
//        ArrayList<Integer> length = new ArrayList<>();
//
//    }
//}
