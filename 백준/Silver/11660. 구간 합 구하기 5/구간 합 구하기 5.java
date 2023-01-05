import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                arr[i][j] += arr[i][j-1];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                arr[j][i] += arr[j-1][i];
            }
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
            int answer = arr[x2-1][y2-1];
            if(x1!=1){
                answer-=arr[x1-2][y2-1];
            }
            if(y1!=1){
                answer-=arr[x2-1][y1-2];
            }
            if(x1!=1&&y1!=1){
                answer+=arr[x1-2][y1-2];
            }
            System.out.println(answer);
        }
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}