import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[3][N+1];
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[N+1][2];
        for(int i=1, l, r, m;i<=N;i++){
            for(l=0, r=i, m=i>>1;l+1<r;m=(l+r)>>1){
                if(arr[0][m]>=arr[0][i]-arr[1][i]) r = m;
                else l = m;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = Math.max(dp[l][0],dp[l][1])+arr[2][i];
        }
        bw.write(Long.toString(Math.max(dp[N][0],dp[N][1])));
        bw.flush();
    }
}