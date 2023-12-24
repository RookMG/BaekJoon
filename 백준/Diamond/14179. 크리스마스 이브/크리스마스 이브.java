import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long[][] arr, sum, cost, dp;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        arr = new long[N+1][2];
        sum = new long[N+1][N+1];
        cost = new long[N+1][N+1];
        dp = new long[2][N+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,1,N+1,Comparator.comparingLong(o->o[0]));
        for(int i=1;i<=N;i++){
            sum[i][0] = sum[i-1][0] + arr[i][0];
            for(int j=i-1;j>0;j--) sum[i][j] = sum[i][j+1] + arr[j][1] * (arr[i][0] - arr[j][0]);
            for(int j=i+1;j<=N;j++) sum[i][j] = sum[i][j-1] + arr[j][1] * (arr[j][0] - arr[i][0]);
        }
        for(int i=1;i<=N;i++) {
            for(int j=i+1,k=i;j<=N;j++) {
                while(k<j && sum[k][i]+sum[k][j]>sum[k+1][i]+sum[k+1][j]) k++;
                cost[i][j] = sum[k][i]+sum[k][j];
            }
        }
        for(int i=1;i<=N;++i) dp[1][i] = cost[1][i];
        for(int i=2;i<=K;++i) recur(i,i,N,i-1,N-1);
        bw.write(Long.toString(dp[K%2][N]));
        bw.flush();
    }
    static void recur(int idx, int l, int r, int cl, int cr){
        if(l > r) return;
        int m = (l + r) >> 1;
        dp[idx%2][m] = Long.MAX_VALUE;
        long tmp;
        int cm = 0;
        for(int i=cl; i<=cr; i++){
            tmp = dp[(idx+1)%2][i] + cost[i+1][m];
            if(dp[idx%2][m]<=tmp) continue;
            dp[idx%2][m] = tmp;
            cm = i;
        }
        recur(idx, l, m-1, cl, cm);
        recur(idx, m+1, r, cm, cr);
    }
}