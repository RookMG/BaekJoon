import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;
    static boolean crossing, sameline;
    static int answer;
    static HashSet<String> crossPoint;
    static class Point implements Comparable<Point>{
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
    static void addCross(Point p1, Point p2, Point p3, Point p4){
    	double div = (p1.x-p2.x)*(p3.y-p4.y)-(p1.y-p2.y)*(p3.x-p4.x);
    	if(crossing) {
    		sb = new StringBuilder();
    		if(div!=0) {
	        	sb.append((int)(1.0*((p1.x*p2.y-p1.y*p2.x)*(p3.x-p4.x)-(p3.x*p4.y-p3.y*p4.x)*(p1.x-p2.x))/div)).append(" ").append((int)(1.0*((p1.x*p2.y-p1.y*p2.x)*(p3.y-p4.y)-(p3.x*p4.y-p3.y*p4.x)*(p1.y-p2.y))/div));
	        	if(!crossPoint.contains(sb.toString())) {
	        		crossPoint.add(sb.toString());
	        		answer++;
	        	}
	        }else if(p1.compareTo(p4)==0&&p3.compareTo(p1)<=0){
	        	sb.append(p1.x).append(" ").append(p1.y);
	        	if(!crossPoint.contains(sb.toString())) {
	        		crossPoint.add(sb.toString());
	        		answer++;
	        	}
	        }else if(p2.compareTo(p3)==0&&p1.compareTo(p3)<=0){
	        	sb.append(p2.x).append(" ").append(p2.y);
	        	if(!crossPoint.contains(sb.toString())) {
	        		crossPoint.add(sb.toString());
	        		answer++;
	        	}
	        }else {
	        	answer=4;
	        	sameline = true;
	        }
    	}
    }
    public void solution(Point p1, Point p2, Point p3, Point p4) throws Exception {
    	if(sameline) return;
        Point tmp;
        crossing = false;
        if(p1.compareTo(p2)>0) {tmp=p1;p1=p2;p2=tmp;}
        if(p3.compareTo(p4)>0) {tmp=p3;p3=p4;p4=tmp;}
        int product1 = outPdctDirection(p1,p2,p3)*outPdctDirection(p1,p2,p4), product2 = outPdctDirection(p3,p4,p1)*outPdctDirection(p3,p4,p2);
        if(product1==0&&product2==0) {crossing = p1.compareTo(p4)<=0&&p2.compareTo(p3)>=0;}
        else {crossing = product1<=0&&product2<=0;}
        addCross(p1,p2,p3,p4);
    }
    public static void main(String[] args) throws Exception{
    	Main M = new Main();
    	int test = Integer.parseInt(br.readLine());
    	for(int i=0;i<test;i++) {
	    	answer = 0;
	    	sameline = false;
	    	crossPoint = new HashSet<>();
	        st = new StringTokenizer(br.readLine());
	        int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
	        st = new StringTokenizer(br.readLine());
	        Point 	p1 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())),
	                p2 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
	        M.solution(p1,p2,new Point(x1,y1),new Point(x1,y2));
	        M.solution(p1,p2,new Point(x1,y2),new Point(x2,y2));
	        M.solution(p1,p2,new Point(x1,y1),new Point(x2,y1));
	        M.solution(p1,p2,new Point(x2,y1),new Point(x2,y2));
	        System.out.println(answer);
    	}
    }
}