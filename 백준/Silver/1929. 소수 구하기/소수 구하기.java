import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] primes = new boolean[1000001];      
        Arrays.fill(primes,true);                     
        primes[1]=false;                              
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=2;i<=1000;i++) {
        	if(primes[i]) {
        		for(int j=2*i;j<1000001;j+=i) {
        			primes[j]=false;
        		}
        	}
        }
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        for(int i=a;i<=b;i++) {
        	if(primes[i]) {
        		sb.append(i).append("\n");
        	}
        }
        System.out.println(sb);                       
    }                                                 
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}