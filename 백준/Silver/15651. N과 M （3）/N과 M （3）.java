import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, r;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        pi(0);
        System.out.print(sb);
    }
    static void pi(int k) {
    	if(n==k) {
    		for(int num: arr) {
    			sb.append(num).append(" ");
    		}
    		sb.setLength(sb.length()-1);
    		sb.append("\n");
    		return;
    	}
    	for(int i=1;i<=r;i++) {
    		arr[k] = i;
    		pi(k+1);
    	}
    }
}