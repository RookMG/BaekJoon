import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = BigInteger.valueOf(Integer.parseInt(st.nextToken())),b = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
        int gcd = a.gcd(b).intValue(), lcm = a.intValue()*b.intValue()/gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}