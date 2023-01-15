import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[] memory = new int[n], cost = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int maxcost = Arrays.stream(cost).sum();
        int[][] knapsack = new int[1+n][1+maxcost];
        for(int i=1;i<=n;i++){
            for(int j=0;j<cost[i-1];j++){
                knapsack[i][j] = knapsack[i-1][j];
            }
            for(int j=cost[i-1];j<=maxcost;j++){
                knapsack[i][j] = Math.max(knapsack[i-1][j],memory[i-1]+knapsack[i-1][j-cost[i-1]]);
            }
        }
        for(int j=0;j<=maxcost;j++){
            if(knapsack[n][j]>=m){
                System.out.println(j);
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}