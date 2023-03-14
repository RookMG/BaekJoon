import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        visit = new boolean[n+1];
        visit[0] = visit[1] = visit[2] = true;
        dp = new int[n+1];
        dp[2] = 1;
        bw.write(grundy(n)!=0?"1":"2");
        bw.flush();
    }
    static int grundy(int num){
        if(visit[num]) return dp[num];
        boolean[] mex = new boolean[num];
        for(int i=1;i<=num/2;i++){
            mex[grundy(i-1)^grundy(num-i-1)] = true;
        }
        for(int i=0;i<num;i++) {
            if(!mex[i]){
                dp[num] = i;
                break;
            }
        }
        visit[num] = true;
        return dp[num];
    }
}