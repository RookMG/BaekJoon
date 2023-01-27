import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int distance = -1*(Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken())), max = 0;
            for(long j=(int)Math.sqrt(distance)-1;;j++){
                if(j*(j+1)>=distance){
                    sb.append(j*j>=distance?2*j-1:2*j).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}