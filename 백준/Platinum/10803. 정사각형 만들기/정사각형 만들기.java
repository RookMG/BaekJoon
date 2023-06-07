import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] dp;
    static int tmp;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        if(N<M){
            tmp=N;
            N=M;
            M=tmp;
        }
        dp = new int[N+1][M+1];
        bw.write(Integer.toString(recur(N,M)));
        bw.flush();
    }
    static int recur(int N, int M){
        if(N==M) return dp[N][M] = 1;
        if(N<M){
            tmp=N;
            N=M;
            M=tmp;
        }
        if(dp[N][M]!=0) return dp[N][M];
        if(N>3*M) return dp[N][M] = recur(N-M,M)+1;
        dp[N][M] = N*M;
        for (int n = N>>1; n>0; --n) dp[N][M] = Math.min(dp[N][M], recur(n, M) + recur(N - n, M));
        for (int m = M>>1; m>0; --m) dp[N][M] = Math.min(dp[N][M], recur(N, m) + recur(N, M - m));
        return dp[N][M];
    }
}