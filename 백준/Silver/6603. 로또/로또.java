import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] nums, answer;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
    	while(true) {
    		st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		if(n==0) break;
    		nums = new int[n]; answer = new int[6]; visit = new boolean[n];
    		for(int i=0;i<n;i++) {
    			nums[i] = Integer.parseInt(st.nextToken());
    		}
    		Arrays.sort(nums);
    		combination(0, 0);
    		sb.append("\n");
    	}
        System.out.print(sb);
    }
    static void combination(int idx, int start) {
    	if(idx==6) {
    		for(int i=0;i<6;i++) {
    			sb.append(answer[i]).append(" ");
    		}
    		sb.setLength(sb.length()-1);
    		sb.append("\n");
    		return;
    	}
    	for(int i=start;i<n;i++) {
    		if(!visit[i]) {
    			visit[i] = true;
    			answer[idx]=nums[i];
    			combination(idx+1,i+1);
    			visit[i] = false;
    		}
    	}
    }
}