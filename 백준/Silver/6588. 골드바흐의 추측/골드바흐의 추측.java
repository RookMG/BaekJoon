import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] primes = new boolean[1000001];     
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.fill(primes,true);                     
        primes[1]=false;                              
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=1001;i++) {
        	if(primes[i]) {
        		list.add(i);
        		for(int j=2*i;j<1000001;j+=i) {
        			primes[j]=false;
        		}
        	}
        }
        int len = list.size();
        loop: while(true) {
	        int a = Integer.parseInt(br.readLine()),count = 0;
	        if(a==0) {break;}
	        for(int i=1;i<len/2+1;i++) {
	        	int p = list.get(i);
	        	if(primes[a-p]) {
	        		sb.append(String.format("%d = %d + %d\n", a,p,a-p));
	        		continue loop;
	        	}
	        }
	        sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.println(sb);                       
    }                                                 
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}