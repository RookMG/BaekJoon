import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, max;
    static int[][] cost;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new int[10][max = 1<<N][N];
        cost = new int[N][N];
        for(int r=0,c;(c=0)+r<N;r++) for(char ch:br.readLine().toCharArray()) cost[r][c++] = ch-'0';
        bw.write(Integer.toString(dfs(0,1,0)));
        bw.flush();
    }
    static int dfs(int price, int visit, int owner){
        if(dp[price][visit][owner]!=0) return dp[price][visit][owner];
        dp[price][visit][owner] = 1;
        if(visit == max) return dp[price][visit][owner];
        for(int i=0;i<N;i++){
            if(i==owner||cost[owner][i]<price||(visit&(1<<i))!=0) continue;
            dp[price][visit][owner] = Math.max(dp[price][visit][owner],1+dfs(cost[owner][i],visit|(1<<i),i));
        }
        return dp[price][visit][owner];
    }
}