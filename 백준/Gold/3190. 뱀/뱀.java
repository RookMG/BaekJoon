import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N, K, L, time, r=0, c=0, dir=1, er = 0, ec = 0, edir = 1;
	static char[][] map;
	static HashMap<Integer,Integer> moves;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0;i<K;i++){
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = '*';
		}
		L = Integer.parseInt(br.readLine());
		moves = new HashMap<>(L);
		for(int i=0;i<L;i++){
			st = new StringTokenizer(br.readLine());
			moves.put(Integer.parseInt(st.nextToken()),st.nextToken().charAt(0)=='L'?3:1);
		}
		map[0][0] = 'b';
		for(time=1;;time++){
			r += delta[dir][0];
			c += delta[dir][1];
			if(!isIn(r,c)||"abcd".indexOf(map[r][c])>=0) break;
			char apple = map[r][c];
			if(moves.containsKey(time)){
				dir = (dir+ moves.get(time))%4;
			}
			map[r][c] = (char)('a'+dir);
			if(apple!='*') {
				edir = map[er][ec] - 'a';
				map[er][ec] = ' ';
				er += delta[edir][0];
				ec += delta[edir][1];
			}
		}
		bw.write(Integer.toString(time));
		bw.flush();
	}
	static boolean isIn(int nr, int nc){
	    return 0<=nr&&nr<N&&0<=nc&&nc<N;
	}
}