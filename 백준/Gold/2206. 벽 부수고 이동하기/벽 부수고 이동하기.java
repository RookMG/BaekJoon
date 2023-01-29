import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R,C, answer;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    static char[][] map;
    static boolean[][] visit1, visit2;
    static boolean isIn(int r, int c){
        return 0<=r&&r<R&&0<=c&&c<C;
    }
    static void dfs(int r, int c, int depth, boolean hammer){
        if(r==R-1&&c==C-1){answer = Math.min(answer,depth+1);return;}
        for(int[] d:delta){
            int nr = r+d[0], nc = c+d[1];
            if(isIn(nr,nc)&&depth<R*C){
                if(map[nr][nc]=='0'){
                    dfs(nr,nc,depth+1,hammer);
                }else if(hammer){
                    dfs(nr,nc,depth+1,false);
                }
            }
        }
    }
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        answer = R*C;
        map = new char[R][C];
        visit1 = new boolean[R][C];
        visit2 = new boolean[R][C];
        for(int i=0;i<R;i++){
            map[i] = br.readLine().toCharArray();
        }
        Queue<int[]> q = new LinkedList<>(), nq;
        boolean find = false;
        q.add(new int[]{0,0,1,1});
        while(!q.isEmpty()){
            nq = new LinkedList<>();
            while(!q.isEmpty()) {
                int[] p = q.poll();
                if (p[0] == R - 1 && p[1] == C - 1) {
                    find = true;
                    answer = Math.min(answer, p[2]);
                }
                for (int[] d : delta) {
                    int nr = p[0] + d[0], nc = p[1] + d[1];
                    if (isIn(nr, nc)) {
                        if (map[nr][nc] == '0' && p[3]==0 && !visit1[nr][nc]) {
                            nq.add(new int[]{nr, nc, p[2] + 1, p[3]});
                            visit1[nr][nc] = true;
                        } else if (map[nr][nc] == '0' && p[3]==1 && !visit2[nr][nc]) {
                            nq.add(new int[]{nr,nc,p[2]+1,p[3]});
                            visit2[nr][nc] = true;
                        } else if (map[nr][nc] == '1' && p[3]==1 && !visit2[nr][nc]) {
                            nq.add(new int[]{nr,nc,p[2]+1,0});
                            visit2[nr][nc] = true;
                        }
                    }
                }
            }
            q = nq;
        }
        System.out.println(find?answer:-1);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}