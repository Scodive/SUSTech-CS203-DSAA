import java.io.*;
import java.util.StringTokenizer;

/*public class lab31 {
    public static void main(String[] args) {
        QReader in  = new QReader();
        QWriter out = new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        node head = new node(in.nextInt(),in.nextInt());
        node current=head;
        for(int i=0 ; i<n-1 ; i++){
            node temp = new node(in.nextInt(),in.nextInt());
            current.next=temp;
            current=current.next;
        }
        node tail= new node(1000000005,100000005);
        current.next=tail;
        int count=0;
        current=head;
        for(int i=0 ; i<m ; i++){
            node temp = new node(in.nextInt(),in.nextInt());
            int c=0;
            if(temp.exp < head.exp){
                node temp2 = head;
                head = temp;
                head.next=temp2;
                c++;
            }
            current=head;
            while (true&&c==0){
                if(temp.exp < current.next.exp)break;
                current=current.next;
                if(current.coe!=0){
                    count++;
                }
            }
            if(current.exp == temp.exp){
                current.coe+=temp.coe;
            }else{
                temp.next=current.next;
                current.next=temp;
            }
        }

        out.println(count);
        current=head;
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
*/