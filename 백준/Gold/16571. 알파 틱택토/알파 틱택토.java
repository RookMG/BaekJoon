import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int left;
    static int[][] map = new int[3][3], zeros = new int[9][2];
    static boolean visit[];
    public static void main(String[] args) throws Exception{
    	left = 0; //남은 턴 수
        for(int r=0;r<3;r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c=0;c<3;c++) {
        		if(0 == (map[r][c] = Integer.parseInt(st.nextToken()))) {
        			zeros[left][0] = r;
        			zeros[left++][1] = c;
        		}
        	}
        }
        visit = new boolean[left];
        System.out.println(new char[] {'L','D','W'}[1+solve(left)]);
    }
    static int solve(int turns) {
    	if(turns==0) {
    		return 0;
    	}
    	int result = -1;
    	for(int i=0;i<left;i++) {
    		if(!visit[i]) {
    			int r = zeros[i][0], c = zeros[i][1];
    			map[r][c] = 2-turns%2;
    			if(checkWin()) {
        			map[r][c] = 0;
    				return 1;
    			}else {
        			visit[i] = true;
    				result = Math.max(result, -1*solve(turns-1));
        			visit[i] = false;
        			map[r][c] = 0;
    			}
    		}
    	}
    	return result;
    }
    static boolean checkWin() {
    	boolean win = ((map[0][0]==map[1][1])&&(map[0][0]==map[2][2])&&(map[0][0]!=0))||((map[0][2]==map[1][1])&&(map[0][2]==map[2][0])&&(map[0][2]!=0));
    	for(int i=0;i<3;i++) {
    		win |= (map[0][i]==map[1][i])&&(map[0][i]==map[2][i])&&(map[0][i]!=0);
    		win |= (map[i][0]==map[i][1])&&(map[i][0]==map[i][2])&&(map[i][0]!=0);
    	}
    	return win;
    }
}