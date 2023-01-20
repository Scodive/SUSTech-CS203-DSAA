import java.util.Scanner;
public class lab222 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextInt();
        long S = input.nextInt();
        long []num = new long[(int)n];
        for (int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        long ans=0;
        for(int i=0 ; i<n-1 ;i++) {
            for (int j = i + 1; j < n - 1; j++) {
                long x = S - num[i] - num[j];
                long up=SearchUp(num,x,j);
                long down=0;
                if(up!=-1){
                down=SearchDown(num,x,j);}
                long add=0;
                if(up!=-1 && down!=-1){
                    add=up-down+1;
                    ans+=add;
                }
            }
        }
        System.out.println(ans);
    }
    public static int SearchUp(long[] num , long x,int j){
        int l=j+1 ,r=num.length-1;
        int mid;
        while(l<r){
            mid=(l+r+1)/2;
            if(num[mid]>x){
                r=mid-1;
            }else l=mid;
        }if(num[l]==x){
        return l;}
            return -1;
    }
    public static int SearchDown(long[] num , long x,int j){
        int l=j+1 ,r=num.length-1;
        int mid;
        while(l<r && l>=j){
            mid=(l+r+1)/2;
            if(num[mid]>=x){
                if(num[mid]==x&&num[mid-1]!=x){
                    l++;
                }else r=mid-1;
            }else l=mid;
        }if(num[l]==x){
            return l;}
        return -1;
    }
}

