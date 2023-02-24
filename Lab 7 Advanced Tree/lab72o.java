//public class lab72o {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//        int n = in.nextInt();
//        for(int x=0 ; x<n ; x++) {
//            int m = in.nextInt();
//            heap heap = new heap(m);
//            for (int i = 0; i < m; i++) {
//                int temp = in.nextInt();
//                heap.insert(temp);
//            }
//            long ans = 0;
//            for (int i = 0; i < m - 1; i++) {
//                long q = heap.delete();
//                long w = heap.delete();
//                ans = ans + q + w;
//                heap.insert(q + w);
//            }
//            out.println(ans);
//        }
//        out.close();
//    }
//}
