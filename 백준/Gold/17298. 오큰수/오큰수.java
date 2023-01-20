import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n], answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        Arrays.fill(answer, -1);
        
        for(int i=0;i<n;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++) {
        	int now = arr[i];
        	if(stack.isEmpty()){
                stack.push(i);
            }else{
                while(!stack.isEmpty()){
                    int idx = stack.pop();
                    if(arr[idx]>=now){
                        stack.push(idx);
                        break;
                    }else{
                        answer[idx]=now;
                    }
                }
                stack.push(i);
            }
        }
        
        for(int i=0;i<n;i++) {
        	sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}