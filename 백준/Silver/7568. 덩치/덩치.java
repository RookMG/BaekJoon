import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n], y = new int[n], answer = new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(x[i]<x[j]&&y[i]<y[j]){
                    answer[i]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            sb.append(1+answer[i]).append(" ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}