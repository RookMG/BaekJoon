import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static class Point {
		long r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		long dist(Point p) {
			return (r-p.r)*(r-p.r)+(c-p.c)*(c-p.c);
		}
	}

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), idx = 0;
		long min = Long.MAX_VALUE;
		ArrayList<Point> p = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			p.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		for(int i=0;i<n;i++) {
			long nd = 0;
			int nidx = 0;
			for(int j=0;j<n;j++) {
				long d = p.get(i).dist(p.get(j));
				if(d>nd) {
					nd = d;
					nidx = i;
				}
			}
			if(nd<min) {
				min = nd;
				idx = nidx;
			}
		}
		bw.write(Double.toString(p.get(idx).r));bw.write(" ");bw.write(Double.toString(p.get(idx).c));
		bw.flush();
	}
}