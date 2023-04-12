import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		double x = Double.parseDouble(st.nextToken()), y = Double.parseDouble(st.nextToken()), c = Double.parseDouble(st.nextToken()), m=0;
		for(double l=0,r=Math.min(x,y);r-l>0.0001;){
			m = (l+r)/2;
			double xh = Math.sqrt(x*x-m*m), yh = Math.sqrt(y*y-m*m), h= (xh*yh)/(xh+yh);
			if(h>c) l=m;
			else r=m;
		}
		bw.write(Double.toString(m));
		bw.flush();
	}
}