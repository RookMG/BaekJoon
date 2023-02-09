import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int answer = 0;
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(br.readLine());
        	for(int j=0;j<m;j++) {
                st = new StringTokenizer(br.readLine());
        		int rx = Integer.parseInt(st.nextToken()), ry = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        		int d1 = (x1-rx)*(x1-rx)+(y1-ry)*(y1-ry), d2 = (x2-rx)*(x2-rx)+(y2-ry)*(y2-ry);
        		if(d1==r*r || d2==r*r || (d1<r*r ^ d2<r*r)) {
        			answer++;
        		}
        	}
        	sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}