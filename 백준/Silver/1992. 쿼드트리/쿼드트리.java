import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static char[][] img;
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		img = new char[n][n];
		for(int i=0;i<n;i++) img[i] = br.readLine().toCharArray();
		zipImg(n,0,0,n,n);
		bw.write(sb.toString());
		bw.flush();
	}
	static boolean oneColor(int sr,int sc, int er, int ec) {
		char now = img[sr][sc];
		for(int i=sr;i<er;i++)
			for(int j=sc;j<ec;j++) 
				if(now!=img[i][j]) return false;
		return true;
	}
	static void zipImg(int size, int sr, int sc, int er, int ec) {
		if(size==1||oneColor(sr,sc,er,ec)) {
			sb.append(img[sr][sc]);
			return;
		}
		size/=2;
		sb.append("(");
		zipImg(size,sr,sc,er-size,ec-size);
		zipImg(size,sr,sc+size,er-size,ec);
		zipImg(size,sr+size,sc,er,ec-size);
		zipImg(size,sr+size,sc+size,er,ec);
		sb.append(")");
	}
}