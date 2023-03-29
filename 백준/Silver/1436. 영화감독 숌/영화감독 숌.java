import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		for(int n = Integer.parseInt(br.readLine()), i = 666, six;;i++){
			if(Integer.toString(i).contains("666")) n--;
			if(n==0){
				bw.write(Integer.toString(i));
				break;
			}
		}
		bw.flush();
	}
}