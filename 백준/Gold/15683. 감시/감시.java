import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{-1,0},{0,-1},{1,0},{0,1}};
	static final int[][] dirData = {{},{1,2,4,8},{5,10},{3,6,12,9},{14,13,11,7},{15}};
	static int R, C, now, zeros, size, min = Integer.MAX_VALUE;
	static int[][] map, MAP;
	static int[] dirs;
	static ArrayList<CCTV> cameras;
	static class CCTV{
		int type, r, c;
		public CCTV(int type, int r, int c) {
			this.type = type;
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		MAP = new int[R][C]; map = new int[R][C];
		cameras = new ArrayList<>();
		for(int i=0;i<R;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++){
				if((MAP[i][j]=Integer.parseInt(st.nextToken()))==0) zeros++;
				else if(MAP[i][j]<6) cameras.add(new CCTV(MAP[i][j],i,j));
			}
		}
		size = cameras.size();
		dirs = new int[size];
		recur(0);
		bw.write(Integer.toString(min));
		bw.flush();
	}
	static void recur(int idx){
		if(idx==size){
			mapCopy();
			count();
			return;
		}
		int type = cameras.get(idx).type;
		for(int i=0;i<dirData[type].length;i++){
			dirs[idx] = dirData[type][i];
			recur(idx+1);
		}
	}
	static void count(){
		now = zeros;

		for(int tv = 0;tv<size;tv++){
			int r = cameras.get(tv).r, c = cameras.get(tv).c;
			loop: for(int i=0;i<4;i++){
				if(((1<<i)&dirs[tv])!=0){
					int nr = r, nc = c;
					while(true){
						nr += delta[i][0]; nc += delta[i][1];
						if(!isIn(nr,nc)||map[nr][nc]==6) continue loop;
						if(map[nr][nc]==0){
							map[nr][nc] = -1;
							now--;
						}
					}
				}
			}
		}

		min = Math.min(min,now);
		if(min==0){
			try {
				bw.write('0');
				bw.flush();
			} catch (Exception ignored){
			}
			System.exit(0);
		}
	}
	static void mapCopy(){
		for(int i=0;i<R;i++){
			map[i] = Arrays.copyOf(MAP[i],C);
		}
	}
	static boolean isIn(int nr, int nc){
	    return 0<=nr&&nr<R&&0<=nc&&nc<C;
	}
}