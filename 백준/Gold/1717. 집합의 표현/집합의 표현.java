import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent;
    static int findParent(int child) {
    	return (parent[child]==child)?child:(parent[child]=findParent(parent[child]));
    }
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=0;i<=n;i++) {
        	parent[i] = i;
        }
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
        	int order = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            if(order==0) {
            	parent[findParent(Math.max(a, b))]=findParent(Math.min(a, b));
            }else {
            	sb.append(findParent(a)==findParent(b)?"YES\n":"NO\n");
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}