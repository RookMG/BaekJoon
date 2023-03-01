import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, K, answer = 0, idx = 0;
	static final int[][] delta = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static class Fireball{
		int r, c, mass, dir, velocity, index;
		int mergeMass, mergeVelocity, mergeCnt, mergeDir;
		public Fireball(int r, int c, int mass, int velocity, int dir) {
			this.r = r;
			this.c = c;
			this.mass = mass;
			this.velocity = velocity;
			this.dir = dir;
			this.index = ++idx;
			mergeMass = this.mass;
			mergeVelocity = this.velocity;
			mergeCnt = 1;
			mergeDir = (dir&1) + 1;
		}
	}
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
		ArrayList<Fireball> list = new ArrayList<>();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			list.add(new Fireball(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		for(int k=0;k<K;k++){
			Fireball[][] visit = new Fireball[N][N];
			HashSet<Integer> delete = new HashSet<>();
			for(Fireball f : list){
				// System.out.printf("%d %d (%d)-> ",f.r,f.c, f.dir);
				f.r = ((f.r+delta[f.dir][0]*f.velocity)%N+N)%N;
				f.c = ((f.c+delta[f.dir][1]*f.velocity)%N+N)%N;
				// System.out.printf("%d %d\n",f.r,f.c);
				if(visit[f.r][f.c]!=null){
					Fireball tmp = visit[f.r][f.c];
					tmp.mergeMass += f.mass;
					tmp.mergeVelocity += f.velocity;
					tmp.mergeCnt += 1;
					tmp.mergeDir |= (f.dir&1) + 1;
					delete.add(f.index);
					delete.add(tmp.index);
				}
				else visit[f.r][f.c] = f;
			}
			ArrayList<Fireball> nlist = new ArrayList<>();
			for(Fireball f : list){
				if(f.mergeCnt!=1&&f.mergeMass/5!=0){
					int mass = f.mergeMass/5;
					int velocity = f.mergeVelocity/f.mergeCnt;
					int initDir = f.mergeDir==3?1:0;
					for(int i=0;i<4;i++){
						nlist.add(new Fireball(f.r,f.c,mass,velocity,initDir+2*i));
					}
				}
				if(!delete.contains(f.index)) nlist.add(f);
			}
			list = nlist;
		}
		for(Fireball f: list) answer+=f.mass;
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}