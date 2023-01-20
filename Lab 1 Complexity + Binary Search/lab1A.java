import java.awt.datatransfer.ClipboardOwner;
import java.util.Scanner;
public class lab21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int cs = input.nextInt();
        int[] num = new int[length + 3];
        num[0] = -Integer.MAX_VALUE;
        num[length + 1] = Integer.MAX_VALUE;
        for (int i = 1; i < length + 1; i++) {
            num[i] = input.nextInt();
        }
        for (int q = 0; q< cs; q++) {
            int f1=0,f2=0;
            int low = input.nextInt();
            int high = input.nextInt();
            if (low != high ) {
                int a = FindNumberLow(0, length + 1, num, low);
                int b = FindNumberHigh(0, length + 1, num, high);
                if(a==-1||b==0 || b-a-1==0)System.out.println("NO");
                else System.out.println("YES " + (b - a-1 ));
            } else System.out.println("NO");
        }
    }
        public static int FindNumberLow ( int low, int high, int[] num, int search){
            if(search>=num[num.length-3]){return -1;}
            if(search<num[1]){return 0;}
            int mid = low + (high - low + 1) / 2;
            if (low <= high) {
                if (num[mid]<search && num[mid+1]>search) {
                        return mid;
                    }
                if(num[mid]==search){
                    int q=0;
                    for(int k=mid+1;k< num.length;k++){
                        if(num[k]==num[mid]){
                            q++;
                        }else break;
                    }
                    return mid+q;}
                    if(search>num[mid]){
                        return FindNumberLow(mid+1,high,num,search);
                    }
                else {
                return FindNumberLow(low, mid - 1, num, search);
            }  }return -1;
            }


        public static int FindNumberHigh ( int low, int high, int[] num, int search){
            if(search<=num[1]){return 0;}
            int mid = low + (high - low + 1) / 2;
            if (low <= high) {
                if(num[mid-1]<search && num[mid]>search){
                    return mid;
                }
                 if (search == num[mid]) {
                    int q=0;
                    for(int k=mid-1;k>0;k--){
                        if(num[k]==num[mid]){
                            q++;
                        }else break;
                    }
                    return mid-q;
                }
                if(search<num[mid]){
                    return FindNumberHigh(low,mid-1,num,search);
                }else {
                    return FindNumberHigh(mid + 1, high, num, search);
                }
            }
            return -1;
        }


    }

