import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        boolean[][] board = new boolean[101][101];
        int n = Integer.parseInt(br.readLine()), answer = 0;
        for(int i=0, x, y;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            for(int r=x+9;r>=x;r--) {
                for(int c=y+9;c>=y;board[r][c] = true,c--){
                    if(!board[r][c]) answer++;
                }
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}