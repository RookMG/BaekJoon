import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine()), answer = 0;
		int[] weights= new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(weights);
		int left = 0, right = N-1;
		while(left<right&&right>0) {
			int w = weights[left]+weights[right];
			if(w<=M) {
				if(w==M)answer++;
				left++;
			}else {
				right--;
			}
		}
    	System.out.println(answer);
    }
}