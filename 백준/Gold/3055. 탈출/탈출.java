import java.io.*;
import java.util.*;;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static int R, C;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ArrayDeque<int[]> water = new ArrayDeque<>(), hedgehog = new ArrayDeque<>();
		char[][] map = new char[R][];
		boolean[][] visit = new boolean[R][C];
		for(int r=0;r<R;r++){
			map[r] = br.readLine().toCharArray();
			for(int c=0;c<C;c++){
				if(map[r][c]=='S'){
					hedgehog.add(new int[]{r,c});
					visit[r][c] = true;
				} else if(map[r][c]=='*'){
					water.add(new int[]{r,c});
					visit[r][c] = true;
				}
			}
		}
		int answer = -1, time = 0;
		loop: while(!hedgehog.isEmpty()){
			for(int size = hedgehog.size();size>0;size--){
				int[] now = hedgehog.pollFirst();
				if(map[now[0]][now[1]]=='D'){
					answer = time;
					break loop;
				}else if(map[now[0]][now[1]]=='*') continue;
				for(int d=0;d<4;d++){
					int nr = now[0]+delta[d][0], nc = now[1]+delta[d][1];
					if(!isIn(nr,nc)||visit[nr][nc]) continue;
					visit[nr][nc] = true;
					if(map[nr][nc]=='.'||map[nr][nc]=='D') hedgehog.offerLast(new int[]{nr,nc});
				}
			}
			for(int size = water.size();size>0;size--){
				int[] now = water.pollFirst();
				for(int d=0;d<4;d++){
					int nr = now[0]+delta[d][0], nc = now[1]+delta[d][1];
					if(!isIn(nr,nc)) continue;
					if(map[nr][nc]=='.'||map[nr][nc]=='S'){
						map[nr][nc]='*';
						water.offerLast(new int[]{nr,nc});
					}
				}
			}
			time++;
		}
		bw.write(answer<0?"KAKTUS":Integer.toString(answer));
		bw.flush();
	}

	static boolean isIn(int r, int c){
		return 0<=r&&r<R&&0<=c&&c<C;
	}
}