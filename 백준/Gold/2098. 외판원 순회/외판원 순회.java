import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int MAX = 100_000_000;
    static int N;
    static int[][] link, dp;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        link = new int[N][N];
        dp = new int[N][1<<N];
        visit = new boolean[N][1<<N];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],MAX);
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) link[i][j] = Integer.parseInt(st.nextToken());
        }
        bw.write(Integer.toString(dfs(0,1)));
        bw.flush();
    }
    static int dfs(int now, int bit){
        if(bit+1==(1<<N)) return link[now][0]!=0?link[now][0]:MAX;
        if(visit[now][bit]) return dp[now][bit];
        for(int i=1;i<N;i++){
            if(link[now][i]!=0&&(bit&(1<<i))==0){
                dp[now][bit] = Math.min(dp[now][bit],link[now][i]+dfs(i,bit|(1<<i)));
            }
        }
        visit[now][bit] = true;
        return dp[now][bit];
    }
}