import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();;
    static StringTokenizer st;
    static int minMove = 8;
    static int[][] map = new int[4][4], answer = new int[4][4], record = new int[8][3];
    public static void main(String[] args) throws Exception{
    	for(int i=0;i<4;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<4;j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			answer[i][j] = 1+j+4*i;
    		}
    	}
    	solve(0);
        System.out.print(sb);
    }
    static void solve(int moved) {
    	if(moved>minMove) {
    		return;
    	}
    	int tmp;
    	for(int i=0;i<4;i++) {
    		for(int k=1;k<4;k++) {
    			record[moved][0] = 1;record[moved][1] = i+1;record[moved][2] = k;
    			tmp = map[i][0];
    			for(int j=3;j>0;j--)
    				map[i][(j+1)%4] = map[i][j];
    			map[i][1] = tmp;
    			int predict = minCount();
    			if(predict==0) {
    				if(minMove>moved+1) {
    					minMove = moved+1;
    					sb.setLength(0);
    					sb.append(minMove).append("\n");
    					for(int j=0;j<minMove;j++) {
    						sb.append(record[j][0]).append(" ").append(record[j][1]).append(" ").append(record[j][2]).append("\n");
    					}
    				}
    			}else if(moved+predict<minMove) { //등호?
    				solve(moved+1);
    			}
    		}
			tmp = map[i][0];
			for(int j=3;j>0;j--)
				map[i][(j+1)%4] = map[i][j];
			map[i][1] = tmp;
    	}
    	for(int i=0;i<4;i++) {
    		for(int k=1;k<4;k++) {
    			record[moved][0] = 2;record[moved][1] = i+1;record[moved][2] = k;
    			tmp = map[0][i];
    			for(int j=3;j>0;j--)
    				map[(j+1)%4][i] = map[j][i];
    			map[1][i] = tmp;
    			int predict = minCount();
    			if(predict==0) {
    				if(minMove>moved+1) {
    					minMove = moved+1;
    					sb.setLength(0);
    					sb.append(minMove).append("\n");
    					for(int j=0;j<minMove;j++) {
    						sb.append(record[j][0]).append(" ").append(record[j][1]).append(" ").append(record[j][2]).append("\n");
    					}
    				}
    			}else if(moved+predict<minMove) { //등호?
    				solve(moved+1);
    			}
    		}
    		tmp = map[0][i];
			for(int j=3;j>0;j--)
				map[(j+1)%4][i] = map[j][i];
			map[1][i] = tmp;
    	}
    }
    static int minCount() {
    	int w = 3;
    	for(int i=0;i<4;i++) {
    		for(int j=0;j<4;j++) {
    			if(map[i][j]!=answer[i][j]) w++;
    		}
    	}
    	return w/4;
    }
}