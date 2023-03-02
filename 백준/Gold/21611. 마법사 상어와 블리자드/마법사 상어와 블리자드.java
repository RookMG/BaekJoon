import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	static int N, M, answer = 0;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int r = N/2, c = N/2, dir = Integer.parseInt(st.nextToken()), range = Integer.parseInt(st.nextToken());
			for(int j=0;j<range;j++){
				r += delta[dir][0];
				c += delta[dir][1];
				map[r][c] = 0;
			}
			updateMap();
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static void updateMap(){
		int dir = 0, r = N/2, c = N/2, idx = 0, l;
		int[][] delta = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
		ArrayDeque<Integer> dq = new ArrayDeque<>(), nq;
		for (l = 1; l < N; dir = (dir+1)%4) {
			for(int i=0;i<l;i++){
				r+=delta[dir][0];
				c+=delta[dir][1];
				if(map[r][c]!=0) dq.offerLast(map[r][c]);
			}
			if((dir&1)==1) l++;
		}
		l--;
		for(int i=0;i<l;i++){
			r+=delta[dir][0];
			c+=delta[dir][1];
			if(map[r][c]!=0) dq.offerLast(map[r][c]);
		}
		boolean change = true;
		while(change){
			change = false;
			dq.offerLast(0);
			int before = -1, cnt = 0;
			nq = new ArrayDeque<>();
			while(!dq.isEmpty()){
				int now = dq.pollFirst();
				if(now == before){
					cnt++;
					continue;
				}
				if(cnt<4){
					for(int i=0;i<cnt;i++){
						nq.offerLast(before);
					}
				}else{
					answer += before*cnt;
					change = true;
				}
				before = now;
				cnt = 1;
			}
			dq = nq;
		}
		nq = new ArrayDeque<>();
		while(!dq.isEmpty()){
			int cnt = 1, num = dq.pollFirst();
			while(!dq.isEmpty()){
				if(dq.peekFirst()!=num) break;
				cnt++;
				dq.pollFirst();
			}
			nq.offerLast(cnt);
			nq.offerLast(num);
		}
		dir = 0; r = N/2; c = N/2;
		for (l = 1; l < N; dir = (dir+1)%4) {
			for(int i=0;i<l;i++){
				r+=delta[dir][0];
				c+=delta[dir][1];
				map[r][c] = nq.isEmpty()?0:nq.pollFirst();
			}
			if((dir&1)==1) l++;
		}
		l--;
		for(int i=0;i<l;i++){
			r+=delta[dir][0];
			c+=delta[dir][1];
			map[r][c] = nq.isEmpty()?0:nq.pollFirst();
		}
	}
}