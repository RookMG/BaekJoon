import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String answer;
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
    public void solution(Point p1,Point p2,Point p3,Point p4) throws Exception {
        int product1 = outPdctDirection(p1,p2,p3)*outPdctDirection(p1,p2,p4), product2 = outPdctDirection(p3,p4,p1)*outPdctDirection(p3,p4,p2);
        if((product1<=0&&product2<=0)&&!(product1==0&&product2==0&&!(Math.min(p1.x,p2.x)<=Math.max(p3.x,p4.x)&&Math.min(p3.x,p4.x)<=Math.max(p1.x,p2.x))||!(Math.min(p1.y,p2.y)<=Math.max(p3.y,p4.y)&&Math.min(p3.y,p4.y)<=Math.max(p1.y,p2.y)))){
            answer = "T";
        }
    }
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        Main M = new Main();
        for(int t=1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            answer = "F";
            Point   p1 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())),
                    p2 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            int x1=Integer.parseInt(st.nextToken()),y1=Integer.parseInt(st.nextToken()),x2=Integer.parseInt(st.nextToken()),y2=Integer.parseInt(st.nextToken());
            M.solution(p1,p2,new Point(x1,y1),new Point(x2,y2));
            M.solution(p1,p2,new Point(x1,y2),new Point(x2,y1));
            if((p1.x-x1)*(p1.x-x2)<=0&&(p1.y-y1)*(p1.y-y2)<=0)answer = "T";
            System.out.println(answer);
        }
    }
}