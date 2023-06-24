import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long[] sum;
    static long[][] dp;
    static int[][] c;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken()), G = Integer.parseInt(st.nextToken());
        sum = new long[L+1];
        dp = new long[G+1][L+1];
        c = new int[G+1][L+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=L;i++) dp[1][i] = (sum[i] += sum[i-1]+Long.parseLong(st.nextToken()))*i;
        for(int i=2;i<=G;i++) recur(i,0,L,0,L);
        bw.write(Long.toString(dp[G][L]));
        bw.flush();
    }
    static void recur(int idx, int l, int r, int cl, int cr){
        if(l > r) return;
        int m = (l + r) >> 1;
        dp[idx][m] = -1;
        c[idx][m] = -1;
        long tmp;
        for(int i=cl; i<=cr; i++){
            tmp = dp[idx-1][i] + (sum[m]-sum[i])*(m-i);
            if(dp[idx][m]!=-1&&dp[idx][m]<=tmp) continue;
            dp[idx][m] = tmp;
            c[idx][m] = i;
        }
        recur(idx, l, m-1, cl, c[idx][m]);
        recur(idx, m+1, r, c[idx][m], cr);
    }
}