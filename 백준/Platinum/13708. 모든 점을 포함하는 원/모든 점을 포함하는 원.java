// http://www.sunshine2k.de/coding/java/Welzl/Welzl.html
import java.io.*;
import java.util.*;
public class Main {
    static class Point{
        double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        double dist(Point p){
            return Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y));
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static class Circle{
        Point c;
        double r;
        Circle(double x, double y, double r){
            c = new Point(x,y);
            this.r = r;
        }
        Circle(Point p1, Point p2) {
            c = new Point((p1.x+p2.x)/2,(p1.y+p2.y)/2);
            r = c.dist(p1);
        }
        Circle(Point p1, Point p2, Point p3){
            if(p1.x==p2.x&&p1.x==p3.x&&p1.y==p2.y&&p1.y==p3.y){
                c = new Point(p1.x,p1.y);
                r = 0;
            }
            else if((p3.x-p1.x)*(p1.y-p2.y)==(p1.x-p2.x)*(p3.y-p1.y)){
                if(p1.dist(p2)<p1.dist(p3)){
                    if(p2.dist(p3)<p1.dist(p3)){
                        c = new Point((p1.x+p3.x)/2,(p1.y+p3.y)/2);
                        r = c.dist(p1);
                    }else{
                        c = new Point((p2.x+p3.x)/2,(p2.y+p3.y)/2);
                        r = c.dist(p2);
                    }
                }else{
                    if(p2.dist(p3)<p1.dist(p2)){
                        c = new Point((p1.x+p2.x)/2,(p1.y+p2.y)/2);
                        r = c.dist(p1);
                    }else{
                        c = new Point((p2.x+p3.x)/2,(p2.y+p3.y)/2);
                        r = c.dist(p2);
                    }
                }
            }else {
                c = new Point(
                        (-(p2.x * p2.x - p1.x * p1.x + p2.y * p2.y - p1.y * p1.y) * (p3.y - p2.y) + (p2.x * p2.x - p3.x * p3.x + p2.y * p2.y - p3.y * p3.y) * (p1.y - p2.y))
                                / (2 * (p1.x - p2.x) * (p3.y - p2.y) - 2 * (p3.x - p2.x) * (p1.y - p2.y)),
                        (-(p2.y * p2.y - p1.y * p1.y + p2.x * p2.x - p1.x * p1.x) * (p3.x - p2.x) + (p2.y * p2.y - p3.y * p3.y + p2.x * p2.x - p3.x * p3.x) * (p1.x - p2.x))
                                / (2 * (p1.y - p2.y) * (p3.x - p2.x) - 2 * (p3.y - p2.y) * (p1.x - p2.x))
                );
                r = c.dist(p1);
            }
        }
        boolean isIn(Point p){
            return c.dist(p)<=r;
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "c=" + c +
                    ", r=" + r +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())));
        }
        bw.write(String.format("%.2f",2*mec(points,new ArrayList<>()).r));
        bw.flush();
    }
    static Circle mec(List<Point> P, List<Point> R){
        if(P.isEmpty() || R.size()==3){
            switch (R.size()){
                case 0:return new Circle(0,0,-1);
                case 1:return new Circle(R.get(0).x,R.get(0).y,0);
                case 2:return new Circle(R.get(0),R.get(1));
                case 3:return new Circle(R.get(0),R.get(1),R.get(2));
            }
        }
        Collections.shuffle(P);
        List<Point> subP = P.subList(1,P.size());
        Circle c = mec(subP,new ArrayList<>(R));
        if(!c.isIn(P.get(0))){
            R.add(P.get(0));
            c = mec(subP,new ArrayList<>(R));
        }
        return c;
    }
}