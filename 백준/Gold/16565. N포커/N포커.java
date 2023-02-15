import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
    	int n = Integer.parseInt(br.readLine());
    	if(n<4) {System.out.println(0);return;}
    	else if(n>39) {System.out.println(combination(52, n).mod(BigInteger.valueOf(10007)));return;}
    	long[][] record = new long[n+3][14];
    	record[0][0] = 1;
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<13;j++) {
    			for(int k=0;k<4;k++) {
    				record[i+k][j+1] += record[i][j]*(smallCom(4,k));
    			}
    		}
    	}
    	long answer = 0;
    	for(int i=1;4*i<=n;i++) {
    		answer += record[n-4*i][13-i]*smallCom(13,i);
    		answer %= 10007;
    	}
    	System.out.println(answer);
    }
    static BigInteger combination(int n, int r) {
    	BigInteger answer = new BigInteger("1"), div = new BigInteger("1");
    	for(int i=1;i<=r;i++) {
    		answer = answer.multiply(BigInteger.valueOf(n+1-i));
    		div = div.multiply(BigInteger.valueOf(i));
    	}
    	return answer.divide(div);
    }
    static long smallCom(int n, int r) {
    	long answer = 1, div = 1;
    	for(int i=1;i<=r;i++) {
    		answer*=n+1-i;
    		div*=i;
    	}
    	return answer/div;
    }
}