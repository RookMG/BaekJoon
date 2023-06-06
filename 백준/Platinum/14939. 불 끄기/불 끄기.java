import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1},{0,0}};
    static boolean[][] map = new boolean[10][10], raw = new boolean[10][10];
    static int ans = 101, cnt;
    public static void main(String[] args) throws Exception {
        for(int i=0,j=0;i<10;++i,j=0) for(char ch:br.readLine().toCharArray()) raw[i][j++]=ch=='O';
        for(int i=1023;i>=0;--i){
            cnt = 0;
            for(int j=0;j<10;j++){
                map[j] = Arrays.copyOf(raw[j],10);
            }
            for(int j=0;j<10;j++){
                if((i&(1<<j))!=0) flip(0,j);
            }
            for(int r=1;r<10;r++){
                for(int c=0;c<10;c++){
                    if(map[r-1][c]) flip(r,c);
                }
            }
            boolean valid = true;
            for(int c=0;c<10;c++) valid &= !map[9][c];
            if(valid) ans = Math.min(ans,cnt);
        }
        bw.write(Integer.toString(ans==101?-1:ans));
        bw.flush();
    }
    static void flip(int r, int c){
        cnt++;
        for(int i=0,nr,nc;i<5;i++){
            nr = r+delta[i][0];
            nc = c+delta[i][1];
            if(!isIn(nr,nc)) continue;
            map[nr][nc] = !map[nr][nc];
        }
    }
    static boolean isIn(int r, int c) {
        return 0 <= r && r < 10 && 0 <= c && c < 10;
    }
}