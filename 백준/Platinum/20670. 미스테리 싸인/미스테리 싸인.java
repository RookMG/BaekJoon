import java.io.*;
import java.util.*;
public class Main {
    static class Point implements Comparable<Point>{
        double x, y, theta;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
            this.theta = 0.0;
        }
        void move(double dx, double dy){
            x-=dx;
            y-=dy;
            theta = Math.atan2(y,x);
        }

        @Override
        public int compareTo(Point o) {
            return Double.compare(theta,o.theta);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), answer = 0;
        ArrayList<Point> s1 = new ArrayList<>(), s2 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            s1.add(new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            s2.add(new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
        }
        double dx1 = (s1.get(0).x + s1.get(1).x + s1.get(2).x)/3, dy1 = (s1.get(0).y + s1.get(1).y + s1.get(2).y)/3, dx2 = (s2.get(0).x + s2.get(1).x + s2.get(2).x)/3, dy2 = (s2.get(0).y + s2.get(1).y + s2.get(2).y)/3;
        for(Point p:s1) p.move(dx1,dy1);
        for(Point p:s2) p.move(dx2,dy2);
        Collections.sort(s1);
        Collections.sort(s2);
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            double x = Double.parseDouble(st.nextToken()), y = Double.parseDouble(st.nextToken());
            Point p1 = new Point(x,y), p2 = new Point(x,y);
            p1.move(dx1,dy1);
            p2.move(dx2,dy2);
            int pos1 = Collections.binarySearch(s1,p1), pos2 = Collections.binarySearch(s2,p2);
            if(pos1<0) pos1 = -pos1;
            if(pos2<0) pos2 = -pos2;
            if(!inner(s1,p1,pos1)||inner(s2,p2,pos2)) answer++;
//            System.out.println(outProduct(s1.get(pos1%N),s1.get((pos1+1)%N),p1));
//            System.out.println(outProduct(s2.get(pos2%M),s2.get((pos2+1)%M),p2));
//            if(outProduct(s1.get(pos1%N),s1.get((pos1+1)%N),p1)>0||(outProduct(s2.get(pos2%M),s2.get((pos2+1)%M),p2)<=0)) answer++;
        }
        bw.write(answer==0?"YES":Integer.toString(answer));
        bw.flush();
    }
    static int outProduct(Point p1, Point p2, Point p3){
        double pdt = (p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p3.y-p1.y);
        return Double.compare(pdt,0.0);
    }
    static boolean inner(ArrayList<Point> hull, Point p, int idx){
        for(int i=0;i<3;i++){
            if(outProduct(hull.get((idx+hull.size()-2+i)% hull.size()),hull.get((idx+hull.size()-1+i)% hull.size()),p)<=0) return false;
        }
        return true;
    }
}