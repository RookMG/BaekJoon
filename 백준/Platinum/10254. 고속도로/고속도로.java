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
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long outProduct(Point p1, Point p2, Point p3){
        return (p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p3.y-p1.y);
    }
    static long outProduct(Point p1, Point p2, Point p3, Point p4){
        return (p4.x+p2.x-p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p4.y+p2.y-p3.y-p1.y);
    }
    public static void main(String[] args) throws Exception {
        for(int t = Integer.parseInt(br.readLine());t>0;t--) {
            int n = Integer.parseInt(br.readLine()), online = n - 2;
            Point[] points = new Point[n];
            Deque<Point> shell = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                points[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            }
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
                    } else if (out == 0) {
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
            if (online == 0) shell.offerLast(points[n - 1]);
            ArrayList<Point> cal = new ArrayList<>(shell);
            long answer = 0;
            int left = 0, right = 1;
            Point p1 = new Point(0, 0), p2 = new Point(0, 0);
            for (int i = 2 * cal.size(); i > 0; i--) {
                long dt = cal.get(left).dist(cal.get(right));
                if (answer < dt) {
                    p1 = cal.get(left);
                    p2 = cal.get(right);
                    answer = dt;
                }
                answer = Math.max(answer, cal.get(left).dist(cal.get(right)));
                if (outProduct(cal.get(left), cal.get((left + 1) % cal.size()), cal.get(right), cal.get((right + 1) % cal.size())) > 0) {
                    right = (right + 1) % cal.size();
                } else {
                    left = (left + 1) % cal.size();
                    if(left==0) break;
                }
                //System.out.println(outProduct(cal.get(left),cal.get((left+1)%cal.size()),cal.get(right),cal.get((right+1)%cal.size())));
            }
            sb.append(p1.x).append(' ').append(p1.y).append(' ').append(p2.x).append(' ').append(p2.y).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}