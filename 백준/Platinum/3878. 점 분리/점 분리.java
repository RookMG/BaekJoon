import java.io.*;
import java.util.*;
public class Main {
    static class Point{
        public long x, y;
        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int test = 0;test<T;test++) {
            st = new StringTokenizer(br.readLine());
            int[] n = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())}, online = {n[0]-2, n[1]-2};
            Deque<Point>[] shell = new Deque[2];
            for(int g=0;g<2;g++) {
                Point[] points = new Point[n[g]];
                shell[g] = new ArrayDeque<>();
                for (int i = 0; i < n[g]; i++) {
                    st = new StringTokenizer(br.readLine());
                    points[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
                }
                Arrays.sort(points, (o1, o2) -> o1.y == o2.y ? Long.compare(o1.x, o2.x) : Long.compare(o1.y, o2.y));
                Arrays.sort(points, 1, n[g], (p1, p2) -> {
                    int product = outProduct(points[0], p1, p2);
                    return product == 0 ? Long.compare(Math.abs(p1.x + p1.y - points[0].x - points[0].y), Math.abs(p2.x + p2.y - points[0].x - points[0].y)) : Integer.compare(0, product);
                });
                shell[g].offerLast(points[0]);
                if(n[g]>1) shell[g].offerLast(points[1]);
                for (int i = 2; i < n[g]; i++) {
                    while (shell[g].size() >= 2) {
                        Point p2 = shell[g].pollLast();
                        Point p1 = shell[g].peekLast();
                        long out = outProduct(p1, p2, points[i]);
                        if (out > 0) {
                            shell[g].offerLast(p2);
                            break;
                        } else if (out == 0) {
                            online[g]--;
                        }
                    }
                    shell[g].offerLast(points[i]);
                }
                while (shell[g].size() >= 2) {
                    Point p2 = shell[g].pollLast();
                    Point p1 = shell[g].peekLast();
                    if (outProduct(p1, p2, points[0]) > 0) {
                        shell[g].offerLast(p2);
                        break;
                    }
                }
                if(online[g] == 0){
                    shell[g].offerLast(points[n[g] - 1]);
                }
            }
            ArrayList<Point> s1 = new ArrayList<>(shell[0]), s2 = new ArrayList<>(shell[1]);
            boolean check = true;
            if(s1.size()>2){
                for(int i=0;i<s2.size();i++){
                    if(inner(s1,s2.get(i))) check = false;
                }
            }
            if(s2.size()>2){
                for(int i=0;i<s1.size();i++){
                    if(inner(s2,s1.get(i))) check = false;
                }
            }
            for(int i=0;i<s1.size();i++){
                for(int j=0;j<s2.size();j++){
                    if(crossing(s1.get(i),s1.get((i+1)%s1.size()),s2.get(j),s2.get((j+1)%s2.size()))) check = false;
                }
            }
            sb.append(check?"YES\n":"NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static int outProduct(Point p1, Point p2, Point p3){
        long pdt =  (p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p3.y-p1.y);
        return Long.compare(pdt,0);
    }
    static boolean crossing(Point p1, Point p2, Point p3, Point p4){
        int pdt1 = outProduct(p1,p2,p3)*outProduct(p1,p2,p4), pdt2 = outProduct(p3,p4,p1)*outProduct(p3,p4,p2);
        if(pdt1==0&&pdt2==0) return !(Math.max(p1.x,p2.x)<Math.min(p3.x,p4.x)||Math.max(p3.x,p4.x)<Math.min(p1.x,p2.x))&&!(Math.max(p1.y,p2.y)<Math.min(p3.y,p4.y)||Math.max(p3.y,p4.y)<Math.min(p1.y,p2.y));
        return pdt1<=0 && pdt2<=0;
    }
    static boolean inner(ArrayList<Point> hull, Point p){
        int pdt = outProduct(hull.get(0),hull.get(1),p);
        for(int i=1;i<hull.size();i++){
            if(pdt*outProduct(hull.get(i),hull.get((i+1)%hull.size()),p)<=0) return false;
        }
        return true;
    }
}