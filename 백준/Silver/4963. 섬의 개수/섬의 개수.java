import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C;
    static int[][] map, delta = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{1,-1},{-1,1}};
    static boolean isIn(int r, int c){
        return 0<=r&&r<R&&0<=c&&c<C;
    }
    static void dfs(int r, int c){
        map[r][c] = 0;
        for(int i=0;i< delta.length;i++){
            int nr = r+delta[i][0], nc = c+delta[i][1];
            if(isIn(nr,nc)&&map[nr][nc]==1){
                dfs(nr,nc);
            }
        }
    }

    public void solution() throws Exception {
        while(true) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
            if(C==0&&R==0){
                break;
            }
            map = new int[R][C];
            for(int r=0;r<R;r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0;c<C;c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            for(int r=0;r<R;r++){
                for(int c=0;c<C;c++){
                    if(map[r][c]==1){
                        answer++;
                        dfs(r,c);
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}