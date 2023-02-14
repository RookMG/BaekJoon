import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static final int SIZE = 0, DIR = 1, DEAD = 2;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer;
    static int[][] 	delta = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
    				
    public static void main(String[] args) throws Exception{
    	int[][][] map = new int[4][4][3]; //SIZE, DIR, DEAD
    	int[][] fish = new int[17][2];
        for(int r=0;r<4;r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c=0;c<4;c++) {
        		int size = Integer.parseInt(st.nextToken());
        		map[r][c][SIZE] = size;
        		map[r][c][DIR] = Integer.parseInt(st.nextToken())-1;
        		fish[size][0] = r;
        		fish[size][1] = c;
        	}
        }
        cycle(0, 0, 0, map, fish);
        
        System.out.print(answer);
    }
    static void cycle(int sr, int sc, int point, int[][][] map, int[][] fish) {
    	point+=map[sr][sc][SIZE];
    	int sdir = map[sr][sc][DIR];
    	map[sr][sc][DEAD] = 1;
    	
    	for(int i=1;i<=16;i++) {
    		int r = fish[i][0], c = fish[i][1], dir = map[r][c][DIR], nr=0, nc=0;
    		if(map[r][c][DEAD]==1) {
    			continue;
    		}
    		for(int j=0;j<8;j++) {
    			int ndir = map[r][c][DIR] = (dir+j)%8;
    			nr = r+delta[ndir][0];
    			nc = c+delta[ndir][1];
    			if(isIn(nr,nc)&&((nr!=sr)||(nc!=sc))) {
    				break;
    			}
    		}
    		int nextFish = map[nr][nc][SIZE];
    		fish[i][0] = nr; fish[i][1] = nc;
    		fish[nextFish][0] = r; fish[nextFish][1] = c;
    		int[] tmp = map[r][c];
    		map[r][c] = map[nr][nc];
    		map[nr][nc] = tmp;
    	}

    	for(int i=1;i<4;i++) {
    		int nr = sr+delta[sdir][0]*i, nc = sc+delta[sdir][1]*i;
    		if(isIn(nr,nc)&&map[nr][nc][DEAD]!=1) {
    			cycle(nr,nc,point,mapCopy(map),fishCopy(fish));
    		}
    	}
    	answer = Math.max(answer, point);
    	
    }
    static int[][][] mapCopy(int[][][] map){
    	int[][][] newmap = new int[4][4][3];
    	for(int i=0;i<4;i++) {
    		for(int j=0;j<4;j++) {
    			newmap[i][j] = Arrays.copyOf(map[i][j], 3);
    		}
    	}
    	return newmap;
    }
    static int[][] fishCopy(int[][] fish){
    	int[][] newfish = new int[17][2];
    	for(int i=0;i<17;i++) {
			newfish[i] = Arrays.copyOf(fish[i], 2);
    	}
    	return newfish;
    }
    static boolean isIn(int r, int c) {
		return 0 <= r && r < 4 && 0 <= c && c < 4;
	}
}