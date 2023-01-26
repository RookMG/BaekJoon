import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] primes = new boolean[246913];      
        Arrays.fill(primes,true);                     
        primes[1]=false;                              
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=500;i++) {
        	if(primes[i]) {
        		for(int j=2*i;j<246913;j+=i) {
        			primes[j]=false;
        		}
        	}
        }
        while(true) {
	        int a = Integer.parseInt(br.readLine()),count = 0;
	        if(a==0) {break;}
	        for(int i=a+1;i<=2*a;i++) {
	        	if(primes[i]) {
	        		count++;
	        	}
	        }
	        sb.append(count).append("\n");
        }
        System.out.println(sb);                       
    }                                                 
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}