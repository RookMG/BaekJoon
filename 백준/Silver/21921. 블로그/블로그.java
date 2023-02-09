import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()),now = 0,answer = 0,dup = 1;
        int[] data = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	data[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<k;i++) {
        	now += data[i];
        }
        answer = now;
        for(int i=0;i<n-k;i++) {
        	now+=data[k+i]-data[i];
        	if(now>answer) {
        		answer = now;
        		dup = 1;
        	}else if(now == answer) {
        		dup++;
        	}
        }
        if(answer>0) {
	        System.out.println(answer);
	        System.out.println(dup);
        }else {
        	System.out.println("SAD");
        }
    }
}