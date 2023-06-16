import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        char[] l1 = br.readLine().toCharArray(), l2 = br.readLine().toCharArray();
        int ans = 0;
        int[][] dp = new int[l1.length+1][l2.length+1];
        for(int i=1;i<=l1.length;i++){
            for(int j=1;j<=l2.length;j++){
                if(l1[i-1]!=l2[j-1]) continue;
                ans = Math.max(ans,dp[i][j] = dp[i-1][j-1]+1);
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}