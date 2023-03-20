import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[][] delta = {{0,1},{-1,0},{-1,-1},{0,-1},{1,0},{1,1}};
    static int[][] map = new int[120][120], coord = new int[11000][2];
    static int x, y;
    static int[] cnt = new int[6];
    static boolean[] visit = new boolean[6];
    public static void main(String[] args) throws Exception {
        coord[1][0] = x = 60;
        coord[1][1] = y = 60;
        map[x][y] = 1;
        cnt[1] = 1;
        for(int i=1,r=1;i<=10000;r++){
            i++;
            coord[i][0] = x+=1;
            coord[i][1] = y+=1;
            map[x][y] = search();
            for(int d=0;d<6;d++){
                for(int j=(d==0?1:0);j<r;j++){
                    i++;
                    coord[i][0] = x+=delta[d][0];
                    coord[i][1] = y+=delta[d][1];
                    map[x][y] = search();
                }
            }
        }
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            bw.write(Integer.toString(map[coord[num][0]][coord[num][1]]));
            bw.write("\n");
        }
        bw.flush();
    }
    static int search(){
        Arrays.fill(visit,false);
        for(int d=0;d<6;d++){
            int nx = x+delta[d][0], ny = y+delta[d][1];
            visit[map[nx][ny]] = true;
        }
        int min = 10001;
        for(int i=1;i<=5;i++){
            if(!visit[i]) {
                min = Math.min(min, cnt[i]);
            }
        }
        for(int i=1;i<=5;i++){
            if(!visit[i]&&min==cnt[i]){
                cnt[i]++;
                return i;
            }
        }
        return -1;
    }
}