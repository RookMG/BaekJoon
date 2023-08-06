import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        dp = new int[100001];
        dp[1] = 1;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] ans = new int[100001];
        for(int i=0;i<N;i++){
            int now = Integer.parseInt(st.nextToken());
            for(int j=1;j*now<=100000;j++) ans[j*now] += calc(j);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) sb.append(ans[Integer.parseInt(st.nextToken())]).append(' ');
        bw.write(sb.toString());
        bw.flush();
    }
    static int calc(int num){
        if(dp[num]!=0) return dp[num];
        dp[num] = 1;
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i!=0) continue;
            if(i*i==num) dp[num] += calc(i);
            else dp[num] += calc(i)+calc(num/i);
        }
        return dp[num];
    }
}