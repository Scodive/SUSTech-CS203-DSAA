/*public class lab32 {
    public static void main(String[] args) {
        QReader in  = new QReader();
        QWriter out = new QWriter();
        long n=in.nextLong();
        long m=in.nextLong();
        node head = new node(2000000005);
        node current=head;
        for(int i=0 ; i<n ; i++){
            node temp = new node(in.nextLong());
            current.next=temp;
            current=current.next;
        }
        node tail= new node(2000000005);
        node tail2= new node(2000000005);
        current.next=tail;
        tail.next=tail2;
        long ans=0,all=0;
        long count=0,check=0,countall=0;
        while(check==0) {
            current = head.next;
            while (current!=tail && current!=tail2){
                all+=current.money;
                countall++;
                current=current.next;
            }
            while(all!=0 && m/all>=1){
                count=m/all;
                ans+=count*countall;
                m=m%all;
            }
            if(m==0){
                break;
            }
            current=head;
            long a=m;
            while (current != tail2) {
                if ( a < current.next.money && current.next.next!=null) {
                    current.next=current.next.next;
                    //current=current.next;
                }else {
                    a -= current.next.money;
                    current = current.next;
                }
            }
            if(head.next.money>1000000004){
                check=1;
            }else check=0;
            countall=0;
            all=0;
        }
        out.println(ans);
        out.close();
}*/
