import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C, RC, G=0;
    static char[][] map, rot;
    static long[][][][] dp;
    static boolean[][][][] visit;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];
        RC = (R+C)>>1;
        for(int r=0;r<R;r++){
            map[r] = br.readLine().toCharArray();
        }
        rot = new char[RC][RC];
        for(int r=0;r<R;r++){
            for(int c=r%2;c<C;c+=2){
                rot[(r+c)>>1][(R-1+c-r)>>1] = map[r][c];
            }
        }
        dp = new long[RC][RC][RC][RC];
        visit = new boolean[RC][RC][RC][RC];
        G^=grundy(0,0,RC-1,RC-1);
        rot = new char[RC][RC];
        for(int r=0;r<R;r++){
            for(int c=1-r%2;c<C;c+=2){
                rot[(r+c)>>1][(R-1+c-r)>>1] = map[r][c];
            }
        }
        dp = new long[RC][RC][RC][RC];
        visit = new boolean[RC][RC][RC][RC];
        G^=grundy(0,0,RC-1,RC-1);
        bw.write(G==0?"cubelover":"koosaga");
        bw.flush();
    }
    static long grundy(int r1, int c1, int r2, int c2){
        if(!isIn(r1,c1)||!isIn(r2,c2)||r1>r2||c1>c2) return 0;
        if(visit[r1][c1][r2][c2]) return dp[r1][c1][r2][c2];
        HashSet<Long> mex = new HashSet<>();
        for(int r=r1;r<=r2;r++){
            for(int c=c1;c<=c2;c++){
                switch (rot[r][c]){
                    case '\u0000':
                        continue;
                    case 'X':
                        mex.add(grundy(r1,c1,r-1,c-1)^grundy(r1,c+1,r-1,c2)^grundy(r+1,c1,r2,c-1)^grundy(r+1,c+1,r2,c2));
                        break;
                    case 'L':
                        mex.add(grundy(r1,c1,r-1,c2)^grundy(r+1,c1,r2,c2));
                        break;
                    case 'R':
                        mex.add(grundy(r1,c1,r2,c-1)^grundy(r1,c+1,r2,c2));
                        break;
                }
            }
        }
        while(mex.contains(dp[r1][c1][r2][c2])) dp[r1][c1][r2][c2]++;
        visit[r1][c1][r2][c2] = true;
        return dp[r1][c1][r2][c2];
    }
    static boolean isIn(int r, int c) {
        return 0 <= r && r < RC && 0 <= c && c < RC;
    }
}