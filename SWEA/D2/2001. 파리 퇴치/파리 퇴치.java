import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
    	int T = Integer.parseInt(br.readLine());
    	for(int test = 1;test<=T;test++) {
    		sb.append("#").append(test).append(" ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), answer = 0;
            int[][] arr = new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=1;i<=n;i++){
                for(int j=2;j<=n;j++){
                    arr[i][j] += arr[i][j-1];
                }
            }
            for(int i=1;i<=n;i++){
                for(int j=2;j<=n;j++){
                    arr[j][i] += arr[j-1][i];
                }
            }
            for(int i=m;i<=n;i++) {
            	for(int j=m;j<=n;j++) {
            		answer = Math.max(answer, arr[i][j]-arr[i-m][j]-arr[i][j-m]+arr[i-m][j-m]);
            	}
            }
            sb.append(answer).append("\n");
    	}
    	System.out.println(sb);
    }
}