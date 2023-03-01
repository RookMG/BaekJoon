import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		long sum = 0L;
		loop:for(int i=0;i<n;i++){
			String line = br.readLine();
			char comm = line.charAt(0);
			long input = Long.parseLong(line.substring(1));
			if(comm=='+') sum+=input;
			else sum-= input;
			long l = 1L<<62;
			for(int j=62;j>=0;j--,l>>=1){
				if((sum&l)!=0L){
					bw.write(Long.toString(l));
					bw.write("\n");
					continue loop;
				}
			}
			bw.write("0");
			bw.write("\n");
		}
		bw.flush();
	}
}