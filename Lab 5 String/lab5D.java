public class lab54 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();

        int [] char1 = new int[2*n-1];
        String temp1=in.next();
        String temp2=in.next();
        int result=0;
        for(int i=1 ; i<2*n-1 ; i++){
            if(i<n) {
                if (temp1.charAt(i-1) == 'S') {
                    char1[n - i] = 1;
                }
                if (temp1.charAt(i-1) == 'N') {
                    char1[n  - i] = 3;
                }
                if (temp1.charAt(i-1) == 'E') {
                    char1[n  - i] = 4;
                }
                if (temp1.charAt(i-1) == 'W') {
                    char1[n - i] = 2;
                }
            }else {
                if(temp2.charAt(i-n)=='S'){
                    char1[i] = 3;
                }
                if(temp2.charAt(i-n)=='N'){
                    char1[i] = 1;
                }
                if(temp2.charAt(i-n)=='E'){
                    char1[i] = 2;
                }
                if(temp2.charAt(i-n)=='W'){
                    char1[i] = 4;
                }

            }
        }
        int x=0;
        int[][] fun = new int[2000002][5];
        fun[0][char1[1] -1] = 1;
        for (int i = 1; i < 2*n-2; i++) {
            for (int j = 0; j < 4; j++) {
                if (char1[i+1] == 1 + j) {
                    fun[i][j] = i + 1;
                } else fun[i][j] = fun[x][j];
            }
            x = fun[x][char1[i+1] - 1];
            //out.println(x);
        }

      /*  int[] next = new int[2*n-2];
        next[0]=-1;
        int j=0;
        int k=-1;
        while (j < 2*n-3) {
            if (k == -1 || char1[j] ==char1[k]) {
                if (char1[++j] == char1[++k]) { // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }*/

        if(x>0){
            out.println("NO");
        }else {
            out.println("YES");
        }
        for(int i=0 ; i<5 ;i++){
            out.println("1");
        }
        out.close();
    }
}
