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
		int n = Integer.parseInt(br.readLine());
		Point[] points = new Point[n];
		Deque<Point> shell = new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
		}
		Arrays.sort(points, (o1, o2) -> o1.y==o2.y?Long.compare(o1.x,o2.x):Long.compare(o1.y,o2.y));
		Arrays.sort(points, 1, n, (p1, p2) -> {
			long product = outProduct(points[0],p1,p2);
			return product==0?Long.compare(Math.abs(p1.x+p1.y-points[0].x-points[0].y),Math.abs(p2.x+p2.y-points[0].x-points[0].y)):Long.compare(0,product);
		});
		shell.offerLast(points[0]);
		shell.offerLast(points[1]);
		for(int i=2;i<n;i++){
			while(shell.size()>=2){
				Point p2 = shell.pollLast();
				Point p1 = shell.peekLast();
				if(outProduct(p1,p2,points[i])>0){
					shell.offerLast(p2);
					break;
				}
			}
			shell.offerLast(points[i]);
		}
		while(shell.size()>=2){
			Point p2 = shell.pollLast();
			Point p1 = shell.peekLast();
			if(outProduct(p1,p2,points[0])>0){
				shell.offerLast(p2);
				break;
			}
		}
		bw.write(Integer.toString(shell.size()));
		bw.flush();
	}
}