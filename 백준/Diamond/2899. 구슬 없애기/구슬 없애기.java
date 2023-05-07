import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int MAX = 1000;
    static int N, K;
    static int[] marble;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        marble = new int[N];
        dp = new int[N][N][K];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) marble[i] = Integer.parseInt(st.nextToken());
        bw.write(Integer.toString(recur(0,N-1,0)));
        bw.flush();
    }
    static int recur(int left, int right, int count){
        if(left>right||right>=N) return 0;
        if(left==right) return K-count-1;
        if(dp[left][right][count]==-1) {
            dp[left][right][count] = (count > K - 1) ? MAX : (count < K - 1) ? recur(left, right, count + 1) + 1 : recur(left + 1, right, 0);
            for (int i = left; i < right; i++) {
                if (marble[left] != marble[i + 1]) continue;
                dp[left][right][count] = Math.min(dp[left][right][count], recur(left + 1, i, 0) + recur(i + 1, right, Math.min(K-1,count + 1)));
            }
        }
        return dp[left][right][count];
    }
}