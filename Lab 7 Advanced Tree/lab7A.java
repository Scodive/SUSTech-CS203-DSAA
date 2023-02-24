import java.util.Arrays;
import java.util.Scanner;

public class lab71 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        long[] a = new long[n];
        long[] b = new long[m];
        long[] res = new long[k];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextLong();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Heap heap = new Heap(n + k);
        for (int i = 0; i < n; i++) {
            heap.insert(new Node(a[i], b[0] * a[i], 0));
        }
        int count = 0;
        while (count < k) {
            Node temp = heap.getTop();
            res[count] = heap.deleteMin();
            if (++temp.index < m)
                heap.insert(new Node(temp.pre, temp.pre * b[temp.index], temp.index));
            count++;
        }

        for (long e : res)
            System.out.print(e + " ");
    }

    static class Node {
        long val;
        int index;
        long pre;

        public Node(long pre, long val, int index) {
            this.pre = pre;
            this.index = index;
            this.val = val;
        }
    }

    static class Heap {
        Node[] tree;
        int index;

        Heap(int n) {
            this.tree = new Node[n + 1];
            this.index = 1;
        }

        public void insert(Node a) {
            this.tree[index] = a;
            int d = index;
            while (d != 1 && tree[d / 2].val > tree[d].val) {
                Node tem = tree[d / 2];
                tree[d / 2] = tree[d];
                tree[d] = tem;
                d /= 2;
            }
            index++;
        }

        public long deleteMin() {
            long res = tree[1].val;
            tree[1] = tree[index - 1];
            index--;
            int d = 1;
            while (d < index && ((2 * d < index && tree[2 * d].val < tree[d].val) || (2 * d + 1 < index &&
                    tree[2 * d + 1].val < tree[d].val))) {
                Node t;
                if (tree[2 * d].val < tree[2 * d + 1].val) {
                    t = tree[2 * d];
                    tree[2 * d] = tree[d];
                    tree[d] = t;
                    d *= 2;
                } else {
                    t = tree[2 * d + 1];
                    tree[2 * d + 1] = tree[d];
                    tree[d] = t;
                    d = 2 * d + 1;
                }

            }
            return res;
        }

        public Node getTop() {
            return tree[1];
        }
    }
}
