import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
    	int T = Integer.parseInt(br.readLine());
    	for(int test = 1;test<=T;test++) {
    		sb.append("#").append(test).append(" ");
    		st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), answer = -1;
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
    				answer = Math.max(answer, w);
    				left++;
    			}else {
    				right--;
    			}
    		}
    		sb.append(answer).append("\n");
    	}
    	System.out.println(sb);
    }
}