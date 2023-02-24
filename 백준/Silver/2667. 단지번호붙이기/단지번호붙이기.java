import java.io.*;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N, count;
	static char[][] map;
	static PriorityQueue<Integer> answer = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0;i<N;i++){
			map[i] = br.readLine().toCharArray();
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(map[i][j]=='1'){
					map[i][j]='0';
					count=1;
					dfs(i,j);
					answer.add(count);
				}
			}
		}
		bw.write(Integer.toString(answer.size()));
		bw.write("\n");
		while(!answer.isEmpty()) {
			bw.write(Integer.toString(answer.poll()));
			bw.write("\n");
		}
		bw.flush();
	}
	static void dfs(int r, int c){
		for(int i=0;i<4;i++){
			int nr = r+delta[i][0], nc = c+delta[i][1];
			if(isIn(nr,nc)&&(map[nr][nc]=='1')){
				map[nr][nc] = '0';
				count++;
				dfs(nr,nc);
			}
		}
	}
	static boolean isIn(int nr, int nc){
	    return 0<=nr&&nr<N&&0<=nc&&nc<N;
	}
}