import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static class Point{
        public long x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int outPdctDirection(Point p1, Point p2, Point p3){
        long result = (p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p3.y-p1.y);
        return result>0?1:(result<0?-1:0);
    }
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        Point p1 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Point p2 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Point p3 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        System.out.println(outPdctDirection(p1,p2,p3));
    }
}