import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R,C,K;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    static char[][] map;
    static boolean[][][] visit;
    
    static class Status{
    	int r, c, time, wall;
		public Status(int r, int c, int time, int wall) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.wall = wall;
		}
    }
    
    public static void main(String[] args) throws Exception{
    	st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        map = new char[R][C]; visit = new boolean[R][C][K+1];
        for(int i=0;i<R;i++){
            map[i] = br.readLine().toCharArray();
        }
        
        Queue<Status> q = new ArrayDeque<>();
        q.add(new Status(0,0,1,K));
        
        while(!q.isEmpty()){
        	Status status = q.poll();
            if (status.r == R - 1 && status.c == C - 1) {
                System.out.println(status.time);
                return;
            }
            for (int[] d : delta) {
                int nr = status.r + d[0], nc = status.c + d[1];
                if (isIn(nr, nc)) {
                    if (map[nr][nc] == '0' && !visit[nr][nc][status.wall]) {
                        visit[nr][nc][status.wall] = true;
                        q.add(new Status(nr, nc, status.time + 1, status.wall));
                    } else if (map[nr][nc] == '1' && status.wall!=0 && !visit[nr][nc][status.wall-1]) {
                        visit[nr][nc][status.wall-1] = true;
                        q.add(new Status(nr, nc, status.time + 1, status.wall - 1));
                    }
                }
            }
        }
        
        System.out.println(-1);
    }

    static boolean isIn(int r, int c){
        return 0<=r&&r<R&&0<=c&&c<C;
    }
}