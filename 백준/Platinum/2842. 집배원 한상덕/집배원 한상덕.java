import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n, k = 0, left, right, answer = 1_000_000, found;
	static char[][] map;
	static int[][] alt;
	static boolean[][] visit;
	static final int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new char[n][n]; alt = new int[n][n];
		HashSet<Integer> altSet = new HashSet<>();
		int sr = 0, sc = 0, salt = 0;
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				char ch = map[i][j];
				if(ch=='K') k++;
				else if(ch=='P') {
					sr = i; sc = j;
				}
			}
		}
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) altSet.add(alt[i][j] = Integer.parseInt(st.nextToken()));
		}
		ArrayList<Integer> altList = new ArrayList<>(altSet);
		Collections.sort(altList);
		int lidx = 0, ridx;
		salt = alt[sr][sc];
		for(ridx = 0;altList.get(ridx)<salt;ridx++);
		while(lidx<=ridx&&ridx<altList.size()) {
			left = altList.get(lidx);
			if(salt<left) break;
			right = altList.get(ridx);
			found = 0;
			visit = new boolean[n][n];
			visit[sr][sc] = true;
			dfs(sr,sc);
			if(found==k) {
				answer = Math.min(answer, right-left);
				lidx++;
			}else ridx++;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static void dfs(int r, int c) {
		if(map[r][c]=='K') found++;
		for(int i=0;i<8;i++) {
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