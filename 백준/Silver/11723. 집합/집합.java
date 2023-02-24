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

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		boolean[] set = new boolean[21];
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			char ch = st.nextToken().charAt(1);
			switch (ch){
				case 'd':
					set[Integer.parseInt(st.nextToken())] = true;
					break;
				case 'e':
					set[Integer.parseInt(st.nextToken())] = false;
					break;
				case 'h':
					bw.write(set[Integer.parseInt(st.nextToken())]?'1':'0');
					bw.write("\n");
					break;
				case 'o':
					int num = Integer.parseInt(st.nextToken());
					set[num] = !set[num];
					break;
				case 'l':
					Arrays.fill(set,true);
					break;
				case 'm':
					Arrays.fill(set,false);
					break;
			}
		}
		bw.flush();
	}
}