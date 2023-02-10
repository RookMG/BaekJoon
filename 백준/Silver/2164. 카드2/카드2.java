import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine()), answer = 1;
        for (int i = 2; i<=n; i++)
            answer = (answer + 1) % i + 1;
        System.out.println(answer==1?n:answer-1);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}