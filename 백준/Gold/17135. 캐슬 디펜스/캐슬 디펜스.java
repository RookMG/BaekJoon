import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
/**
 * [키워드]
 * 궁수가 있을 수 있는 위치 M 개 중 3개를 선택
 *  	-> 조합
 * 궁수가 공격하는 적에는 우선순위가 있음 : 거리 우선, 거리 동일시 왼쪽부터
 *  	-> BFS
 *  N, M이 15 이하로 매우 작고 수학적인 방법이 잘 떠오르지 않음
 *  	-> 브루트포스
 *
 * [풀이과정]
 * 궁수의 위치 조합마다 시뮬레이션으로 공격한 적을 카운트하고 최댓값 갱신
 * 매번 적이 한 칸씩 내려오지만 이차원 배열을 조작하기 부담스러움
 *  	-> 궁수가 매번 한 칸씩 올라가면 격자판은 그대로 두고 시뮬레이션 가능!
 * 여러 궁수가 같은 적을 대상으로 공격할 수 있음
 *  	-> 공격 대상인 적을 바로 제거하지 않고 모든 궁수의 대상을 탐색한 뒤 일괄 처리
 *
 * [입력]
 * 격자판 행과 열의 수 3 <= N, M <= 15
 * 궁수의 공격 거리 제한 1 <= D <= 10
 * 둘째 줄 부터 격자판의 상태가 주어짐 ( N행 R열 ) : 0은 빈 칸, 1은 적이 있는 칸
 * [출력]
 *
 * @author tngks1995
 * @see https://www.acmicpc.net/problem/17135
 * @performance 13,024KB, 96ms
 * @category 시뮬레이션, BFS, 브루트포스, 구현
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{-1,1},{1,1}};
	static int N, M, D, answer, now, height, nr, nc, total = 0;
	static int[] pos = new int[3];
	static boolean[] visit;
	static boolean stop = false;
	static int[][] map, MAP;
	static Deque<int[]> target = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); D = Integer.parseInt(st.nextToken());
		map = new int[N][M]; MAP = new int[N][M]; visit = new boolean[M];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) if((MAP[i][j] = Integer.parseInt(st.nextToken()))==1) total++;
		}
		total = Math.min(3*N, total);
		combination(3, 0);
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static void combination(int left, int start){
		if(stop) return;
		if(left==0){
			simulation();
			return;
		}
		for(int i=start;i<M;i++){
			if(!visit[i]){
				visit[i] = true;
				pos[3-left] = i;
				combination(left-1,i+1);
				visit[i] = false;
			}
		}
	}
	static boolean check(){
		if(isIn()&&map[nr][nc]==1){
			target.add(new int[]{nr, nc});
			return true;
		}
		return false;
	}
	static boolean isIn(){
	    return 0<=nr&&nr<height&&0<=nc&&nc<M;
	}
	static void simulation(){
		mapCopy();
		now = 0;
		for(height = N;height>0;height--){
			target.clear();
			for(int p:pos){
				loop: for(int d=1;d<=D;d++){
					nr = height-1; nc = p-d+1;
					if(check()) break;
					for(int j=0;j<2;j++) {
						for (int k = 1; k < d; k++) {
							nr += delta[j][0];
							nc += delta[j][1];
							if (check()) break loop;
						}
					}
				}
			}
			while(!target.isEmpty()){
				int tr = target.peek()[0], tc = target.poll()[1];
				if(map[tr][tc]==1){
					map[tr][tc] = 0;
					now++;
				}
			}
		}
		answer = Math.max(answer,now);
		if(answer==total) stop = true;
	}
	static void mapCopy(){
		for(int i=0;i<N;i++) map[i] = Arrays.copyOf(MAP[i],M);
	}
}