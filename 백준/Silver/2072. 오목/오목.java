import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()), answer = -1;
        int[][] board = new int[19][19]; // 0 비어있음 1 흑돌 2 백돌
		int[] lengths = new int[8]; //12시부터 시계방향으로 8방향이 각각 0, 1, 2...
        for(int i=0;i<n;i++) {
        	StringTokenizer	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken())-1,y = Integer.parseInt(st.nextToken())-1;
        	int stone = 1+i%2;
        	board[x][y] = stone;
        	if(i>7&&answer==-1) {
        		Arrays.fill(lengths, 0);
        		for(int j=1;j<=4;j++) {
        			if(x-j>=0&&board[x-j][y]==stone&&lengths[6]==j-1) {lengths[6]++;}
        			if(x+j<19&&board[x+j][y]==stone&&lengths[2]==j-1) {lengths[2]++;}
        			if(y-j>=0&&board[x][y-j]==stone&&lengths[0]==j-1) {lengths[0]++;}
        			if(y+j<19&&board[x][y+j]==stone&&lengths[4]==j-1) {lengths[4]++;}

        			if(x-j>=0&&y-j>=0&&board[x-j][y-j]==stone&&lengths[7]==j-1) {lengths[7]++;}
        			if(x+j<19&&y-j>=0&&board[x+j][y-j]==stone&&lengths[1]==j-1) {lengths[1]++;}
        			if(x+j<19&&y+j<19&&board[x+j][y+j]==stone&&lengths[3]==j-1) {lengths[3]++;}
        			if(x-j>=0&&y+j<19&&board[x-j][y+j]==stone&&lengths[5]==j-1) {lengths[5]++;}
        		}
        		for(int j=0;j<4;j++) {
        			if(lengths[j]+lengths[j+4]==4) {answer = i+1;}
        		}
        	}
        }

        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}