import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int MOD = 9901;
	static int R, C;
	static int[][] board;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R*C][1<<C];
		visit = new boolean[R*C][1<<C];
		bw.write(Integer.toString(recur(0,0)));
		bw.flush();
	}
	static int recur(int cell, int status){
		if(cell==R*C) return 1;
		if(visit[cell][status]) return board[cell][status];
		visit[cell][status] = true;
		if((status&1)>0) return board[cell][status] = recur(cell+1,status>>1);
		if(cell/C!=R-1) board[cell][status] = recur(cell+1,(status>>1)|(1<<(C-1)));
		if(cell%C!=C-1&&(status&2)==0) board[cell][status] += recur(cell+2,(status>>2))%MOD;
		return board[cell][status]%MOD;
	}
}