import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N+1][M+1];
        dp[0][0] = 1;
        boolean[][][] blocked = new boolean[N+1][M+1][2];
        for(int i= Integer.parseInt(br.readLine());i>0;i--){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            if(a==c) blocked[a][Math.min(b,d)][1] = true;
            else blocked[Math.min(a,c)][b][0] = true;
        }
        for(int r=0;r<=N;r++){
            for(int c=0;c<=M;c++){
                if(r!=N&&!blocked[r][c][0]) dp[r+1][c] += dp[r][c];
                if(c!=M&&!blocked[r][c][1]) dp[r][c+1] += dp[r][c];
            }
        }
        bw.write(Long.toString(dp[N][M]));
        bw.flush();
    }
}