import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int[][] delta = {{-1,0},{0,-1},{1,0},{0,1}}; //↑←↓→
    static int N, answer = Integer.MAX_VALUE;
    static char[][] map;
    static int[][][] visit;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new char[N][];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        visit = new int[N][N][4];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++){
                if(map[i][j]=='#'){
                    map[i][j]='*';
                    for(int d=0;d<4;d++){
                        dfs(i,j,d,0);
                    }
                    break;
                }
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
    static void dfs(int r, int c, int dir, int cost){
        if(visit[r][c][dir]!=0&&visit[r][c][dir]<=cost) return;
        if(cost>=answer) return;
        visit[r][c][dir] = cost+1;
        while(isIn(r+=delta[dir][0],c+=delta[dir][1])){
            switch (map[r][c]){
                case '#':
                    answer = Math.min(answer,cost);
                case '*':
                    return;
                case '!':
                    map[r][c] = '.';
                    dfs(r,c,(dir+1)%4,cost+1);
                    dfs(r,c,(dir+3)%4,cost+1);
                    map[r][c] = '!';
                default:
            }
        }
    }
    static boolean isIn(int nr, int nc){
        return 0<=nr&&nr<N&&0<=nc&&nc<N;
    }
}