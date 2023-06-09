import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1},{0,0}};
    static boolean[][] map, raw;
    static int N, ans = 400, cnt;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        raw = new boolean[N][N];
        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) raw[i][j]= Integer.parseInt(st.nextToken())==1;
        }
        for(int i=(1<<N)-1;i>=0;--i){
            cnt = 0;
            for(int j=0;j<N;j++){
                map[j] = Arrays.copyOf(raw[j],N);
            }
            for(int j=0;j<N;j++){
                if((i&(1<<j))!=0) flip(0,j);
            }
            for(int r=1;r<N;r++){
                for(int c=0;c<N;c++){
                    if(map[r-1][c]) flip(r,c);
                }
            }
            boolean valid = true;
            for(int c=0;c<N;c++) valid &= !map[N-1][c];
            if(valid) ans = Math.min(ans,cnt);
        }
        bw.write(Integer.toString(ans==400?-1:ans));
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
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}