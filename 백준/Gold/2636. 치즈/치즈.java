import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static final int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static int R, C, time=0, remain=0, count = 0;
	static char[][] map;
	static boolean[][] visit;
	static ArrayDeque<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R+2][C+2];
		visit = new boolean[R+2][C+2];
		for(int r=1;r<=R;r++){
			st = new StringTokenizer(br.readLine());
			for(int c=1;c<=C;c++){
				if((map[r][c]=st.nextToken().charAt(0))=='1') remain++;
			}
		}
		visit[0][0] = true;
		q.offer(new int[]{0,0});
		while(remain>0){
			count = 0;
			for(int size = q.size();size>0;size--){
				int[] now = q.pollFirst();
				if(map[now[0]][now[1]]=='1') {
					map[now[0]][now[1]] = '0';
					count++;
				}
				for(int d=0;d<4;d++){
					int nr = now[0] + delta[d][0], nc = now[1] + delta[d][1];
					if(!isIn(nr,nc)||visit[nr][nc]) continue;
					visit[nr][nc] = true;
					if(map[nr][nc]=='1'){
						q.offerLast(new int[]{nr,nc});
					} else{
						size++;
						q.offerFirst(new int[]{nr,nc});
					}
				}
			}
			remain -= count;
			time++;
		}
		if(count>0) time--;
		sb.append(time).append("\n").append(count);
		bw.write(sb.toString());
		bw.flush();
	}

	static boolean isIn(int r, int c){
		return 0<=r&&r<R+2&&0<=c&&c<C+2;
	}
}