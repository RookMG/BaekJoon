import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine()), answer = 0, now, tmp;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        now = arr[0];
        tmp = 0;
        for(int i=1;i<n;i++) {
        	if(arr[i]<now) {
        		tmp++;
        	}
        	else {
        		answer = Math.max(answer, tmp);
        		now = arr[i];
        		tmp = 0;
        	}
        }
		answer = Math.max(answer, tmp);
        System.out.print(answer);
    }
}