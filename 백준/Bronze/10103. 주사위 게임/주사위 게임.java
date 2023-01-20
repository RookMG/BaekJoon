import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine()), p1 = 100, p2 = 100;
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	int n1 = Integer.parseInt(st.nextToken()),n2 = Integer.parseInt(st.nextToken());
        	if(n1<n2) {
        		p1-=n2;
        	}else if(n1>n2) {
        		p2-=n1;
        	}
        }
        sb.append(p1).append("\n").append(p2).append("\n");
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
