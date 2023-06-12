import java.io.*;
import java.util.*;
public class Main {
    static class Point{
        long x, y;
        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
        long dist(Point p){
            return (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y);
        }
        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long outProduct(Point p1, Point p2, Point p3){
        return (p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p3.y-p1.y);
    }
    static long outProduct(Point p1, Point p2, Point p3, Point p4){
        return (p4.x+p2.x-p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p4.y+p2.y-p3.y-p1.y);
    }
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken())+4, m = Integer.parseInt(st.nextToken()), online = n-2;
        Point[] points = new Point[n];
        Deque<Point> shell = new ArrayDeque<>();
        for (int i = 0; i < n-4; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        points[n-4] = new Point(0,m);
        points[n-3] = new Point(0,-m);
        points[n-2] = new Point(m,0);
        points[n-1] = new Point(-m,0);
        Arrays.sort(points, (o1, o2) -> o1.y == o2.y ? Long.compare(o1.x, o2.x) : Long.compare(o1.y, o2.y));
        Arrays.sort(points, 1, n, (p1, p2) -> {
            long product = outProduct(points[0], p1, p2);
            return product == 0 ? Long.compare(Math.abs(p1.x + p1.y - points[0].x - points[0].y), Math.abs(p2.x + p2.y - points[0].x - points[0].y)) : Long.compare(0, product);
        });
        shell.offerLast(points[0]);
        shell.offerLast(points[1]);
        for (int i = 2; i < n; i++) {
            while (shell.size() >= 2) {
                Point p2 = shell.pollLast();
                Point p1 = shell.peekLast();
                long out = outProduct(p1, p2, points[i]);
                if (out > 0) {
                    shell.offerLast(p2);
                    break;
                }else if(out==0){
                    online--;
                }
            }
            shell.offerLast(points[i]);
        }
        while (shell.size() >= 2) {
            Point p2 = shell.pollLast();
            Point p1 = shell.peekLast();
            if (outProduct(p1, p2, points[0]) > 0) {
                shell.offerLast(p2);
                break;
            }
        }
        if(online==0) shell.offerLast(points[n-1]);
        ArrayList<Point> cal = new ArrayList<>(shell);
        double ans = 0;
        for(int i=0;i<shell.size()-1;i++){
            for(int j=i+2;j<shell.size();j++){
                long lmax = 0, rmax = 0;
                for(int k=i+1;k<j;k++) lmax = Math.max(lmax,Math.abs(outProduct(cal.get(i),cal.get(k),cal.get(j))));
                for(int k=j+1;k<i+cal.size();k++) rmax = Math.max(rmax,Math.abs(outProduct(cal.get(i),cal.get(k%cal.size()),cal.get(j))));
                ans = Math.max(ans,((lmax+rmax)/4.0)*((lmax+rmax)/4.0));
            }
        }
        bw.write(Double.toString(ans));
        bw.flush();
    }
}