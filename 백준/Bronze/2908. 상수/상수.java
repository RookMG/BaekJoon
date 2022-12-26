import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer num0 = new StringBuffer(st.nextToken()), num1 = new StringBuffer(st.nextToken());
        int ans0 = Integer.parseInt(num0.reverse().toString()), ans1 = Integer.parseInt(num1.reverse().toString());
        sb.append(ans0>ans1?ans0:ans1);
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}