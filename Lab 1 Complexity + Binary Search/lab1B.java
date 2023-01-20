import java.util.Scanner;
public class lab22 {
    public static long []num = new long[4000];
    public static long funcremain;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextInt();
        long S = input.nextInt();

        for(int i=0 ; i<n ; i++){
            num[i]=input.nextInt();
        }
        long res=0;
        for(int i=0 ; i<n-1 ;i++){
            for(int j=i+1 ; j<n-1 ;j++){
               if(S-num[i]-num[j]<num[j]){
                     break;
                }
                /*if(j>=i+2 && num[i]+num[j]==num[i]+num[j-1]){
                    res +=funcremain;
                    continue;
                }*/
                funcremain=0;
                if(j==n-2 && num[i]+num[j]<S){
                    int func = FindSum(j, n - 1, S, i, j);
                    res += func;
                    funcremain=func;
                }
                if(j<n-2 && num[i]+num[j]+num[j+1]<=S ) {
                    int func = FindSum(j, n - 1, S, i, j);
                    res += func;
                    funcremain=func;

                }
            }
        }
        System.out.println(res);
    }

    public static int FindSum(long low , long high ,long S,int i,int j){
        int mid= (int)(low+high)/2;
        int amount=0;
        if(low==high&&low!=j){
            if(num[i]+num[j]+num[mid]==S){
                return 1;
            }
        }
        if(low<high){
        if(mid==i || mid==j){//如果找到了与i，j，相同的 往后一位
            if(mid!=num.length-1) {
                mid++;
            }
        }
        if(num[i]+num[j]+num[mid]<S){//向右搜索
            return FindSum(mid+1,high,S,i,j);
            }
        if(num[i]+num[j]+num[mid]>S){
            return FindSum(low,mid-1,S,i,j);
        }
        if(num[i]+num[j]+num[mid]==S) {
            int q = 0;
            for (int k = mid + 1; k < num.length; k++) {//向右搜索 可能问题：搜到i，j相同的
                if (k != i && k != j && num[k] == num[mid]) {
                    q++;
                } else break;
            }
            for (int k = mid - 1; k > 0; k--) {
                if (k != i && k != j && num[k] == num[mid]) {
                    q++;
                } else break;
            }
            return q + 1;
         }
        }return 0;
    }
}
