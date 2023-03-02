import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, answer = 0, max = 0;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) max += map[i][j] = Integer.parseInt(st.nextToken());
		}
		max = Integer.highestOneBit(max);
		recur(5, map);
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static void recur(int left, int[][] map){
		if(left==0){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++) answer = Math.max(map[i][j],answer);
			}
			return;
		}
		if(answer==max) return;
		int[][] nmap;
		ArrayDeque<Integer> dq;

		//left
		nmap = new int[N][N];
		for(int i=0;i<N;i++){
			dq = new ArrayDeque<>();
			for(int j=0;j<N;j++){
				if(map[i][j]!=0) dq.offerLast(map[i][j]);
			}
			int idx = 0;
			while(!dq.isEmpty()){
				int now = dq.pollFirst();
				if(!dq.isEmpty()&&dq.peekFirst()==now){
					nmap[i][idx++] = 2*dq.pollFirst();
				}else nmap[i][idx++] = now;
			}
		}
		recur(left-1,nmap);


		//right
		nmap = new int[N][N];
		for(int i=0;i<N;i++){
			dq = new ArrayDeque<>();
			for(int j=0;j<N;j++){
				if(map[i][j]!=0) dq.offerFirst(map[i][j]);
			}
			int idx = 0;
			while(!dq.isEmpty()){
				int now = dq.pollFirst();
				if(!dq.isEmpty()&&dq.peekFirst()==now){
					nmap[i][N-1-idx++] = 2*dq.pollFirst();
				}else nmap[i][N-1-idx++] = now;
			}
		}
		recur(left-1,nmap);


		//up
		nmap = new int[N][N];
		for(int i=0;i<N;i++){
			dq = new ArrayDeque<>();
			for(int j=0;j<N;j++){
				if(map[j][i]!=0) dq.offerLast(map[j][i]);
			}
			int idx = 0;
			while(!dq.isEmpty()){
				int now = dq.pollFirst();
				if(!dq.isEmpty()&&dq.peekFirst()==now){
					nmap[idx++][i] = 2*dq.pollFirst();
				}else nmap[idx++][i] = now;
			}
		}
		recur(left-1,nmap);

		//down
		nmap = new int[N][N];
		for(int i=0;i<N;i++){
			dq = new ArrayDeque<>();
			for(int j=0;j<N;j++){
				if(map[j][i]!=0) dq.offerFirst(map[j][i]);
			}
			int idx = 0;
			while(!dq.isEmpty()){
				int now = dq.pollFirst();
				if(!dq.isEmpty()&&dq.peekFirst()==now){
					nmap[N-1-idx++][i] = 2*dq.pollFirst();
				}else nmap[N-1-idx++][i] = now;
			}
		}
		recur(left-1,nmap);
	}
}