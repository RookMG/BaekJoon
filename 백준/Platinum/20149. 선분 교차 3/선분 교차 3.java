import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean crossing;
    class Point implements Comparable<Point>{
        public long x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return x==o.x?Long.compare(y, o.y):Long.compare(x, o.x);
		}
    }
    static int outPdctDirection(Point p1, Point p2, Point p3){
        long result = (p3.x-p1.x)*(p1.y-p2.y)-(p1.x-p2.x)*(p3.y-p1.y);
        return Long.compare(result, 0);
    }
    static void printCross(Point p1, Point p2, Point p3, Point p4){
    	double div = (p1.x-p2.x)*(p3.y-p4.y)-(p1.y-p2.y)*(p3.x-p4.x);
    	if(crossing) {
    		sb.append(1).append("\n");
	        if(div!=0) {
	        	sb.append(1.0*((p1.x*p2.y-p1.y*p2.x)*(p3.x-p4.x)-(p3.x*p4.y-p3.y*p4.x)*(p1.x-p2.x))/div).append(" ").append(1.0*((p1.x*p2.y-p1.y*p2.x)*(p3.y-p4.y)-(p3.x*p4.y-p3.y*p4.x)*(p1.y-p2.y))/div).append("\n");
	        }else if(p1.compareTo(p4)==0&&p3.compareTo(p1)<=0){
	        	sb.append(p1.x).append(" ").append(p1.y).append("\n");
	        }else if(p2.compareTo(p3)==0&&p1.compareTo(p3)<=0){
	        	sb.append(p2.x).append(" ").append(p2.y).append("\n");
	        }
    	}else {
    		sb.append(0).append("\n");
    	}
    }
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        Point 	p1 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())),
                p2 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Point 	p3 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())),
                p4 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        Point tmp;
        if(p1.compareTo(p2)>0) {tmp=p1;p1=p2;p2=tmp;}
        if(p3.compareTo(p4)>0) {tmp=p3;p3=p4;p4=tmp;}
        int product1 = outPdctDirection(p1,p2,p3)*outPdctDirection(p1,p2,p4), product2 = outPdctDirection(p3,p4,p1)*outPdctDirection(p3,p4,p2);
        if(product1==0&&product2==0) {crossing = p1.compareTo(p4)<=0&&p2.compareTo(p3)>=0;}
        else {crossing = product1<=0&&product2<=0;}
        printCross(p1,p2,p3,p4);
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}