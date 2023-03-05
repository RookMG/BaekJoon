import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        long x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Line{
        Point p1, p2;
        Line(int x1, int y1, int x2, int y2){
            p1 = new Point(x1,y1);
            p2 = new Point(x2,y2);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, group;
    static int[] parent, size;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine()); group = N;
        parent = new int[N]; size = new int[N];
        Line[] l = new Line[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            l[i] = new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            parent[i] = i;
        }
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                int ap = findP(i), bp = findP(j);
                if(ap!=bp&&isCrossing(l[i],l[j])){
                    parent[Math.max(ap,bp)] = Math.min(ap,bp);
                    group--;
                }
            }
        }
        for(int i=0;i<N;i++){
            size[findP(i)]++;
        }
        Arrays.sort(size);
        bw.write(Integer.toString(group));
        bw.write("\n");
        bw.write(Integer.toString(size[N-1]));
        bw.flush();
    }

    static int findP(int a){
        return parent[a] = a==parent[a]?a:findP(parent[a]);
    }
    static int outPdctDirection(Point p1, Point p2, Point p3){
        long result = (p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p3.y-p1.y);
        return result>0?1:(result<0?-1:0);
    }
    static boolean isCrossing(Line l1, Line l2){
        return isCrossing(l1.p1,l1.p2,l2.p1,l2.p2);
    }
    static boolean isCrossing(Point p1,Point p2,Point p3,Point p4) {
        int product1 = outPdctDirection(p1,p2,p3)*outPdctDirection(p1,p2,p4), product2 = outPdctDirection(p3,p4,p1)*outPdctDirection(p3,p4,p2);
        return (product1<=0&&product2<=0)&&!(product1==0&&product2==0&&!(Math.min(p1.x,p2.x)<=Math.max(p3.x,p4.x)&&Math.min(p3.x,p4.x)<=Math.max(p1.x,p2.x))||!(Math.min(p1.y,p2.y)<=Math.max(p3.y,p4.y)&&Math.min(p3.y,p4.y)<=Math.max(p1.y,p2.y)));
    }
}