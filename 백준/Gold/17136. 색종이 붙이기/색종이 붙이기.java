import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] paper = {0,5,5,5,5,5};
	static boolean[][] map = new boolean[10][10];
	static int answer = 26;
	public static void main(String[] args) throws Exception {
		int count = 0;
		for(int r=0;r<10;r++){
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<10;c++){
				if(map[r][c]=st.nextToken().charAt(0)=='1') count++;
			}
		}
		recur(count, 0);
		bw.write(Integer.toString(answer==26?-1:answer));
		bw.flush();
	}

	static void recur(int cnt, int change){
		if(change>answer) return;
		if(cnt==0){
			answer = Math.min(answer,change);
			return;
		}
		for(int r=0;r<10;r++){
			for(int c=0;c<10;c++){
				if(!map[r][c]) continue;
				int size;
				s : for(size=2;size<=5;size++){
					for(int rr=r;rr<r+size;rr++){
						for(int cc=c;cc<c+size;cc++){
							if(!isIn(rr,cc)||!map[rr][cc]) break s;
						}
					}
				}
				for(int s=size-1;s>0;s--){
					if(paper[s]<=0) continue;
					for(int rr=r;rr<r+s;rr++){
						for(int cc=c;cc<c+s;cc++){
							map[rr][cc] = false;
						}
					}
					paper[s]--;
					recur(cnt-s*s,change+1);
					for(int rr=r;rr<r+s;rr++){
						for(int cc=c;cc<c+s;cc++){
							map[rr][cc] = true;
						}
					}
					paper[s]++;
				}
				return;
			}
		}
	}

	static boolean isIn(int r, int c){
		return 0<=r&&r<10&&0<=c&&c<10;
	}
}