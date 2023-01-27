import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//3
//6
//34
//38
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
    	int n = Integer.parseInt(br.readLine()),p = Integer.parseInt(br.readLine()), g;
    	if(n!=2) {
	        int[] arr = new int[n-1];
	        for(int i=0;i<n-1;i++) {
	        	int tmp = Integer.parseInt(br.readLine());
	        	arr[i] = Math.abs(tmp-p);
	        	p = tmp;
	        }
	        g = arrGcd(arr);
    	}
    	else { g = Math.abs(p-Integer.parseInt(br.readLine())); }
        for(int i=2;i<=g;i++) {
        	if(g%i==0) {
        		sb.append(i).append(" ");
        	}
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    public static int gcd(int a, int b) {
    	return b==0? a: gcd(b, a%b);
    }
    public static int arrGcd(int[] arr) {
    	int g = gcd(arr[0],arr[1]);
    	for(int i=2;i<arr.length;i++) {
    		g = gcd(g,arr[i]);
    	}
    	return g;
    }
}