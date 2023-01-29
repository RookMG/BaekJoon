import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine()), min = Integer.MAX_VALUE, max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int next = Integer.parseInt(st.nextToken());
            min = Math.min(min,next);
            max = Math.max(max,next);
        }
        System.out.println(min*max);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}