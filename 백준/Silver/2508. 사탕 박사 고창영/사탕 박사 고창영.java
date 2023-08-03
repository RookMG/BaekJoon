import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    public static void main(String[] args) throws Exception {
        for(int T = Integer.parseInt(br.readLine());T>0;T--){
            br.readLine();
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int ans = 0;
            char[][] map = new char[R][];
            for(int r=0;r<R;r++) map[r] = br.readLine().toCharArray();
            for(int r=0;r<R;r++){
                for(int c=0;c<C;c++){
                    if(map[r][c]!='o') continue;
                    if((isIn(r-1,c)&&map[r-1][c]=='v'&&isIn(r+1,c)&&map[r+1][c]=='^')
                        ||(isIn(r,c-1)&&map[r][c-1]=='>'&&isIn(r,c+1)&&map[r][c+1]=='<')) ans++;
                }
            }
            sb.append(ans).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}