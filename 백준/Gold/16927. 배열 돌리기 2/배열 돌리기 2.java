import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
    static int N, M, R;
    static int[][] map, answer;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
        map = new int[N][M]; answer = new int[N][M];
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
        	int r = i, c = i, dir = 0;
        	for(int j=0;j<length;j++) {
        		int nr = r, nc = c, ndir = dir;
        		for(int k=0;k<R%length;k++) {
        			nr += delta[ndir][0]; nc += delta[ndir][1];
        			if(nr==flag[ndir][0]&&nc==flag[ndir][1]) {ndir = (ndir+1)%4;}
        		}
        		answer[nr][nc] = map[r][c];
    			r += delta[dir][0]; c += delta[dir][1];
        		if(r==flag[dir][0]&&c==flag[dir][1]) {dir = (dir+1)%4;}
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