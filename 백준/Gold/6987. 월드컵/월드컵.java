import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] data = new int[18];
	static int[][] order = new int[15][2];
	static boolean found;
	public static void main(String[] args) throws Exception {
		int cnt = 0;
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<=5;j++) {
				order[cnt][0] = i;
				order[cnt++][1] = j;
			}
		}
		for(int i=0;i<4;i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<18;j++) {
				sum += data[j] = Integer.parseInt(st.nextToken());
			}
			if(sum!=30) {
				bw.write("0 ");
				continue;
			}
			found = false;
			recur(0);
			bw.write(found?"1 ":"0 ");
		}
		
		bw.write(" ");
		bw.flush();
	}
	static void recur(int count){
		if(found) return;
		if(count==15) {
			found = true;
			return;
		}
		int me = order[count][0], opnt = order[count][1];
		for(int i=0;i<3;i++) {
			if(data[me*3+i]>0&&data[opnt*3+2-i]>0) {
				data[me*3+i]--;data[opnt*3+2-i]--;
				recur(count+1);
				data[me*3+i]++;data[opnt*3+2-i]++;
			}
		}
	}
}