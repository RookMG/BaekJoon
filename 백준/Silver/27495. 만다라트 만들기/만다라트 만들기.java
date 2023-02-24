import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Mid implements Comparable<Mid>{
		String title;
		PriorityQueue<String> pq;
		Mid(String title){
			this.title = title;
			pq = new PriorityQueue<>();
		}
		void add(String child){
			pq.add(child);
		}
		@Override
		public int compareTo(Mid o) {
			return title.compareTo(o.title);
		}
	}
	public static void main(String[] args) throws Exception {
		String[][] map = new String[9][9];
		Mid[] mids = new Mid[8];
		for(int i=0;i<9;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++){
				map[i][j] = st.nextToken();
			}
		}
		int idx = 0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(i!=1||j!=1) {
					mids[idx] = new Mid(map[3 * i + 1][3 * j + 1]);
					for(int r=-1;r<=1;r++){
						for(int c=-1;c<=1;c++){
							if(r!=0||c!=0){
								mids[idx].add(map[3 * i + 1+r][3 * j + 1+c]);
							}
						}
					}
					idx++;
				}
			}
		}

		Arrays.sort(mids);
		for(int i=0;i<8;i++){
			sb.append("#").append(i+1).append(". ").append(mids[i].title).append("\n");
			for(int j=1;j<=8;j++){
				sb.append("#").append(i+1).append("-").append(j).append(". ").append(mids[i].pq.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}
}