import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static char[][] map = new char[9][9];
    static boolean[][] visit = new boolean[27][9];
    static boolean f = false;
    public static void main(String[] args) throws Exception {
        for(int r=0;r<9;r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<9;c++){
                map[r][c] = st.nextToken().charAt(0);
                if(map[r][c]=='0') continue;
                int num = map[r][c]-'1';
                visit[r][num] = true;
                visit[9+c][num] = true;
                visit[18+r/3*3+c/3][num] = true;
            }
        }
        recur(0,0);
        bw.write(sb.toString());
        bw.flush();
    }
    static void recur(int r, int c) {
        if(f) return;
        if(r==9){
            for(int rr=0;rr<9;rr++){
                for(int cc=0;cc<9;cc++){
                    sb.append(map[rr][cc]).append(' ');
                }
                sb.append('\n');
            }
            f = true;
            return;
        }
        if(c>=9) recur(r+1,0);
        else if(map[r][c]!='0') recur(r,c+1);
        else for(int i=0;i<9;i++){
            if(visit[r][i]||visit[9+c][i]||visit[18+r/3*3+c/3][i]) continue;
            visit[r][i]=visit[9+c][i]=visit[18+r/3*3+c/3][i]=true;
            map[r][c] = (char)('1'+i);
            recur(r,c+1);
            visit[r][i]=visit[9+c][i]=visit[18+r/3*3+c/3][i]=false;
            map[r][c] = '0';
        }
    }
}