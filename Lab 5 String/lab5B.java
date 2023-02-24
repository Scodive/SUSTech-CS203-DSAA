import java.util.Scanner;

public class lab52 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str = in.next();
    String str2 = in.next();
    //String str = "acbbcbds";
    String ans=manacher(str);
    System.out.println(ans);
    System.out.println(strStr(str2,str));
}

    public static char[] manacherString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }

    public static String manacher(String str){
        if(str == null || str.length() < 1){
            return null;
        }
        char[] charArr = manacherString(str);
        int[] radius = new int[charArr.length];
        int R = -1;
        int c = -1;
        int amount=0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < radius.length; i++) {
            radius[i] = R > i ? Math.min(radius[2*c-i],R-i+1):1;
            while(i+radius[i] < charArr.length && i - radius[i] > -1){
                if(charArr[i-radius[i]] == charArr[i+radius[i]]){
                    radius[i]++;
                }else{
                    break;
                }
            }
            if(i + radius[i] > R){
                R = i + radius[i]-1;
                c = i;
            }

            if(max<radius[i]){
                if(i<radius[i]){
                    amount=0;
                }else amount=(i-radius[i]+1)/2;
            }
            System.out.println(str.substring(amount,amount+radius[i]-1));
            max = Math.max(max,radius[i]);

        }
        return str.substring(amount,amount+max-1);
    }
    public static int strStr(String source, String target){
        if(source == null || target == null) return -1;
        int len = target.length();
        if(len == 0) return 0;
        int BASE = 10^6;
        int power = 1;
        for(int i = 0; i < len; i++){
            power = (power * 31) % BASE;
        }
        int targetCode = 0;
        int hashCode = 0;
        for(int i = 0; i < len; i++){
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }
        for(int i =0;i<source.length();i++){
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            if(i <= len - 1) continue;
            hashCode = hashCode - (source.charAt(i - len) * power) % BASE;
            if(hashCode < 0) hashCode += BASE;
            if(hashCode == targetCode){
                if(source.substring(i-len+1, i+1).equals(target)){
                    return i-len+1;
                }
            }
        }
        return -1;
    }

}
