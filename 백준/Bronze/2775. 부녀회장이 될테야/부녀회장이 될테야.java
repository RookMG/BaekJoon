import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] apt = new int[15][15];
        for(int i=0;i<15;i++) {
        	apt[0][i]=i;
        }
        for(int i=1;i<15;i++) {
        	for(int j=1;j<15;j++) {
        		apt[i][j]+=apt[i-1][j]+apt[i][j-1];
        	}
        }
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
        	int x = Integer.parseInt(br.readLine()), y = Integer.parseInt(br.readLine());
            System.out.println(apt[x][y]);
        }
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}