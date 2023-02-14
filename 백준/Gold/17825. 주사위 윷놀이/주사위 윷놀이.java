import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int start = 4, answer = 0;
    static int[] moves = new int[10], position = {0,0,0,0};
    static int[][] midway = {{13,22,23,29,30,31},{16,23,29,30,31,20},{19,29,30,31,20,32},{22,25,29,30,31,20},{24,29,30,31,20,32},{28,27,28,29,30,31},{27,28,29,30,31,20},{26,29,30,31,20,32},{25,30,31,20,32,32},{30,31,20,32,32,32},{35,20,32,32,32,32}};
    static boolean[] visit = new boolean[32];
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<10;i++) {
        	moves[i] = Integer.parseInt(st.nextToken());
        }
        find(0,0);
        System.out.print(answer);
    }
    static void find(int count, int point) {
    	if(count==10) {
    		answer = Math.max(answer, point);
    		return;
    	}
		for(int j=0;j<4;j++) {
			int now = position[j], next = now+moves[count];
			if(now == 32) {
				continue;
			}
			if(now==5) {
				next = new int[] {5,21,22,23,29,30}[moves[count]];
				goNext(now, next, j, count, point);
			}else if(now==10) {
				next = new int[] {10,24,25,29,30,31}[moves[count]];
				goNext(now, next, j, count, point);
			}else if(now==15) {
				next = new int[] {15,26,27,28,29,30}[moves[count]];
				goNext(now, next, j, count, point);
			}else if(now == 20) {
				next = 32;
				goNext(now, next, j, count, point);
			}else if(now == 0) {
				goNext(now, next, j, count, point);
			}else if(position[j]<20) {
				if(next>20) next = 32;
				goNext(now, next, j, count, point);
			}else {
				next = midway[now-21][moves[count]];
				goNext(now, next, j, count, point);
			}
		}
    }
    static int calcPoint(int next) {
		if(next<=20) {
			return next*2;
		}else if(next==32) {
			return 0;
		}else {
			return midway[next-21][0];
		}
    }
    static void goNext(int now, int next, int j, int count, int point) {
    	if(next == 32) {
			position[j] = 32;
			visit[now] = false;
			find(count+1,point);
			visit[now] = true;
			position[j] = now;
		}else if(!visit[next]) {
			visit[next] = true;
			visit[now] = false;
			position[j] = next;
			find(count+1,point+calcPoint(next));
			visit[next] = false;
			visit[now] = true;
			position[j] = now;
		}
    }
}