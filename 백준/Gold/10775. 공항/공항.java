import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] remain;
	public static void main(String[] args) throws Exception {
		int G = Integer.parseInt(br.readLine()), P = Integer.parseInt(br.readLine()), answer = G;
		remain = new int[G+1];
		for(int i=1;i<=G;i++) remain[i]=i;
		for(int i=0, p;i<P;i++){
			p = findP(Integer.parseInt(br.readLine()));
			if(p==0){
				answer = i;
				break;
			}
			remain[p] = remain[p]==0?0:findP(remain[p]-1);
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static int findP(int num){
		return remain[num] = remain[num]==num?num:findP(remain[num]);
	}
}