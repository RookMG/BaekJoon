import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] lView, rView, answer;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        if(n==1) {br.readLine(); System.out.println(0); return;}
        lView = new int[n]; rView = new int[n]; answer = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	lView[i] = rView[n-1-i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n-1;i++) {
        	double lSlope = -1000000000, rSlope = -1000000000;
        	for(int j=i+1;j<n;j++) {
        		double lNow = 1.0*(lView[j]-lView[i])/(j-i), rNow = 1.0*(rView[j]-rView[i])/(j-i);
        		if(lNow>lSlope) {
        			lSlope = lNow;
        			answer[i]++;
        		}
        		if(rNow>rSlope) {
        			rSlope = rNow;
        			answer[n-1-i]++;
        		}
        	}
        }
        Arrays.sort(answer);
        System.out.println(answer[n-1]);
    }
}