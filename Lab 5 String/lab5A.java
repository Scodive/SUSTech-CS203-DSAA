public class lab51 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int qs= in.nextInt();
        for(int qwq=0; qwq<qs ;qwq++) {
            String s = in.next();
            int m = s.length();
            int result = 0;
            int check = in.nextInt();
            char[][] chars = new char[check][101];
            int[][] longest = new int[m][2];
            for (int i = 0; i < check; i++) {
                String temp = in.next();
                int templength = temp.length();
                for (int j = 0; j < templength; j++) {
                    chars[i][j] = temp.charAt(j);
                }
            }


            for (int z = 0; z < m; z++) {
                int i = z, count1 = 0, count2 = 0, max = 0,sign=0;
                for (int j = 0; j < check; j++) {
                    for (int k = 0; k < 101 - z; k++) {
                        if (chars[j][k] != 0) {
                            count1++;
                            if (s.charAt(i) == chars[j][k]) {
                                //System.out.println("1");
                                count2++;
                                if (i == m - 1) {
                                    if(chars[j][k+1]!=0){
                                        count2=0;
                                    }
                                    break;
                                }
                                i++;
                            } else break;
                        } else break;
                    }
                    i = z;
                    if ( count2 == count1) {
                        if (max < count2) {
                            max = count2;
                            sign=j+1;
                        }
                    }
                    count1 = 0;
                    count2 = 0;
                }
                longest[z][0] = max;
                longest[z][1] = sign;
            }


            int[][] ans = new int[2001][2];
            int i = 0, last = 0;
            int []save=new int[3001];
            for (int j = 0; j < m; j++) {
                if(i>save[result]-1 && longest[i][0]==0){
                    result = -1;
                    break;
                }
                if (longest[0][0] == 0) {
                    result = -1;
                    break;
                }
                if ((i == 0 && longest[0][0] != 0) ||
                        (longest[i][0] != 0 && i + longest[i][0] > last + longest[last][0])) {
                    if(result>1 && save[result]>=i+1
                            && save[result]-longest[last][0]+1<=save[result-1] && save[result-1]>=i ){
                        //result--;
                        ans[result][0] = longest[i][1];
                        ans[result][1] = i + 1;
                        last=i;
                        save[result] = i+longest[i][0];
                        if(i+longest[i][0]==m){
                            break;
                        }
                        //result++;
                        i++;
                    }else {
                        result++;
                        last = i;
                        ans[result][0] = longest[i][1];
                        ans[result][1] = i + 1;
                        save[result] = i + longest[i][0];
                        if(i+longest[i][0]==m){
                            break;
                        }i++;
                    }
                } else i++;
                if (i - last-1 > save[result] - 1) {
                    result = -1;
                    break;
                }

            }


            out.println(result);
            if (result != -1) {
                for (int w = 1; w <= result; w++) {
                    out.println(ans[w][0] + " " + ans[w][1]);
                }
            }
        } out.close();
    }
}
