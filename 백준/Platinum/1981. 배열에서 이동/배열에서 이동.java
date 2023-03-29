import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n, left, right, answer = 200;
	static boolean valid;
	static int[][] alt;
	static boolean[][] visit;
	static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		alt = new int[n][n];
		HashSet<Integer> altSet = new HashSet<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) altSet.add(alt[i][j] = Integer.parseInt(st.nextToken()));
		}
		ArrayList<Integer> altList = new ArrayList<>(altSet);
		Collections.sort(altList);
		int lidx = 0, ridx = 0, salt = alt[0][0];
		for(;altList.get(ridx)<salt;ridx++);
		while(lidx<=ridx&&ridx<altList.size()) {
			left = altList.get(lidx);
			if(salt<left) break;
			right = altList.get(ridx);
			visit = new boolean[n][n];
			visit[0][0] = true;
			valid = false;
			dfs(0,0);
			if(valid) {
				answer = Math.min(answer, right-left);
				lidx++;
			}else ridx++;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static void dfs(int r, int c) {
		if(r==n-1&&c==n-1){
			valid = true;
			return;
		}
		for(int i=0;i<4;i++) {
			int nr = r + delta[i][0], nc = c + delta[i][1];
			if(isIn(nr,nc)&&!visit[nr][nc]) {
				visit[nr][nc] = true;
				int nalt = alt[nr][nc];
				if(left<=nalt&&nalt<=right) dfs(nr,nc);
			}
		}
	}
	static boolean isIn(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}
}