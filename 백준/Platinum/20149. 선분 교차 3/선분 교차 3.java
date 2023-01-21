import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    class Point{
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
    static double[] findCross(Point p1, Point p2, Point p3, Point p4){
        double[] cross = new double[2];
        cross[0] = 1.0*((p1.x*p2.y-p1.y*p2.x)*(p3.x-p4.x)-(p3.x*p4.y-p3.y*p4.x)*(p1.x-p2.x))/((p1.x-p2.x)*(p3.y-p4.y)-(p1.y-p2.y)*(p3.x-p4.x));
        cross[1] = 1.0*((p1.x*p2.y-p1.y*p2.x)*(p3.y-p4.y)-(p3.x*p4.y-p3.y*p4.x)*(p1.y-p2.y))/((p1.x-p2.x)*(p3.y-p4.y)-(p1.y-p2.y)*(p3.x-p4.x));
        return cross;
    }
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        Point p1 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())),
                p2 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Point p3 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())),
                p4 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        int product1 = outPdctDirection(p1,p2,p3)*outPdctDirection(p1,p2,p4), product2 = outPdctDirection(p3,p4,p1)*outPdctDirection(p3,p4,p2);
        if(product1<=0&&product2<=0) {
            if (product1 == 0 && product2 == 0 && !(Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) && Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x)) || !(Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y) && Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y)))
                sb.append(0).append("\n");
            else{
                sb.append(1).append("\n");
                if(!(product1 == 0 && product2 == 0)){
                    double[] cross = findCross(p1,p2,p3,p4);
                    sb.append(cross[0]).append(" ").append(cross[1]).append("\n");
                }
                else if(Math.min(p3.x,p4.x)==Math.max(p1.x,p2.x)&&Math.min(p3.y,p4.y)==Math.max(p1.y,p2.y)){
                    sb.append(Math.min(p3.x,p4.x)).append(" ").append(Math.min(p3.y,p4.y)).append("\n");
                }else if(Math.min(p1.x,p2.x)==Math.max(p3.x,p4.x)&&Math.min(p1.y,p2.y)==Math.max(p3.y,p4.y)){
                    sb.append(Math.min(p1.x,p2.x)).append(" ").append(Math.min(p1.y,p2.y)).append("\n");
                }else if((p2.x-p1.x)*(p4.y-p3.y)!=(p2.y-p1.y)*(p4.x-p3.x)){
                    double[] cross = findCross(p1,p2,p3,p4);
                    sb.append(cross[0]).append(" ").append(cross[1]).append("\n");
                }
            }
        }
        else
            sb.append(0).append("\n");
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}