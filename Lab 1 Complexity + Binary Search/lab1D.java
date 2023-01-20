import java.util.Scanner;
import java.math.*;
public class lab24 {
    public static long xr , yr , xc , yc , shu1=0 , heng1=0 ;
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       int N=0;
       xr=input.nextInt(); yr=input.nextInt();
       xc=input.nextInt(); yc=input.nextInt();
       N=input.nextInt(); int [] path = new int[N];
       String s = input.next();
       for(int i=0 ;i<N ; i++){
           if(s.substring(i,i+1).equals("U")) path[i]=1;
           if(s.substring(i,i+1).equals("D")) path[i]=2;
           if(s.substring(i,i+1).equals("L")) path[i]=3;
           if(s.substring(i,i+1).equals("R")) path[i]=4;
       }
        for( int i=0 ; i<N ; i++){//完整循环一次机器人走的绝对路径
            if(path[i]==1){shu1++;}
            if(path[i]==2){shu1--;}
            if(path[i]==3){heng1--;}
            if(path[i]==4){heng1++;}
        }
       if(test(0, (long) 1E14,path,N,shu1,heng1)<=1E14){

       System.out.println(test(0, (long) 1E14,path,N,shu1,heng1));}
       else System.out.println("-1");
    }
    public static long test(long low ,long high , int[]path ,int N,long shu1,long heng1){
        long mid = low + (high - low + 1) / 2;
        if(low<=high){
            if(checkwin(mid,path,N ,shu1,heng1)){

               return test(low,mid-1,path,N,shu1,heng1);
            }
            else {
                return test(mid+1,high,path,N,shu1,heng1);
            }

        }if(low>high){
            return low;
        }
        return mid;

    }

    public static boolean checkwin(long mid , int[]path , int N ,long shu1 , long heng1){
        long shu = 0, heng=0 ;
        long res1 = mid % N;
        long res2 = mid / N;
        for( int i=0 ; i<res1 ; i++){//事件t多走的路径
            if(path[i]==1){shu++;}
            if(path[i]==2){shu--;}
            if(path[i]==3){heng--;}
            if(path[i]==4){heng++;}
        }
            shu=res2*shu1+shu; heng=res2*heng1+heng;
            int count1=0,count2=0;
         if (xr>xc&&heng>0&&count1==0) {heng=Math.abs(heng);count1++;}
         if (xr<xc&&heng>0&&count1==0) {heng=-Math.abs(heng);count1++;}
         if (xr>xc&&heng<0&&count1==0) {heng=-Math.abs(heng);count1++;}
         if (xr<xc&&heng<0&&count1==0) {heng=Math.abs(heng);count1++;}
         if(yr>yc&&shu>0&&count2==0){shu=Math.abs(shu);count2++;}
         if(yr<yc&&shu>0&&count2==0){shu=-Math.abs(shu);count2++;}
         if(yr>yc&&shu<0&&count2==0){shu=-Math.abs(shu);count2++;}
         if(yr<yc&&shu<0&&count2==0){shu=Math.abs(shu);count2++;}
            if(Math.abs(xr-xc)+heng+Math.abs(yr-yc)+shu<=mid){
                return true;
            }
     return false;
    }
}
