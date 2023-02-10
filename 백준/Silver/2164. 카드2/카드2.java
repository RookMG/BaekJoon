import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), answer = 1;
        for (int i = 2; i<=n; i++)
            answer = (answer + 1) % i + 1;
        System.out.println(answer==1?n:answer-1);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}