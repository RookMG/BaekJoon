import java.io.*;
import java.util.*;
public class Main {
    static class Point{
        long x, y;
        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int L = Integer.parseInt(br.readLine()), online = L - 2, answer = 0;
        Point[] points = new Point[L];
        Deque<Point> shell = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        Arrays.sort(points, (o1, o2) -> o1.y == o2.y ? Long.compare(o1.x, o2.x) : Long.compare(o1.y, o2.y));
        Arrays.sort(points, 1, L, (p1, p2) -> {
            long product = outProduct(points[0], p1, p2);
            return product == 0 ? Long.compare(Math.abs(p1.x + p1.y - points[0].x - points[0].y), Math.abs(p2.x + p2.y - points[0].x - points[0].y)) : Long.compare(0, product);
        });
        shell.offerLast(points[0]);
        shell.offerLast(points[1]);
        for (int i = 2; i < L; i++) {
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
        if (online == 0) shell.offerLast(points[L - 1]);
        ArrayList<Point> s1 = new ArrayList<>(shell);
        int S = Integer.parseInt(br.readLine());
        for(int i=0;i<S;i++){
            st = new StringTokenizer(br.readLine());
            Point p = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            if(inner(s1,p)) answer++;
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
    static int outProduct(Point p1, Point p2, Point p3){
        double pdt = (p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p3.y-p1.y);
        return Double.compare(pdt,0.0);
    }
    static boolean inner(ArrayList<Point> hull, Point p){
        if(outProduct(hull.get(0),hull.get(1),p)<0) return false;
        if(outProduct(hull.get(0),hull.get(hull.size()-1),p)>0) return false;
        int l = 1, r = hull.size()-1;
        for(;l+1<r;){
            int mid = (l+r)>>1;
            if(outProduct(hull.get(0),hull.get(mid),p)>0){
                l = mid;
            }else{
                r = mid;
            }
        }
        return outProduct(hull.get(l),p,hull.get(r))<=0;
    }
}