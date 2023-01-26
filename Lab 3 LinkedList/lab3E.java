import java.io.*;
import java.util.StringTokenizer;

public class main {
    public static void main(String[] args) {
        QReader in  = new QReader();
        QWriter out = new QWriter();
        int n=in.nextInt();

        node head = new node(-1000000011,-1000000011);
        node tail= new node(1000000005,100000005);
        node current=head;
        for(int i=0 ; i<n ; i++){
            node temp = new node(in.nextInt(),in.nextInt());
            current.next=temp;
            current=current.next;
        }
        current.next=tail;
        current=head;
        int m=in.nextInt();
        for(int i=0 ; i<m ; i++){
            node temp = new node(in.nextInt(),in.nextInt());
            while (true){
                if(temp.exp < current.next.exp)break;

                current=current.next;
            }
            if(current.exp == temp.exp){
                current.coe+=temp.coe;
            }else{
                temp.next=current.next;
                current.next=temp;
            }
        }
        int count=0;
        current=head.next;
        while(current!=tail){
            if(current.coe!=0){
                count++;
            }
            current=current.next;
        }
        out.println(count);
        current=head.next;
        while(current!=tail){
            if(current.coe!=0){
                out.println(current.coe+" "+current.exp);
            }
            current=current.next;
        }
        out.close();
    }
}
class node{
    int coe,exp;
    node next;
    public node(int coe, int exp){
        this.coe=coe;
        this.exp=exp;
    }

}

class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}