import java.util.Scanner;
public class lab2222 {
    public static long []num = new long[4000];
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

                if(j==n-2 && num[i]+num[j]<S){

                    int func =FindSumUp(j, n - 1, S, i, j) ;
                    res += func;
                }
                if(j<n-2 && num[i]+num[j]+num[j+1]<=S ) {

                        int func =FindSumUp(j, n - 1, S, i, j) ;
                        res += func;
                }
            }
        }
        System.out.println(res);
    }

    public static int FindSumUp(long low , long high ,long S,int i,int j){
        int mid= (int)(low+high)/2;
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
                return FindSumUp(mid+1,high,S,i,j);
            }
            if(num[i]+num[j]+num[mid]>S){
                return FindSumUp(low,mid-1,S,i,j);
            }
            if(num[i]+num[j]+num[mid]==S) {
                if(mid!=num.length-1&&num[mid+1]==num[mid]){
                    return FindSumUp(low+1,high+1,S,i,j);
                }else {
                    int sw=FindSumLow(low,high,S,i,j);
                    return mid-sw+1;
                }
            }
        }return 0;
    }

    public static int FindSumLow(long low , long high ,long S,int i,int j) {
        int mid2 = (int) (low + high) / 2;
        if(low==high&&low!=j){
            if(num[i]+num[j]+num[mid2]==S){
                return 1;
            }
        }
        if(low<high) {
            if (mid2 == i || mid2 == j) {//如果找到了与i，j，相同的 往后一位
                if (mid2 != num.length - 1) {
                    mid2++;
                }
            }
            if (num[i] + num[j] + num[mid2] < S) {//向右搜索
                return FindSumLow(mid2 + 1, high, S, i, j);
            }
            if (num[i] + num[j] + num[mid2] > S) {
                return FindSumLow(low, mid2 - 1, S, i, j);
            }
            if (num[i] + num[j] + num[mid2] == S) {
                if (mid2 != j + 1 && num[mid2 - 1] == num[mid2]) {
                    return FindSumLow(low - 1, high - 1, S, i, j);
                } else return mid2;
            }
        }
        return 0;
    }

    }


