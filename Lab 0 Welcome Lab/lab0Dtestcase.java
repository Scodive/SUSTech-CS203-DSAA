import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class testMah {
    public static void main(String[] args) {
        Random R=new Random();
        int T=10000;
        System.out.println(T);

        for (int i = 0; i < T; i++) {
            ArrayList<String> a=new ArrayList<>();
            int cnt=0;
            char qt=trans(R.nextInt(4)+1);
            int qtn;
            if(qt=='z')
                qtn=R.nextInt(7)+1;
            else qtn=R.nextInt(9)+1;
            a.add(""+qtn+qt);
            a.add(""+qtn+qt);
            //System.out.print(""+qt+qtn+qt+qtn);
            for (int j = 0; j < 4; j++) {
                qt=trans(R.nextInt(4)+1);

                if(qt=='z') {
                    qtn = R.nextInt(7) + 1;
                    a.add(""+qtn+qt);
                    a.add(""+qtn+qt);
                    a.add(""+qtn+qt);
                    //System.out.print(""+qt+qtn+qt+qtn+qt+qtn);
                }else{
                    qtn=R.nextInt(9)+1;
                    if(R.nextInt(2)%2==1){//shunzi
                        if(qtn<=7){
                            a.add(""+qtn+qt);
                            a.add(""+(qtn+1)+qt);
                            a.add(""+(qtn+2)+qt);
                            //System.out.print(""+qt+qtn+qt+(qtn+1)+qt+(qtn+2));
                        }else if (qtn==8){
                            a.add(""+qtn+qt);
                            a.add(""+(qtn-1)+qt);
                            a.add(""+(qtn+1)+qt);
                            //System.out.print(""+qt+qtn+qt+(qtn+1)+qt+(qtn-1));
                        }else{
                            a.add(""+qtn+qt);
                            a.add(""+(qtn-1)+qt);
                            a.add(""+(qtn-2)+qt);
                            //System.out.print(""+qt+qtn+qt+(qtn-2)+qt+(qtn-1));
                        }
                    }else{//kezi
                        a.add(""+qtn+qt);
                        a.add(""+qtn+qt);
                        a.add(""+qtn+qt);
                        //System.out.print(""+qt+qtn+qt+qtn+qt+qtn);
                    }
                }
            }
            Collections.shuffle(a);
            for (int j = 0; j < 14; j++) {
                System.out.print(a.get(j));

            }
            System.out.println();

        }
    }

    static char trans(int a){
        if(a==1){
            return 'z';
        }else if(a==2){
            return 's';
        }else if(a==3){
            return 'w';
        }else{
            return 'b';
        }
    }


}
