import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int[] h = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++) {
        	sum += h[i] = Integer.parseInt(br.readLine());
        }
        out:for(int i=0;i<9;i++) {
        	for(int j=i+1;j<9;j++) {
        		if(sum==100+h[i]+h[j]) {
        			h[i]=0;
        			h[j]=0;
        			break out;
        		}
        	}
        }
        Arrays.sort(h);
        for(int i=2;i<9;i++) {
        	System.out.println(h[i]);
        }
    }
}