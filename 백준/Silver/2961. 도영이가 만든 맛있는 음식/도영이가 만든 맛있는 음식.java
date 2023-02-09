import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, answer, sour, bitter;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        int[] ingS = new int[n], ingB = new int[n];
        answer = 2000000000;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
        	ingS[i] = Integer.parseInt(st.nextToken());
        	ingB[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<(1<<n);i++) {
        	sour = 1;
        	bitter = 0;
        	for(int j=0;j<n;j++) {
        		if((i&(1<<j)) >0) {
        			sour*=ingS[j];
        			bitter+=ingB[j];
        		}
        	}
        	answer = Math.min(answer, Math.abs(sour-bitter));
        }
        System.out.print(answer);
    }
}