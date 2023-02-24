import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        long ans=0;
        Tree[] trees = new Tree[n+1];
        for (int i = 0; i <n+1 ; i++) {
            trees[i] = new Tree();
        }
        for(int i=0 ; i<n-1 ;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            trees[a].children.add(trees[b]);
            trees[b].children.add(trees[a]);
            trees[a].length.add(1);
            trees[b].length.add(1);
        }
        long max=0;
        int index0=0;
        for (int i = 1; i <= n; i++) {
            long m = in.nextLong();
            if(m>=max){//pimax
                max=m;
                index0=i;
            }
            trees[i].pi=m;
        }

        //int branch = trees[index0].children.size();

        Tree[] queue = new Tree[n];
        Tree[] node  = new Tree[n];
        int qfront=0,qrear=0,nfront=0,nrear=0;
        queue[qrear++]=trees[index0];
        trees[index0].isVisited=true;
        //trees[0].isVisited=true;
        trees[index0].weight=0;
        if(trees[index0].children.size()>=2){
            node[nrear++]=trees[index0];
        }
//        if(trees[index0].children.size()==1 && n!=2){
//            ans+=max;
//        }
        while(qrear != qfront){
            Tree temp = queue[qfront++];
            for (int i = 0; i < temp.children.size(); i++) {
                if(!temp.children.get(i).isVisited){
                    temp.children.get(i).weight = temp.weight+temp.length.get(i);

                    if(temp.children.get(i).children.size()==1){
                        temp.ei= temp.pi;
                    }
                    if(temp.children.get(i).children.size()>=2){
                        node[nrear++]=temp.children.get(i);
                    }
                    queue[qrear++] = temp.children.get(i);
                    temp.children.get(i).isVisited = true;
                }
            }
        }
        nfront=nrear-1;
        long maxp=0;
        while(nfront>=1){
            Tree temp = node[nfront--];
            maxp=0;
            if(temp.children.size()>2 ){
                for(int i=0 ; i<temp.children.size(); i++) {
                    if (temp.children.get(i).pi > maxp && temp.children.get(i).weight > temp.weight) {
                        maxp = temp.children.get(i).pi;
                    }
                }
                    if (temp.pi>maxp ) {
                        maxp = temp.pi;
                    }

//                if(nfront==-1) {
//                    Arrays.sort(max2);
//                    int c1=0,c2=0;
//                    for (int j = 0; j < temp.children.size(); j++) {
//                        if(c1==0 && temp.children.get(j).pi==max2[max2.length-1]){
//                            c1++;
//                            temp.children.get(j).pi=max;
//                        }
//                        if(c2==0 && temp.children.get(j).pi==max2[max2.length-2]){
//                            c2++;
//                            temp.children.get(j).pi=max;
//                        }
//                    }
//                 }
            }if(temp.children.size()==2 ){
                if(temp.children.get(0).weight>temp.children.get(1).weight){
                    if(temp.children.get(0).pi>temp.pi){
                        temp.pi=temp.children.get(0).pi;
                    }
                }else {
                    if(temp.children.get(1).pi>temp.pi) {
                        temp.pi=temp.children.get(1).pi;
                    }
                }
            }
//            if(temp.children.size()==2 && nfront==-1){
//                if(temp.children.get(1).pi>temp.children.get(0).pi){
//                    temp.children.get(0).pi=temp.children.get(1).pi;
//
//                }else temp.children.get(1).pi=temp.children.get(0).pi;
//            }
            if(temp.pi<maxp ) {
                temp.pi = maxp;
            }
        }
        int dex1=0,arear=0,count=0,ccount=0;
        nfront=0;
        long ans2[]=new long[20000005];
        while(nfront<nrear){
            Tree temp = node[nfront++];
            dex1=0;maxp=0;
            temp.back=true;
            if(nfront==1 && temp.children.size()>=2){
                int dex2=0;
                long maxp2=0;
                for (int i = 0; i < temp.children.size(); i++) {
                    if (temp.children.get(i).pi > maxp && temp.children.get(i).back==false) {
                        maxp2=maxp;
                        dex2=dex1;
                        maxp = temp.children.get(i).pi;
                        dex1 = i;
                        temp.children.get(i).back=true;
                    }else {
                        if(temp.children.get(i).pi>maxp2 && temp.children.get(i).back==false){
                            maxp2 = temp.children.get(i).pi;
                            dex2 = i;
                            temp.children.get(i).back=true;
                        }
                    }temp.children.get(i).back=true;
                }
                if(temp.pi>temp.children.get(dex1).pi) {
                    temp.children.get(dex1).pi = temp.pi;
                    temp.children.get(dex1).ei = temp.pi;
                }
                if(temp.pi>temp.children.get(dex2).pi) {
                    temp.children.get(dex2).pi = temp.pi;
                    temp.children.get(dex2).ei = temp.pi;
                }
            }
            dex1=0;maxp=0;
            if(temp.children.size()>=2 && nfront!=1) {
                for (int i = 0; i < temp.children.size(); i++) {
                    if (temp.children.get(i).pi > maxp && temp.children.get(i).back==false) {
                        maxp = temp.children.get(i).pi;
                        dex1 = i;
                        temp.children.get(i).back=true;
                    }temp.children.get(i).back=true;
                }
                if(temp.pi>temp.children.get(dex1).pi) {
                    temp.children.get(dex1).pi = temp.pi;
                    temp.children.get(dex1).ei = temp.pi;
                }
            }
            for (int i = 0; i < temp.children.size(); i++) {
                if(temp.children.get(i).children.size()==1 && temp.children.get(i).weight>temp.weight){
                    if(temp.children.get(i).ei==0 && temp.children.get(i).weight>temp.weight){
                        ans2[arear++]=temp.children.get(i).pi;
                        if(temp.children.get(i).pi>=max){
                            ccount++;
                        }
                        ans+=temp.children.get(i).pi;
                        count++;
                    }
                    if(temp.children.get(i).ei!=0 && temp.children.get(i).weight>temp.weight) {
                        ans2[arear++]=temp.children.get(i).ei;
                        if(temp.children.get(i).ei>=max){
                            ccount++;
                        }
                        ans += temp.children.get(i).ei;
                        count++;
                    }
                }
            }
        }
        if(trees[index0].children.size()==1 && count>=2){
            Arrays.sort(ans2);
            ans+=max;
            ans2[arear++]=max;
            ccount++;
        }

        if(count==1){
            ans+=max;
            ccount++;
        }
        if(count==0){
            ans+=max*2;
            ccount=count+2;
        }
        while(ccount<2){
            Arrays.sort(ans2);
            ans-=ans2[ans2.length-ccount-1];
            //ans2[arear++]=max;
            ans+=max;
            ccount++;
        }
        out.println(ans);
        out.close();
    }
    public static class Tree{
        int weight;
        long pi;
        long ei;
        boolean back;
        boolean isVisited;
        ArrayList<Tree> children = new ArrayList<>();
        ArrayList<Integer> length = new ArrayList<>();
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
