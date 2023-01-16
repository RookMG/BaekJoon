import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
        	System.out.print('*');
        	return;
        }
        int[] dr = {-1,0,1,0},dc = {0,1,0,-1};
        int direction = 0, count = 0,length = 2;
        char[][] screen = new char[4*n-1][4*n-3];
    	Arrays.fill(screen[0],'*');
        for(int i=1;i<4*n-1;i++) {
        	Arrays.fill(screen[i],' ');
        }
        int r = 2*n, c = 2*n-2;
        while(r!=0) {
        	screen[r][c] = '*';
        	r += dr[direction];
        	c += dc[direction];
        	if(++count==length) {
        		count=0;
        		direction = (direction+1)%4;
        		if(direction%2==0) {
        			length+=2;
        		}
        	}
        }
        for(int i=0;i<4*n-1;i++) {
        	if(i==1) {
        		sb.append("*").append("\n");
        	}
        	else {
	        	for(int j=0;j<4*n-3;j++) {
	        		sb.append(screen[i][j]);
	        	}
	        	sb.append("\n");
        	}
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}