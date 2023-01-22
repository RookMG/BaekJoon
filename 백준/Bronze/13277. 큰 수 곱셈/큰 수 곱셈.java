import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        BigInteger b1 = new BigInteger(st.nextToken()), b2 = new BigInteger(st.nextToken());
        System.out.println(b1.multiply(b2));
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}