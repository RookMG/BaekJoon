import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] parent, population, links;
	static int N, answer = Integer.MAX_VALUE, group, a, b;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1]; population = new int[N+1]; links = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) population[i] = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j = Integer.parseInt(st.nextToken());j>0;j--) links[i] |= 1<<Integer.parseInt(st.nextToken());
		}
		for(group=0;group<1<<N-1;group++) if(validGroup()) updateAnswer(); // 두 그룹이 제대로 나누어져 있다면 인구수 차이 갱신
		bw.write(answer!=Integer.MAX_VALUE?Integer.toString(answer):"-1");
		bw.flush();
	}
	static void makeP(){
		for(int i=1;i<=N;i++){
			parent[i] = i;
		}
	}
	static int findP(int num){
		return parent[num] = (parent[num]==num)?num:findP(parent[num]);
	}
	static boolean validGroup(){
		makeP();
		int count = N;
		for(a=0;a<N-1;a++){
			for(b=a+1;b<N;b++){
				if(inGroup()&&updateP()) count--;
			}
		}
		return count==2;
	}
	static boolean inGroup(){
		return (((group&(1<<a))==0&&(group&(1<<b))==0) // 둘 다 0 그룹에 있거나
				||((group&(1<<a))!=0&&(group&(1<<b))!=0)) // 둘 다 1 그룹에 있는경우
				&&((links[a+1]&(1<<(b+1)))!=0); // 간선으로 이어져있는지 확인
	}
	static boolean updateP(){
		int ap = findP(a+1), bp = findP(b+1);
		if(ap==bp) return false;
		parent[Math.max(ap,bp)]=Math.min(ap,bp);
		return true;
	}
	static void updateAnswer(){
		int now = 0;
		for(int i=0;i<N;i++) now+=(group&(1<<i))==0?population[i+1]:-population[i+1];
		answer = Math.min(answer,Math.abs(now));
	}
}