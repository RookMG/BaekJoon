import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int[][][] arr = new int[R=Integer.parseInt(st.nextToken())][C=Integer.parseInt(st.nextToken())][2];
        arr[0][0][1] = 1;
        for(int r=0;r<R;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<C;c++) arr[r][c][0] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -Integer.compare(arr[o1[0]][o1[1]][0],arr[o2[0]][o2[1]][0]);
            }
        });
        pq.offer(new int[]{0,0});
        boolean[][] visit = new boolean[R][C];
        while(!pq.isEmpty()){
            int r = pq.peek()[0], c = pq.poll()[1], nr, nc;
            if(visit[r][c]) continue;
            visit[r][c] = true;
            for(int d=0;d<4;d++){
                if(!isIn(nr=r+delta[d][0],nc=c+delta[d][1])||arr[r][c][0]<=arr[nr][nc][0]) continue;
                arr[nr][nc][1] += arr[r][c][1];
                pq.offer(new int[]{nr,nc});
            }
        }
        bw.write(Integer.toString(arr[R-1][C-1][1]));
        bw.flush();
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}