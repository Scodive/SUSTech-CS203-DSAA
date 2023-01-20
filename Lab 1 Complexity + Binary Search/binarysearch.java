import java.util.Scanner;
public class binarysearch {
    public static void main(String[] args) {
        int[] a={2,2,3,3,3,5,5,6,6,6,7,7};
        for(int i=1 ;i<=9 ; i++){
            System.out.println(i+" "+binaryup(a,i));
        }
    }
    static int binaryup(int[]a , int x){
        int l=0,r=a.length-1;
        int mid;
        while(l<r){
            mid=(l+r+1)/2;
            if(a[mid]>=x ){
                if(a[mid]==x&&a[mid-1]!=x){
                    l++;
                }else r=mid-1;
            }else l=mid+1;
        }return l;
    }
}
