import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] board = new boolean[101][101];
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine()), answer = 0;
        for(int i=0;i<n;i++) {
	        st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
	        for(int r=0;r<10;r++) {
	        	for(int c=0;c<10;c++) {
	        		if(!board[x+r][y+c]) {
		        		board[x+r][y+c] = true;
		        		answer++;
	        		}
	        	}
	        }
        }
        System.out.print(answer);
    }
}