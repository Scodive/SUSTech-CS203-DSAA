public class lab53 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int[][] fun = new int[200000][27];
        char[] p = new char[200000];
        int x = 0;
        String s = in.next();
        int m = s.length();
        for (int i = 1; i <= m; i++) {
            p[i] = s.charAt(i - 1);
        }
        fun[0][p[1] - 'a'] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 26; j++) {
                if (p[i + 1] == 'a' + j) {
                    fun[i][j] = i + 1;
                } else fun[i][j] = fun[x][j];
            }
            x = fun[x][p[i + 1] - 'a'];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 26; j++) {
                out.print(fun[i][j] + " ");
            }
            out.println("");
        }
        out.close();
    }
}
