import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), max = 0;
        int[] dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int now = Integer.parseInt(st.nextToken());
            max = Math.max(max,dp[now] = dp[now-1] + 1);
        }
        bw.write(Integer.toString(N-max));
        bw.flush();
    }
}