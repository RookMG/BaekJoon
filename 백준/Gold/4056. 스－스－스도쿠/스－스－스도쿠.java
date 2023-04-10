import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static char[][] map;
	static int[] R,C,Cell;
	static boolean success;
	public static void main(String[] args) throws Exception {
		for(int T = Integer.parseInt(br.readLine());T>0;T--) {
			R = new int[9];
			C = new int[9];
			Cell = new int[9];
			map = new char[9][];
			success = false;
			for(int r=0;r<9;r++) {
				map[r] = br.readLine().toCharArray();
				for(int c=0;c<9;c++){
					if(map[r][c]=='0') continue;
					int num = 1<<(map[r][c]-'1');
					if(((R[r]&num)|(C[c]&num)|(Cell[r/3*3+c/3]&num)) != 0) success = true;
					R[r] |= num;
					C[c] |= num;
					Cell[r/3*3+c/3] |= num;
				}
			}
			sb.setLength(0);
			sb.append("Could not complete this grid.\n");
			recur(0);
			sb.append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
	}
	static void recur(int n){
		if(success) return;
		if(n==81){
			sb.setLength(0);
			for(int r=0;r<9;r++) sb.append(map[r]).append("\n");
			success = true;
			return;
		}
		int r = n/9, c = n%9;
		if(map[r][c]!='0') recur(n+1);
		else for(int i=0;i<9;i++){
			int num = 1<<i;
			if(((R[r]&num)|(C[c]&num)|(Cell[r/3*3+c/3]&num)) != 0) continue;
			R[r] |= num;
			C[c] |= num;
			Cell[r/3*3+c/3] |= num;
			map[r][c] = (char)('1'+i);
			recur(n+1);
			R[r] ^= num;
			C[c] ^= num;
			Cell[r/3*3+c/3] ^= num;
			map[r][c] = '0';
		}
	}
}