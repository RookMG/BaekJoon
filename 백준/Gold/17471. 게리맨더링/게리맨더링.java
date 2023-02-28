import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] parent, population, links;
	static int findP(int num){
		return parent[num] = (parent[num]==num)?num:findP(parent[num]);
	}
	static int N, answer = Integer.MAX_VALUE, group;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1]; population = new int[N+1]; links = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) population[i] = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j = Integer.parseInt(st.nextToken());j>0;j--) links[i] |= 1<<Integer.parseInt(st.nextToken());
		}
		for(group=0;group<1<<N;group++){
			for(int i=1;i<=N;i++){
				parent[i] = i;
			}
			int count = N;
			for(int j=0;j<N-1;j++){
				for(int k=j+1;k<N;k++){
					int ap = findP(j+1), bp = findP(k+1);
					if(inGroup(j,k)&&ap!=bp) {
						parent[Math.max(ap,bp)]=Math.min(ap,bp);
						count--;
					}
				}
			}
			if(count==2) updateAnswer();
		}
		bw.write(answer!=Integer.MAX_VALUE?Integer.toString(answer):"-1");
		bw.flush();
	}
	static boolean inGroup(int a, int b){
		return (((group&(1<<a))==0&&(group&(1<<b))==0)||((group&(1<<a))!=0&&(group&(1<<b))!=0))&&((links[a+1]&(1<<(b+1)))!=0);
	}
	static void updateAnswer(){
		int now = 0;
		for(int i=0;i<N;i++) now+=(group&(1<<i))==0?population[i+1]:-population[i+1];
		answer = Math.min(answer,Math.abs(now));
	}
}