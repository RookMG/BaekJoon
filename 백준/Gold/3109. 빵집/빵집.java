import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R, C, answer = 0;
	static char[][] map;
	static boolean found;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for(int i=0;i<R;i++)
			map[i] = br.readLine().toCharArray();
		for(int i=0;i<R;i++) {
			if(map[i][0]=='.') {
				found = false;
				dfs(i,0);
			}
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static void dfs(int r, int c) {
		if(c==C-1) {
			found = true;
			answer++;
			return;
		}
		for(int i=-1;i<=1;i++) {
			int nr = r+i;
			if(0<=nr&&nr<R&&map[nr][c+1]=='.'&&!found) {
				dfs(nr,c+1);
				map[nr][c+1] = 'x';
			}
		}
	}
}