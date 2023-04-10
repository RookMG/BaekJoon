import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		bw.write(Double.toString(235.214583333/Double.parseDouble(br.readLine())));
		bw.flush();
	}
}