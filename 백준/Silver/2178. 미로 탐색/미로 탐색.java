import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] delta = {{-1,0},{1,0},{0,1},{0,-1}};
    static int N, M;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][];
        boolean[][] visit = new boolean[N][M];
        for(int i=0;i<N;i++)
        	map[i] = br.readLine().toCharArray();
        Deque<int[]> dq = new LinkedList<>(), nq;
        dq.offer(new int[] {0,0});
        int answer = 1;
        loop:while(!dq.isEmpty()) {
        	nq = new LinkedList<>();
        	while(!dq.isEmpty()) {
        		int[] point = dq.poll();
        		if(point[0]==N-1&&point[1]==M-1) { break loop; }
        		for(int i=0;i<delta.length;i++) {
        			int nr = point[0]+delta[i][0], nc = point[1]+delta[i][1];
        			if(isIn(nr,nc)&&!visit[nr][nc]&&map[nr][nc]=='1') {
        				visit[nr][nc]=true;
        				nq.add(new int[] {nr,nc});
        			}
        		}
        	}
        	answer++;
        	dq = nq;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    static boolean isIn(int r, int c) {
    	return 0<=r&&r<N&&0<=c&&c<M;
    }
}