import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        primes[1]=false;
        for(int i=2;i<n+1;i++) {
            if(primes[i]) {
                for(int j=i;j<=n;j+=i) {
                	if(primes[j]) {
                		primes[j]=false;
	                    if(--k==0) {
	                    	System.out.println(j);
	                    	return;
	                    }
                	}
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}