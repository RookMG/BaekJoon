import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] height, answer;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine()), max = 0;
        height = new int[n]; answer = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	height[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n-1;i++) {
        	double slope = -1000000000;
        	for(int j=i+1;j<n;j++) {
        		double now = 1.0*(height[j]-height[i])/(j-i);
        		if(now>slope) {
        			slope = now;
        			answer[i]++;
        			answer[j]++;
        		}
        	}
        }
        for(int i=0;i<n;i++) {
        	max = Math.max(max, answer[i]);
        }
        System.out.println(max);
    }
}