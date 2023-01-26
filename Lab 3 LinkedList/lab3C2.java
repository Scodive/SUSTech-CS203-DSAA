import java.io.*;
import java.util.StringTokenizer;

public class lab33B {
    public static void main(String[] args) {
        QReader in  = new QReader();
        QWriter out = new QWriter();
        long n=in.nextLong();
        long m=in.nextLong();
        int cir=in.nextInt();
        DoubleNode head = new DoubleNode(20001);
        //DoubleNode up = new DoubleNode(20002);
        DoubleNode tail = new DoubleNode(20003);
        //DoubleNode down = new DoubleNode(20004);
        DoubleNode current=head;
        for(int i=0 ; i<m ;i++){
            DoubleNode up = new DoubleNode(20002);
            current.next=up;
            current=current.next;
        }
        current.next=tail;
        current=head;
        for(int i=0 ; i<n+1 ;i++){
            DoubleNode head2 = new DoubleNode(20001);
            current.down=head2;
            current=current.down;
        }
        for(int i=0  ;i<m ; i++){
            DoubleNode down = new DoubleNode(20004);
            current.next=down;
            current=current.next;
        }
        DoubleNode tail2 = new DoubleNode(20003);
        current.next=tail2;
        current=head.down;
        DoubleNode downcurrent=head.down;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ;j++){
                DoubleNode temp = new DoubleNode(in.nextLong());
                current.next=temp;
                current=current.next;
            }DoubleNode tail3 = new DoubleNode(20003);
            current.next=tail3;
            current=downcurrent.down;
            downcurrent=current;
        }
        current=head;
        downcurrent=head.down;
        DoubleNode ch = head;
        for(int i=0 ; i<n+1 ;i++){
            for(int j=0 ; j<m+2 ;j++){
                current.down=downcurrent;
                current=current.next;
                downcurrent=downcurrent.next;
            }if(i!=n+1){
                current=ch.down;
                downcurrent=current.down;
                ch=ch.down;}
        }
        int x1,y1,x2,y2,l1,l2;
        for(int q=0 ; q<cir ; q++){
            x1=in.nextInt(); y1=in.nextInt(); x2=in.nextInt(); y2=in.nextInt();
            l1=in.nextInt(); l2=in.nextInt();
            DoubleNode sqa = head;
            DoubleNode sqb = head;
            DoubleNode sqc = head;
            DoubleNode sqd = head;
            DoubleNode sqe = head;
            DoubleNode sqc2 = new DoubleNode();
            DoubleNode sqf = head;
            DoubleNode sqf2 = new DoubleNode();
            for(int i=0 ; i<y1 ; i++){
                sqa=sqa.next;
                sqc=sqc.next;
                if(i!=y1-1)sqb=sqb.next;
            }
            for(int i=0 ; i<x1 ; i++){
                sqb=sqb.down;
                sqc=sqc.down;
                if(i!=x1-1)sqa=sqa.down;
            }
            for(int i=0 ; i<y2 ; i++){
                sqd=sqd.next;
                sqf=sqf.next;
                if(i!=y2-1)sqe=sqe.next;
            }
            for(int i=0 ; i<x2 ; i++){
                sqe=sqe.down;
                sqf=sqf.down;
                if(i!=x2-1)sqd=sqd.down;
            }
            sqc2=sqc; sqf2=sqf;
            for(int i=0 ; i<l1 ;i++) {
                sqb.next = sqf;
                sqb=sqb.down;
                if(i!=l1-1)sqf=sqf.down;
            }
            for(int i=0 ; i<l2 ; i++){
                sqb=sqb.next;
                //sqf=sqf.next;
                sqf.down=sqb;
                sqf=sqf.next;
                sqd.down=sqc;
                sqd=sqd.next;
                if(i!=l2-1)sqc=sqc.next;
            }
            for(int i=0 ; i<l1 ; i++){
                sqd=sqd.down;
                sqc.next=sqd;
                sqc=sqc.down;
            }

            for(int i=0 ; i<l1 ;i++) {
                sqe.next = sqc2;
                sqe=sqe.down;
                if(i!=l1-1)sqc2=sqc2.down;
            }
            for(int i=0 ; i<l2 ; i++){
                sqe=sqe.next;
                //sqf=sqf.next;
                sqc2.down=sqe;
                sqc2=sqc2.next;
                sqa.down=sqf2;
                sqa=sqa.next;
                if(i!=l2-1)sqf2=sqf2.next;
            }
            for(int i=0 ; i<l1 ; i++){
                sqa=sqa.down;
                sqf2.next=sqa;
                sqf2=sqf2.down;
            }
        }
        current=head.down;
        downcurrent=head.down;
        for(int j=0 ; j<n ;j++) {
            for (int i = 0; i < m; i++) {
                current = current.next;
                if(i!=m) {
                    out.print(current.data + " ");
                }else out.print(current.data);
            }
            out.println("");
            current = downcurrent.down;
            downcurrent = current;
        }
        out.close();
    }
}
class DoubleNode{
    long data;
    DoubleNode down;
    DoubleNode next;
    public DoubleNode(){}
    public DoubleNode(long data) {
        this.data = data;
    }
    public DoubleNode(DoubleNode down , int data ,DoubleNode next){
        this.down=down;
        this.data=data;
        this.next=next;
    }

}
