import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), answer =0;
        Deque<Integer> q = new LinkedList();
        for(int i=1;i<=n;i++) {
        	q.offer(i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
        	int target = Integer.parseInt(st.nextToken());
        	for(int j=0;j<q.size();j++) {
        		int now = q.poll();
        		if(target==now) {
        			answer+=Math.min(j, 1+q.size()-j);
        			break;
        		}else q.offer(now);
        	}
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}