import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                arr[i][j] += Math.max(arr[i+1][j],arr[i+1][j+1]);
            }
        }
        System.out.println(arr[0][0]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}