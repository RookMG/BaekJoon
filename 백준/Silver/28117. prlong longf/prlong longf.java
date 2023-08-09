import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int[] dp = new int[21];
        Arrays.fill(dp,1);
        dp[2]=2;
        for(int i=3;i<=20;i++) dp[i] = dp[i-2]*2 + dp[i-3];
        long ans = 1;
        int n = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();
        int[] longlen = new int[n+4];
        for(int i=0;i<=n-4;i++){
            if(line[i]=='l'&&line[i+1]=='o'&&line[i+2]=='n'&&line[i+3]=='g'){
                longlen[i+4] = longlen[i] + 1;
                longlen[i] = 0;
            }
        }
        for(int i=4;i<n+4;i++){
            ans *= dp[longlen[i]];
        }
        bw.write(Long.toString(ans));
        bw.flush();
    }
}