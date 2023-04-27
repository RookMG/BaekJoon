import java.io.*;
import java.util.*;
public class Main {
	static class Status {
		static int[] home;
		static ArrayList<int[]> blocks = new ArrayList<>();
		char[] record;
		int r, c;

		public Status(char[] record, int r, int c) {
			this.record = record;
			this.r = r;
			this.c = c;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder("-1");
	static StringTokenizer st;
	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우
	static final char[] msg = {'D','U','R','L'};
	static int R, C, cr, cc;
	static char[][] map;
	static boolean[][] visit;
	static int[] margin = {1000,1000,1000,1000};

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for(int r=0;r<R;r++){
			map[r] = br.readLine().toCharArray();
			for(int c=0;c<C;c++){
				if(map[r][c]=='H'){
					Status.home = new int[] {r,c};
				}else if(map[r][c]=='#'){
					Status.blocks.add(new int[] {r,c});
				}else if(map[r][c]=='T'){
					margin[0] = Math.min(margin[0],r);
					margin[1] = Math.min(margin[1],R-r-1);
					margin[2] = Math.min(margin[2],c);
					margin[3] = Math.min(margin[3],C-c-1);
					cr=r;
					cc=c;
				}
			}
		}
		visit = new boolean[R][C];

		ArrayDeque<Status> dq = new ArrayDeque<>();
		dq.add(new Status(new char[]{},0,0));
		visit[cr][cc] = true;
		while(!dq.isEmpty()){
			Status now = dq.pollFirst();
			if(isIn(Status.home[0]+now.r,Status.home[1]+now.c)&&map[Status.home[0]+now.r][Status.home[1]+now.c]=='T'){
				sb.setLength(0);
				sb.append(now.record);
				break;
			}
			next:for(int d=0;d<4;d++){
				int nr = now.r+delta[d][0], nc = now.c+delta[d][1];
				if(!canGo(-nr,-nc)||visit[cr-nr][cc-nc]) continue;
				for(int[] block:Status.blocks){
					if(isIn(block[0]+nr,block[1]+nc)&&map[block[0]+nr][block[1]+nc]=='T') continue next;
				}
				visit[cr-nr][cc-nc] = true;
				char[] nrecord = Arrays.copyOf(now.record,now.record.length+1);
				nrecord[nrecord.length-1]=msg[d];
				dq.offerLast(new Status(nrecord,nr,nc));
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	static boolean canGo(int r, int c){
		return -margin[0]<=r&&r<=margin[1]&&-margin[2]<=c&&c<=margin[3];
	}
}