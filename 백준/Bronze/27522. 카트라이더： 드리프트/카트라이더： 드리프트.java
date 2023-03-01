import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[] scores = {10,8,6,5,4,3,2,1};
	static class Score implements Comparable<Score>{
		String time, team;
		Score(String time, String team){
			this.time = time;
			this.team = team;
		}
		@Override
		public int compareTo(Score o) {
			return time.compareTo(o.time);
		}
	}
	public static void main(String[] args) throws Exception {
		Score[] results = new Score[8];
		int red = 0, blue = 0;
		for(int i=0;i<8;i++) {
			st = new StringTokenizer(br.readLine());
			results[i] = new Score(st.nextToken(),st.nextToken());
		}
		Arrays.sort(results);
		for(int i=0;i<8;i++){
			if(results[i].team.equals("B")) blue+=scores[i];
			else red+=scores[i];
		}
		bw.write(blue>red?"Blue":"Red");
		bw.flush();
	}
}