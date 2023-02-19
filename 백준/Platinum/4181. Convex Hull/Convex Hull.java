import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static class Point{
		public long x, y;
		public Point(long x, long y){
			this.x = x;
			this.y = y;
		}
	}
	static long outProduct(Point p1, Point p2, Point p3){
		return (p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p3.y-p1.y);
	}
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), size = 0;
		long[][] tmp = new long[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken()), y  = Long.parseLong(st.nextToken());
			if(st.nextToken().charAt(0)=='Y'){
				tmp[size][0] = y;
				tmp[size++][1] = x;
			}
		}
		Point[] points = new Point[size];
		for(int i=0;i<size;i++){
			points[i] = new Point(tmp[i][0],tmp[i][1]);
		}
		Arrays.sort(points, (o1, o2) -> o1.y == o2.y ? Long.compare(o1.x, o2.x) : Long.compare(o1.y, o2.y));
		Arrays.sort(points, 1, size, (p1, p2) -> {
			long product = outProduct(points[0], p1, p2);
			return product == 0 ? Long.compare(Math.abs(p1.x + p1.y - points[0].x - points[0].y), Math.abs(p2.x + p2.y - points[0].x - points[0].y)) : Long.compare(product,0);
		});
		bw.write(Integer.toString(size));
		bw.write("\n");

		int last = size-1;
		for(int i = size-1; i>0; i--,last--){
			if(outProduct(points[0],points[i],points[i-1])!=0) break;
		}
		for(int i = 0;i<last;i++){
			bw.write(Long.toString(points[i].y));
			bw.write(" ");
			bw.write(Long.toString(points[i].x));
			bw.write("\n");
		}
		for(int i = last;i<size;i++){
			bw.write(Long.toString(points[size-1+last-i].y));
			bw.write(" ");
			bw.write(Long.toString(points[size-1+last-i].x));
			bw.write("\n");
		}
		bw.flush();
	}
}