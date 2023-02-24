//import java.io.*;
//import java.util.StringTokenizer;
//
//public class labC {
//    public static void main(String[] args) {
//        QReader in  = new QReader();
//        QWriter out = new QWriter();
//        int N= in.nextInt();
//        for (int z = 0; z < N; z++) {
//            int n = in.nextInt();
//            node head = new node(Long.MAX_VALUE, Long.MAX_VALUE);
//            node current = head;
//            node tail = new node(Long.MAX_VALUE, Long.MAX_VALUE);
//            current.next = tail;
//
//            for (int i = 0; i < n ; i++) {
//                current=head;
//                node temp = new node(in.nextLong(), in.nextLong());
//                while (true){
//                    if(temp.exp < current.next.exp)break;
//
//                    current=current.next;
//                }
//                if(current.exp == temp.exp){
//                    current.coe+=temp.coe;
//                }else{
//                    temp.next=current.next;
//                    current.next=temp;
//                }
//            }
//
//            int m = in.nextInt();
//
//            for (int i = 0; i < m; i++) {
//                current=head;
//                node temp = new node(in.nextLong(), in.nextLong());
//                while (true){
//                    if(temp.exp < current.next.exp)break;
//
//                    current=current.next;
//                }
//                if(current.exp == temp.exp){
//                    current.coe+=temp.coe;
//                }else{
//                    temp.next=current.next;
//                    current.next=temp;
//                }
//            }
//
//            //out.println(count);
//            current = head.next;
//            int check=0,zero=0,total=0;
//            while (current != tail) {
//                total++;
//                if (check==0) {
//                    if (current.coe != 0) {
//                        if (current.coe == 1) {
//                            if (current.exp == 0) {
//                                out.print("1");
//                                check++;
//                            } else if (current.exp == 1) {
//                                out.print("x");
//                                check++;
//                            } else {
//                                out.print("x^" + current.exp);
//                                check++;
//                            }
//                        }else if(current.coe==-1){
//                            if (current.exp == 0) {
//                                out.print("-1");
//                                check++;
//                            } else if (current.exp == 1) {
//                                out.print("-x");
//                                check++;
//                            } else {
//                                out.print("-x^" + current.exp);
//                                check++;
//                            }
//                        }
//                        else if (current.exp == 0) {
//                            out.print(current.coe);
//                            check++;
//                        } else if (current.exp == 1) {
//                            out.print(current.coe + "x");
//                            check++;
//                        } else {
//                            out.print(current.coe + "x^" + current.exp);
//                            check++;
//                        }
//                    }else {zero++;}
//                    current = current.next;
//
//                } else if(current.coe<0) {
//                    if (current.coe == -1) {
//                        if (current.exp == 0) {
//                            out.print("-1");
//                        } else if (current.exp == 1) {
//                            out.print("-x");
//                        } else out.print("-x^" + current.exp);
//                    } else if (current.coe != 0) {
//                        if (current.exp == 0) {
//                            out.print(current.coe);
//                        } else if (current.exp == 1) {
//                            out.print(current.coe + "x" );
//                        } else out.print(current.coe + "x^" + current.exp);
//                    }
//                    current = current.next;
//                } else  {
//                    if (current.coe != 0) {
//                        if (current.coe == 1) {
//                            if (current.exp == 0) {
//                                out.print("+1");
//                            } else if (current.exp == 1) {
//                                out.print("+x");
//                            } else out.print("+x^" + current.exp);
//                        } else if (current.exp == 0) {
//                            out.print("+"+current.coe  );
//                        } else if (current.exp == 1) {
//                            out.print("+"+current.coe + "x" );
//                        } else out.print("+"+current.coe + "x^" + current.exp);
//                    }else {zero++;}
//                    current = current.next;
//                }
//            }
//            if(zero==total){
//                out.print("0");
//            }
//            if(z!=N-1) {
//                out.println("");
//            }
//
//        }
//        out.close();
//
//    }
//}
//class node{
//    long coe,exp;
//    node next;
//    public node(long coe, long exp){
//        this.coe=coe;
//        this.exp=exp;
//    }
//
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
//
//
