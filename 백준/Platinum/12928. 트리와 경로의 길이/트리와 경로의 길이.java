import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, S;
    static int[][] dp;
    static char ans = '0';
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        dp = new int[N+1][S+1];
        recur(N-2,0);
        bw.write(ans);
        bw.flush();
    }

    static void recur(int n, int cnt){
        if(ans=='1') return;
        if(n==0&&cnt==S){
            ans = '1';
            return;
        }
        if(n==0||cnt>S||dp[n][cnt]>0) return;
        dp[n][cnt] = 1;
        for(int i=1;i<=n;i++) recur(n-i,cnt + (i*(i+1)>>1));
    }
}