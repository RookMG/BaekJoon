import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine()), K = Integer.parseInt(br.readLine());
        int[] dp = new int[T+1];
        dp[0] = 1;
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken()), num = Integer.parseInt(st.nextToken());
            if(price>T) continue;
            for(int k=T;k>=price;k--){
                for(int j=1;j<=num;j++){
                    if(k<j*price) break;
                    dp[k] += dp[k-j*price];
                }
            }
        }
        bw.write(Integer.toString(dp[T]));
        bw.flush();
    }
}