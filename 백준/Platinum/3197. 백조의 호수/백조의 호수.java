import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, swanR, swanC;
    static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static char[][] map;
    static Deque<int[]> swan, water, swanNext, waterNext;
    static boolean[][][] visit;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        map = new char[R][];
        swan = new LinkedList<>(); water = new LinkedList<>();
        visit = new boolean[R][C][2];
        for(int i=0;i<R;i++) {
        	map[i] = br.readLine().toCharArray();
        	for(int j=0;j<C;j++) {
        		if(map[i][j]=='L') {
        			map[i][j] = '.';
        			if(swan.isEmpty()) {
        				swan.offer(new int[] {i,j});
        				visit[i][j][1] = true;
        			}else {
        				swanR = i; swanC = j;
        			}
        		}
        		if(map[i][j]=='.') {
        			water.offer(new int[] {i,j});
    				visit[i][j][0] = true;
        		}
        	}
        }
        int answer = 0;
        while(true) {
        	waterNext = new LinkedList<>(); swanNext = new LinkedList<>();
        	melt();
        	if(bfs()) {
        		System.out.println(answer);
        		break;
        	}
        	water = waterNext; swan = swanNext;
        	answer++;
        }
    }
    static boolean isIn(int r, int c) {
    	return 0<=r&&r<R&&0<=c&&c<C;
    }
    static boolean bfs() {
    	while(!swan.isEmpty()) {
    		int[] p = swan.pollFirst();
    		if(p[0]==swanR&&p[1]==swanC) { return true; }
    		for(int i=0;i<delta.length;i++) {
    			int nr = p[0]+delta[i][0], nc = p[1]+delta[i][1];
    			if(isIn(nr,nc)&&!visit[nr][nc][1]) {
    				visit[nr][nc][1] = true;
    				if(map[nr][nc]!='X') {
    					swan.offer(new int[] {nr,nc});
    				}else {
    					swanNext.offer(new int[] {nr,nc});
    				}
    			}
    		}
    	}
    	return false;
    }
    static void melt() {
    	while(!water.isEmpty()) {
    		int[] p = water.pollFirst();
    		if(map[p[0]][p[1]]=='X') {map[p[0]][p[1]]='.';}
    		for(int i=0;i<delta.length;i++) {
    			int nr = p[0]+delta[i][0], nc = p[1]+delta[i][1];
    			if(isIn(nr,nc)&&!visit[nr][nc][0]) {
    				visit[nr][nc][0] = true;
    				if(map[nr][nc]!='X') {
    					water.offer(new int[] {nr,nc});
    				}else {
    					waterNext.offer(new int[] {nr,nc});
    				}
    			}
    		}
    	}
    }
}