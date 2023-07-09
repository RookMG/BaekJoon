import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dp, arr;
    static int N, M, ans = 0;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[(N+1)*(N+1)];
        arr = new int[N+1];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for (int i = 1, s = Arrays.binarySearch(arr,0); i <= N; i++) {
            Arrays.fill(dp,-1);
            ans = Math.max(ans,i*M-recur(s,s,i));
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
    static int recur (int s, int e, int left) {
        if(left<1) return 0;
        if (dp[s*(N+1)+e] != -1) return dp[s*(N+1)+e];
        int l = Math.min(s, e), r = Math.max(s, e);
        dp[s*(N+1)+e] = Integer.MAX_VALUE;
        if(r < N) dp[s*(N+1)+e] = Math.min(dp[s*(N+1)+e],recur(l, r+1, left-1)+left*(arr[r+1]-arr[e]));
        if(l > 0) dp[s*(N+1)+e] = Math.min(dp[s*(N+1)+e],recur(r, l-1, left-1)+left*(arr[e]-arr[l-1]));
        return dp[s*(N+1)+e];
    }
}