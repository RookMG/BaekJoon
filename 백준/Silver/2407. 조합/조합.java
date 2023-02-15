import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
    	st = new StringTokenizer(br.readLine());
        System.out.println(combination(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
    }
    static BigInteger combination(int n, int r) {
    	BigInteger answer = new BigInteger("1"), div = new BigInteger("1");
    	for(int i=1;i<=r;i++) {
    		answer = answer.multiply(BigInteger.valueOf(n+1-i));
    		div = div.multiply(BigInteger.valueOf(i));
    	}
    	return answer.divide(div);
    }
}