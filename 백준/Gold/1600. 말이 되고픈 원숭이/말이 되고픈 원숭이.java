import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] delta = {{-1,0},{1,0},{0,1},{0,-1}};
    static int[][] knight = {{-1,2},{1,2},{2,1},{2,-1},{-1,-2},{1,-2},{-2,1},{-2,-1}};
    static int N, M, K;
    public void solution() throws Exception {
    	K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][][] visit = new boolean[N][M][K+1];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            	map[i][j] = Integer.parseInt(st.nextToken());
        }
        Deque<int[]> dq = new LinkedList<>(), nq;
        dq.offer(new int[] {0,0,0});
        int answer = 0;
        while(!dq.isEmpty()) {
        	nq = new LinkedList<>();
        	while(!dq.isEmpty()) {
        		int[] point = dq.poll();
        		if(point[0]==N-1&&point[1]==M-1) {
        	        System.out.println(answer);
        	        return; 
        	    }
        		for(int i=0;i<delta.length;i++) {
        			int nr = point[0]+delta[i][0], nc = point[1]+delta[i][1];
        			if(isIn(nr,nc)&&!visit[nr][nc][point[2]]&&map[nr][nc]==0) {
        				visit[nr][nc][point[2]]=true;
        				nq.add(new int[] {nr,nc,point[2]});
        			}
        		}
        		if(point[2]<K) {
        			for(int i=0;i<knight.length;i++) {
            			int nr = point[0]+knight[i][0], nc = point[1]+knight[i][1];
            			if(isIn(nr,nc)&&!visit[nr][nc][point[2]+1]&&map[nr][nc]==0) {
            				visit[nr][nc][point[2]+1]=true;
            				nq.add(new int[] {nr,nc,point[2]+1});
            			}
            		}
        		}
        	}
        	answer++;
        	dq = nq;
        }
        System.out.println(-1);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    static boolean isIn(int r, int c) {
    	return 0<=r&&r<N&&0<=c&&c<M;
    }
}