import java.io.*;
import java.util.*;
public class Main {
    static class Point implements Comparable<Point>{
        public long x, y;
        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            return x==o.x?Long.compare(y, o.y):Long.compare(x, o.x);
        }
    }
    static class Line{
        Point p1, p2;
        Line(long x1, long y1, long x2, long y2){
            p1 = new Point(x1,y1);
            p2 = new Point(x2,y2);
            Point tmp;
            if(p1.compareTo(p2)>0) {tmp=p1;p1=p2;p2=tmp;}
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] graph;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        Line[] l = new Line[N];
        graph = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            l[i] = new Line(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
        }
        for(int i=0;i<N;i++){
            graph[i][i] = 3;
            for(int j=i+1;j<N;j++){
                graph[i][j] = graph[j][i] = isCrossing(l[i],l[j]);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                bw.write(Integer.toString(graph[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static int outPdctDirection(Point p1, Point p2, Point p3){
        long result = (p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p3.y-p1.y);
        return result>0?1:(result<0?-1:0);
    }
    static int isCrossing(Line l1, Line l2){
        return isCrossing(l1.p1,l1.p2,l2.p1,l2.p2);
    }
    static int isCrossing(Point p1,Point p2,Point p3,Point p4) {
        boolean crossing;
        int product1 = outPdctDirection(p1,p2,p3)*outPdctDirection(p1,p2,p4), product2 = outPdctDirection(p3,p4,p1)*outPdctDirection(p3,p4,p2);
        if(product1==0&&product2==0) {crossing = p1.compareTo(p4)<=0&&p2.compareTo(p3)>=0;}
        else {crossing = product1<=0&&product2<=0;}
        if(!crossing) return 0;
        if((p1.x-p2.x)*(p3.y-p4.y)-(p1.y-p2.y)*(p3.x-p4.x)!=0||(p1.compareTo(p4)==0&&p3.compareTo(p1)<=0)||(p2.compareTo(p3)==0&&p1.compareTo(p3)<=0)){
            return product1==0||product2==0?1:2;
        }
        return 3;
    }
}