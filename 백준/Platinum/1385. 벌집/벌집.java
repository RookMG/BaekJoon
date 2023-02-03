import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] delta = {{1,1},{1,0},{0,-1},{-1,-1},{-1,0},{0,1}};
    static int findR(int cell) {
    	int r = 0, num = 1;
    	for(;num<cell;r++)num+=6*r;
    	return cell==1?0:r-1;
    }
    static int[] findCoord(int cell) {
    	int radius = findR(cell);
    	int[] coord = {-1*radius,0};
    	if(radius == 0) {
    		return coord;
    	}
    	int idx = cell-(3*radius*radius-3*radius+1), div = idx/radius, mod = idx%radius;
    	if(idx == 6*radius)
    		return coord;
    	for(int i=0;i<div;i++) {
    		coord[0] += delta[i][0]*radius;
    		coord[1] += delta[i][1]*radius;
    	}
    	coord[0] += delta[div][0]*mod;
    	coord[1] += delta[div][1]*mod;
    	return coord;
    }
    static int findCell(int[] coord) {
    	int x = coord[0], y = coord[1];
    	if(x==0&&y==0) {
    		return 1;
    	}
    	int radius = coord[0]*coord[1]<0?Math.abs(coord[0]-coord[1]):Math.max(Math.abs(coord[0]),Math.abs(coord[1]));
    	if(x>=0&&y>=0) {
    		return 3*radius*radius-1*radius+1 + x-y;
    	}else if(x<=0&&y<=0) {
    		return 3*radius*radius+2*radius+1 + y-x;
    	}else if(x<0) {
    		return 3*radius*radius-2*radius+1 + x;
    	}else{
    		return 3*radius*radius+radius+1 - x;
    	}
    }
    static int findDir(int[] now, int[] goal) {
    	int ndiag = now[0]+now[1], gdiag = goal[0]+goal[1];
    	if(Math.abs(ndiag-gdiag)>Math.max(Math.abs(now[0]-goal[0]), Math.abs(now[1]-goal[1]))){
    		return ndiag>gdiag?3:0;
    	}else if(Math.abs(now[0]-goal[0]) > Math.abs(now[1]-goal[1])) {
    		return now[0]>goal[0]?4:1;
    	}else {
    		return now[1]>goal[1]?2:5;
    	}
    }
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        int[] ac = findCoord(a), bc = findCoord(b);
        while(findCell(ac)!=b) {
        	System.out.println(findCell(ac));
            //sb.append(findCell(ac)).append(" ");
        	int dir = findDir(ac,bc);
        	ac[0] += delta[dir][0];
        	ac[1] += delta[dir][1];
        }
        sb.append(b);
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}