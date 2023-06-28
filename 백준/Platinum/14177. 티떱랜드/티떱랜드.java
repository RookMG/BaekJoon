import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long[][][] dp;
    static int[][] c;
    static int N, K;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        dp = new long[3][N+1][N+1];
        c = new int[N+1][N+1];
        for(int r=1;r<=N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1;c<=N;c++) dp[1][r][c] = dp[1][r][c-1] + Integer.parseInt(st.nextToken());
        }
        for(int r=1;r<=N;r++){
            for(int c=r+1;c<=N;c++) dp[2][r][c] = dp[2][r][c-1] + dp[1][c][c] - dp[1][c][r-1];
            dp[0][1][r] = dp[2][1][r];
        }
        for(int i=2;i<=K;i++) recur(i,i,N,i-1,N-1);
        bw.write(Long.toString(dp[0][K][N]));
        bw.flush();
    }
    static void recur(int idx, int l, int r, int cl, int cr){
        if(l > r) return;
        int m = (l + r) >> 1;
        dp[0][idx][m] = c[idx][m] = -1;
        for(int i=cl; i<=Math.min(m-1,cr); i++){
            if(dp[0][idx][m]!=-1&&dp[0][idx][m]<=dp[0][idx-1][i]+dp[2][i+1][m]) continue;
            dp[0][idx][m] = dp[0][idx-1][i]+dp[2][i+1][m];
            c[idx][m] = i;
        }
        recur(idx, l, m-1, cl, c[idx][m]);
        recur(idx, m+1, r, c[idx][m], cr);
    }
}