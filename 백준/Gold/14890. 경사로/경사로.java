import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken()), answer = 0;
		int[][] map = new int[N][N];
		for(int r=0;r<N;r++){
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++){
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		line:for(int r=0;r<N;r++){
			boolean[] visit = new boolean[N];
			for(int b=map[r][0],c=1;c<N;c++){
				int n = map[r][c];
				if(n==b+1){
					if(c<X) continue line;
					for(int check=c-1;check>c-1-X;check--){
						if(visit[check]||map[r][check]!=b) continue line;
						visit[check] = true;
					}
				}else if(n==b-1){
					if(c>N-X) continue line;
					for(int check=c;check<c+X;check++){
						if(visit[check]||map[r][check]!=n) continue line;
						visit[check] = true;
					}
				}else if(n==b) continue;
				else continue line;
				b = n;
			}
			answer++;
		}
		line:for(int r=0;r<N;r++){
			boolean[] visit = new boolean[N];
			for(int b=map[0][r],c=1;c<N;c++){
				int n = map[c][r];
				if(n==b+1){
					if(c<X) continue line;
					for(int check=c-1;check>c-1-X;check--){
						if(visit[check]||map[check][r]!=b) continue line;
						visit[check] = true;
					}
				}else if(n==b-1){
					if(c>N-X) continue line;
					for(int check=c;check<c+X;check++){
						if(visit[check]||map[check][r]!=n) continue line;
						visit[check] = true;
					}
				}else if(n==b) continue;
				else continue line;
				b = n;
			}
			answer++;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}