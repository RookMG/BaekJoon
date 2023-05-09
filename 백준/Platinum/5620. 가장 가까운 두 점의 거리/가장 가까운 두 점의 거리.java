// 20053742 번
import java.util.*;
import java.io.*;
class Main {
    static long dist;//0x7fffffff is infinity
    static class Point{
        private int x;
        private int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int compareTo(Point p){
            return x < p.y && y > p.y ? 1 : -1;
        }
    }
    static  ArrayList<Point> Point_arr;
    static TreeSet<Point> candidate = new TreeSet<Point>(new ComparatorSet());
    
	public static void main (String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine()," ");
	    int Num_of_point = Integer.parseInt(st.nextToken());
	    Point_arr = new ArrayList<Point>();
	    
	    for(int i = 0 ; i < Num_of_point ; i++){
	        st = new StringTokenizer(br.readLine()," ");
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        Point_arr.add(new Point(x,y));
	    }
	    Collections.sort(Point_arr, new ComparatorDescending());
	    int start = 0;
	    candidate.add(Point_arr.get(0));
	    candidate.add(Point_arr.get(1));
	    dist = cal_dist(Point_arr.get(0), Point_arr.get(1));
	    for(int i = 2 ; i < Num_of_point ; i++){    
	        Point now = Point_arr.get(i);
	        while(start < i){
	            Point pivot = Point_arr.get(start);
                int temp_dist = pivot.x - now.x;
                if(temp_dist*temp_dist>dist){
                    candidate.remove(pivot);
                    start +=1;
                } else {
                    break;// found the valid x distance
                }
	        }
	        int d = (int) Math.sqrt((double)dist) + 1;
	        Point from = new Point(-10001,now.y-d);
	        Point to = new Point(10001,now.y+d);
	        for(Point point:candidate.subSet(from,to)){
	            long distance = cal_dist(now,point);
	            dist = dist < distance ? dist : distance;
	        }
	        candidate.add(now);
	    }
	    bw.write(String.valueOf(dist));
	    bw.flush();
	    bw.close();
	}
	static class ComparatorDescending implements Comparator<Point> {
	    public int compare(Point p1 , Point p2) {
	        return p1.x-p2.x;
	    }
	}
	static class ComparatorSet implements Comparator<Point>{
	    public int compare(Point p1, Point p2){
	        if(p1.y==p2.y){
	            return p1.x - p2.x;
	        }
	        return p1.y - p2.y;
	    }
	}
	static long cal_dist(Point point1, Point point2){
	    long dis1 = point1.x - point2.x;
	    long dis2 = point1.y - point2.y;
        return dis1*dis1 + dis2*dis2;	    
	}
}