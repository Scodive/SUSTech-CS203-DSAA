public class lab31B {
    public static void main(String[] args) {
        QReader in  = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        node head = new node(1000000002,1000000002);
        node tail = new node(1000000005,1000000005);
        node head2 = new node(1000000002,1000000002);
        node tail2 = new node(1000000005,1000000005);
        node head3 = new node(1000000001,1000000001);
        node current = head;
        node current2 = head2;
        node current3 = head3;
        int count=0;
        for(int i=0 ; i<n ; i++){
            node temp = new node(in.nextInt(),in.nextInt());
            current.next=temp;
            current=current.next;
        }
        current.next=tail;
        for(int i=0 ;i<m ; i++){
            node temp = new node(in.nextInt(),in.nextInt());
            current2.next=temp;
            current2=current2.next;
        }
        current2.next=tail2;

        current=head.next; current2=head2.next;
        while(current2!=tail2 || current!=tail) {
            if (current2.exp == 1000000005 || current.exp < current2.exp) {
                node temp = new node(current.coe, current.exp);
                current3.next = temp;
                current3 = current3.next;
                current = current.next;
                count++;
                continue;
            }
            if (current.exp == 1000000005 || current.exp > current2.exp) {
                node temp = new node(current2.coe, current2.exp);
                current3.next = temp;
                current3 = current3.next;
                current2 = current2.next;
                count++;
                continue;
            }
            if (current.exp == current2.exp) {
                if (current.coe + current2.coe != 0) {
                    node temp = new node(current.coe + current2.coe, current2.exp);
                    current3.next = temp;
                    current3 = current3.next;
                    current2 = current2.next;
                    current = current.next;
                    count++;
                    continue;
                }
            }
        }
        current3.next=tail;

        current3=head3.next;
        out.println(count);
        while(current3!=tail){
            out.println(current3.coe+" "+current3.exp);
            current3=current3.next;
        }
        out.close();
    }
}
