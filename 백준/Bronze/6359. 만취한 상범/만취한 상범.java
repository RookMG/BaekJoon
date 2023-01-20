import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int test = 0;test<T;test++) {
        	int n = Integer.parseInt(br.readLine()), answer = 0;
        	boolean[] escape = new boolean[n+1];
        	for(int i=1;i<=n;i++) {
        		for(int j=i;j<=n;j+=i) {
        			escape[j] = escape[j]?false:true;
        		}
        	}
        	for(int i=1;i<=n;i++) {
        		if(escape[i]) {answer++;}
        	}
        	System.out.println(answer);
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
