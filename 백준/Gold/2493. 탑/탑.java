import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] height = new int[n], answer = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	height[i] = Integer.parseInt(st.nextToken());
        }
        stack.add(new int[] {height[n-1],n-1});
        for(int i=n-2;i>=0;i--) {
        	while(!stack.isEmpty()&&stack.peek()[0]<height[i]) {
        		answer[stack.pop()[1]] = i+1;
        	}
        	stack.add(new int[] {height[i],i});
        }
        for(int i=0;i<n;i++) {
        	sb.append(answer[i]).append(" ");
        }
        System.out.print(sb);
    }
}