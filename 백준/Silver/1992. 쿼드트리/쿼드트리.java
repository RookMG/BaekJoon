import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static char[][] img;
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		img = new char[n][n];
		for(int i=0;i<n;i++) img[i] = br.readLine().toCharArray();
		bw.write(zipImg(n,0,0,n,n));
		bw.flush();
	}
	static boolean oneColor(int sr,int sc, int er, int ec) {
		char now = img[sr][sc];
		for(int i=sr;i<er;i++)
			for(int j=sc;j<ec;j++) 
				if(now!=img[i][j]) return false;
		return true;
	}
	static String zipImg(int size, int sr, int sc, int er, int ec) {
		if(size==1||oneColor(sr,sc,er,ec)) return String.valueOf(img[sr][sc]);
		StringBuilder sb = new StringBuilder();
		size/=2;
		sb.append("(").append(zipImg(size,sr,sc,er-size,ec-size)).append(zipImg(size,sr,sc+size,er-size,ec)).append(zipImg(size,sr+size,sc,er,ec-size)).append(zipImg(size,sr+size,sc+size,er,ec)).append(")");
		return sb.toString();
	}
}