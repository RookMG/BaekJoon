import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
/**
 * [핵심키워드]
 * 모든 행동에 동일하게 1초가 걸림 : BFS 탐색이 최소 해 보장
 *
 * [풀이방향]
 * 수빈이가 이동할 수 있는 위치마다 탐색하며 위치와 시간을 큐에 추가
 * 오버플로우를 막기 위해 범위 체크
 * 시간 초과를 막기 위해 방문 체크
 *
 * [입력 사항]
 * 수빈이의 위치 0<=N<=100000, 동생의 위치 0<=K<=100000
 * 디저트의 종류는 1~100이하
 *
 * [출력 사항]
 * 수빈이가 동생을 찾는 가장 빠른 시간 출력
 *
 * @author tngks1995
 * @since 2023. 2. 23.
 * @see https://www.acmicpc.net/problem/1697
 * @performance 14,308 kb, 108 ms
 * @category BFS
 */
public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int END = 200000;
	static int n, k, answer = 0, size;
	static boolean[] visit;
	static Deque<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine()); n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		if(n>=k){
			bw.write(Integer.toString(n-k));
			bw.flush();
			return;
		}
		visit = new boolean[END]; visit[n]=true;
		q.offerLast(n);
		while(!q.isEmpty()) {
			for(size = q.size();size>0;size--){
				int now = q.pollFirst();
				if (now == k) {
					bw.write(Integer.toString(answer));
					bw.flush();
					return;
				}
				now(2 * now);
				next(now + 1);
				next(now - 1);
			}
			answer++;
		}
	}
	static void now(int num){
		if(0<=num&&num<END&&!visit[num]){
			visit[num] = true;
			q.offerFirst(num);
			size++;
		}
	}
	static void next(int num){
		if(0<=num&&num<END&&!visit[num]){
			visit[num] = true;
			q.offerLast(num);
		}
	}
}