import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()),now = 0,answer = 0;
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
        	answer = Math.max(answer, now);
        }
        System.out.print(answer);
    }
}