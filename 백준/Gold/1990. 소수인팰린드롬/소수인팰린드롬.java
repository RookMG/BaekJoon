import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        boolean[] primes = new boolean[b+1];      
        Arrays.fill(primes,true);                     
        primes[1]=false;                           
        for(int i=2;i<=(int)Math.sqrt(b)+1;i++) {
        	if(primes[i]) {   
        		for(int j=2*i;j<=b;j+=i) {
        			primes[j]=false;
        		}
        	}
        }
        for(int i=a;i<=b;i++) {
        	if(primes[i]) {   
                StringBuilder sb = new StringBuilder().append(i).reverse();
        		if(Integer.parseInt(sb.toString())==i) {
        			System.out.println(i);
        		}
        	}
        }
        System.out.println(-1);
    }                                                 
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
} 	