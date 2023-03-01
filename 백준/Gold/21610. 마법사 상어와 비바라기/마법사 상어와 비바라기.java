import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[][] delta = {{0,0},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    static int N, M;
    static int[][] map;
    static Deque<int[]> cloud = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cloud.add(new int[]{N-2,0});
        cloud.add(new int[]{N-2,1});
        cloud.add(new int[]{N-1,0});
        cloud.add(new int[]{N-1,1});

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            move(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        long answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) answer += map[i][j];
        }
        bw.write(Long.toString(answer));
        bw.flush();
    }
    static void move(int dir, int vel){
        boolean[][] visit = new boolean[N][N];
        for(int i = cloud.size();i>0;i--) {
            int r = ((cloud.peekFirst()[0]+delta[dir][0]*vel)%N+N)%N, c = ((cloud.pollFirst()[1]+delta[dir][1]*vel)%N+N)%N;
            map[r][c]++;
            visit[r][c] = true;
            cloud.offerLast(new int[]{r,c});
        }
        while(!cloud.isEmpty()){
            int r = cloud.peekFirst()[0], c = cloud.pollFirst()[1];
            for(int i=2;i<=8;i+=2){
                int nr = r+delta[i][0], nc = c+delta[i][1];
                if(isIn(nr,nc)&&map[nr][nc]!=0) map[r][c]++;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                if(!visit[i][j]&&map[i][j]>=2){
                    map[i][j]-=2;
                    cloud.offerLast(new int[]{i,j});
                }
            }
        }
    }
    static boolean isIn(int nr, int nc){
        return 0<=nr&&nr<N&&0<=nc&&nc<N;
    }
}