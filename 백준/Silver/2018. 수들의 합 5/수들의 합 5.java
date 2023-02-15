import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine()), answer = 1;
		int left = 0, right = 1, w = 1;
		while(left<=right&&right<N) {
			if(w<=N) {
				if(w==N)answer++;
				w+=++right;
			}else {
				w-=++left;
			}
		}
    	System.out.println(answer);
    }
}