import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static int R, C, answer, time;
	static char[][] map;
	static boolean[][][] visit;
	static ArrayDeque<Node> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visit = new boolean[R][C][1<<7];
		for(int r=0;r<R;r++){
			map[r] = br.readLine().toCharArray();
			for(int c=0;c<C;c++){
				if(map[r][c]=='0') q.offer(new Node(r,c,0));
			}
		}
		answer = -1;
		time = 0;
		search: while(!q.isEmpty()){
			for(int size = q.size();size>0;size--){
				Node now = q.pollFirst();
				if(map[now.r][now.c]=='1'){
					answer = time;
					break search;
				}
				for(int d=0;d<4;d++){
					int nr = now.r+delta[d][0], nc = now.c+delta[d][1], key = now.key;
					if(!isIn(nr,nc)||map[nr][nc]=='#') continue;
					if("ABCDEF".indexOf(map[nr][nc])>=0&&(key&(1<<(map[nr][nc]-'A')))==0) continue;
					if("abcdef".indexOf(map[nr][nc])>=0) key|= 1<<(map[nr][nc]-'a');
					if(visit[nr][nc][key]) continue;
					visit[nr][nc][key] = true;
					q.offerLast(new Node(nr,nc,key));
				}
			}
			time++;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static class Node{
		int r, c, key;
		Node(int r, int c, int key){
			this.r = r;
			this.c = c;
			this.key = key;
		}
	}
	static boolean isIn(int r, int c){
		return 0<=r&&r<R&&0<=c&&c<C;
	}
}