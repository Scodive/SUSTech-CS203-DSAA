public class lab33 {
    public static void main(String[] args) {
        QReader in  = new QReader();
        QWriter out = new QWriter();
        long n=in.nextLong();
        long m=in.nextLong();
        int cir=in.nextInt();
        DoubleNode head = new DoubleNode(20001);

        DoubleNode current=head;
        DoubleNode downcurrent=head;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                DoubleNode temp = new DoubleNode(in.nextLong());
                current.next=temp;
                current=current.next;
            }
            DoubleNode tail = new DoubleNode(20002);
            current.next=tail;
            //DoubleNode temp = new DoubleNode(in.nextLong());
            current=downcurrent;
            DoubleNode head2 = new DoubleNode(20003);
            current.down=head2;
            current=current.down;
            downcurrent=current;
        }
        /*current=head;//连下
        downcurrent=head.down;
        DoubleNode ch =head.down;
        for(int i=0 ;i<n-1 ; i++){
            for(int j=0 ;j<m-1 ;j++){
                current.down=downcurrent;
                current=current.next;
                downcurrent=downcurrent.next;
            }
            current=ch;
            downcurrent=ch.down;
            ch=ch.down;
        }*/
        int x1,y1,x2,y2,l1,l2;
        for(int q=0 ; q<cir ; q++){
            x1=in.nextInt(); y1=in.nextInt(); x2=in.nextInt(); y2=in.nextInt();
            l1=in.nextInt(); l2=in.nextInt();
            DoubleNode tempcurrent =new DoubleNode();
            DoubleNode tempfront = new DoubleNode();
            DoubleNode templast = new DoubleNode();
            DoubleNode templast2 =new DoubleNode();

            for(int w=0 ; w<l1 ; w++) {
                current=head;
                downcurrent=head;
                if(x1-1+w!=0){
                    for(int i=0 ;i <x1-1+w ;i++) {
                        current=current.down;
                    }
                }
                if(y1-1!=0){
                    for(int i=0 ;i <y1-1 ;i++) {
                        current=current.next;
                    }
                }

                tempcurrent=current;

                if(x2-1+w!=0){
                    for(int i=0 ;i <x2-1+w ;i++) {
                        downcurrent=downcurrent.down;
                    }
                }
                if(y2-1!=0){
                    for(int i=0 ;i <y2-1 ;i++) {
                        downcurrent=downcurrent.next;
                    }
                }
                DoubleNode tempcurrent2 = new DoubleNode();
                tempcurrent2 = downcurrent;


                for (int i = 0; i < l2; i++) {
                    tempcurrent2 = tempcurrent2.next;
                }
                templast2 = tempcurrent2.next;
                tempfront.next = current.next;
                for (int i = 0; i < l2; i++) {
                    current = current.next;
                }
                templast.next = current.next;
                current.next = templast;
                tempcurrent.next = downcurrent.next;
                for (int i = 0; i < l2; i++) {
                    tempcurrent = tempcurrent.next;
                }
                tempcurrent.next = templast.next;
                downcurrent.next = tempfront.next;
                for (int i = 0; i < l2; i++) {
                    downcurrent = downcurrent.next;
                }
                downcurrent.next = templast2;
            }
        }

        current=head;
        downcurrent=head;
        for(int j=0 ; j<n ;j++) {
            for (int i = 0; i < m; i++) {
                current = current.next;
                if(i!=m) {
                    out.print(current.data + " ");
                }
            }
            out.println("");
            current = downcurrent.down;
            downcurrent = current;
        }
        out.close();
    }
}
