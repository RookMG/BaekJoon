import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void solution() throws Exception {
        char[] line = br.readLine().toCharArray();
        int l = line.length;
        boolean[][] palin = new boolean[l][l];
        int[] dp = new int[l];
        for(int i=0;i<l-1;i++) {
            palin[i][i] = true;
            palin[i][i+1] = line[i]==line[i+1];
            dp[i+1]=i+2;
        }
        dp[0] = 1;
        palin[l-1][l-1] = true;

        for(int i=2;i<l;i++){
            for(int j=0;j<l-i;j++) {
                palin[j][j+i] = (palin[j+1][j+i-1])&&(line[i+j]==line[j]);
            }
        }

        for(int i=0;i<l;i++)
            for(int j=i;j<l;j++)
                if(palin[i][j]){
                    dp[j] = Math.min(dp[j],i==0?1:dp[i-1]+1);
                }
        System.out.print(dp[l-1]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}