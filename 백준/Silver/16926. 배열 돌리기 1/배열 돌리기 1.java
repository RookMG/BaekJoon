import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
    static int N, M, R;
    static int[][] map, answer, loopInfo;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
        map = new int[N][M]; answer = new int[N][M]; loopInfo = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        int loops = Math.min(N, M)/2;
        for(int i=0;i<loops;i++) {
        	int length = 2*(N+M-2-4*i);
        	int[][] flag = {{N-1-i,i},{N-1-i,M-1-i},{i,M-1-i},{i,i}};
        	int r = i, c = i;
        	for(int j=0;j<4;) {
        		loopInfo[r][c] = j;
        		r+=delta[j][0]; c+=delta[j][1];
        		if(r==flag[j][0]&&c==flag[j][1]) {j++;}
        	}
        	r=i;c=i;
        	for(int j=0;j<length;j++) {
        		int nr = r, nc = c, tmpr=r, tmpc=c;
        		for(int k=0;k<R%length;k++) {
        			tmpr = nr; tmpc = nc;
        			nr = tmpr+delta[loopInfo[tmpr][tmpc]][0]; nc = tmpc+delta[loopInfo[tmpr][tmpc]][1];
        		}
        		answer[nr][nc] = map[r][c];
        		nr = r+delta[loopInfo[r][c]][0]; nc = c+delta[loopInfo[r][c]][1];
        		r = nr; c = nc;
        	}
        }
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		sb.append(answer[i][j]).append(" ");
        	}
        	sb.setLength(sb.length()-1);
        	sb.append("\n");
        }
        System.out.print(sb);
    }
}