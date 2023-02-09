import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), right = 1, left = 0, answer = 1000001;
        int[] data = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
        	data[i] = data[i-1]+2-Integer.parseInt(st.nextToken());
        }
        while(left<right&&right<=n) {
        	if(data[right] - data[left] < k) {right++;}
        	else if(data[right] - data[left] > k) {left++;}
        	else {
        		answer = Math.min(answer, right-left++);
        	}
        }
        System.out.print(answer==1000001?-1:answer);
    }
}