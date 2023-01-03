import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    private static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
    private static void bfs(int x, int y){
        if(board[x][y]){
            change = true;
            board[x][y]=false;
            for(int i=0;i<4;i++){
                int nx = x+dx[i], ny = y+dy[i];
                if((0<=nx)&&(nx<m)&&(0<=ny)&&(ny<n)&&board[nx][ny]){
                    bfs(nx,ny);
                }
            }
        }
        return;
    }
    static int m = 0, n = 0, k = 0, answer = 0;
    static boolean[][] board;
    static boolean change = false;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            answer = 0;
            board = new boolean[m][n]; //true 벌레없는배추
            LinkedList<LinkedList<Integer>> q = new LinkedList<>();
            for(int j=0;j<k;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = true;
                q.offer(new LinkedList<Integer>());
                q.getLast().offer(x);
                q.getLast().offer(y);
            }
            for(int j=0;j<k;j++){
                change = false;
                bfs(q.get(j).get(0),q.get(j).get(1));
                answer+=change?1:0;
            }
            sb.append(answer);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}