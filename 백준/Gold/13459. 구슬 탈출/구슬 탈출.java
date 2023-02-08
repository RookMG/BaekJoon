import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int R, C;
    static int[][] coords, origin;
    static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static char[][] map;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        coords = new int[2][2]; // redR, redC, blueR, blueC
        map = new char[R][];
        HashSet<String> visit = new HashSet<>();
        for(int i=0;i<R;i++) {
        	map[i] = br.readLine().toCharArray();
        	for(int j=0;j<C;j++) {
        		int idx;
        		if((idx = "RB".indexOf(map[i][j]))>=0) {
        			coords[idx][0] = i;
        			coords[idx][1] = j;
        			map[i][j] = '.';
        		}
        	}
        }
        Deque<int[][]> q = new LinkedList<int[][]>(), nq;
        q.add(coords);
        for(int move=1;move<=10;move++) {
        	nq = new LinkedList<int[][]>();
        	while(!q.isEmpty()) {
        		coords = q.poll();
        		for(int i=0;i<delta.length;i++) {
        			boolean rOut = false, bOut = false;
        			int[][] nCoords = {{coords[0][0],coords[0][1]},{coords[1][0],coords[1][1]}};
        			for(boolean red=true,blue=true;red||blue;) {
        				int nrRed  = nCoords[0][0]+delta[i][0],
        					ncRed  = nCoords[0][1]+delta[i][1],
        					nrBlue = nCoords[1][0]+delta[i][0],
        					ncBlue = nCoords[1][1]+delta[i][1];
        				switch(map[nrRed][ncRed]) {
        					case 'O':
        						rOut = true;
        					case '#':
        						red = false;
        				}
        				if(nrRed==nCoords[1][0]&&ncRed==nCoords[1][1]&&map[nrBlue][ncBlue]=='#')
        					red = false;
        				switch(map[nrBlue][ncBlue]) {
	    					case 'O':
	    						bOut = true;
	    					case '#':
	    						blue = false;
	    				}
        				if(nrBlue==nCoords[0][0]&&ncBlue==nCoords[0][1]&&map[nrRed][ncRed]=='#')
	                		blue = false;
        				if(red) {
	        				nCoords[0][0] = nrRed;
	        				nCoords[0][1] = ncRed;
        				}
        				if(blue) {
	        				nCoords[1][0] = nrBlue;
	        				nCoords[1][1] = ncBlue;
        				}
        			}
        			if(rOut&&!bOut) {
        				System.out.println(1);
        				return;
        			}
        			sb.setLength(0);
        			sb.append(nCoords[0][0]).append(nCoords[0][1]).append(nCoords[1][0]).append(nCoords[1][1]);
        			if(!(rOut||bOut)&&!visit.contains(sb.toString())) {
        				visit.add(sb.toString());
        				nq.add(nCoords);
        			}
        		}
        	}
        	q = nq;
        }
		System.out.println(0);
    }
}