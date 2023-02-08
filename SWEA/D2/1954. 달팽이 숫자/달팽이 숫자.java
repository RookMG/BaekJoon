import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] delta = {{ 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }};
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        for(int test = 1;test<=T;test++) {
            sb.append("#").append(test).append("\n");
            int n = Integer.parseInt(br.readLine()), r=0, c=-1, dir = 0, size = n;
            int[][] map = new int[n][n];
            for(int i=1;i<=n*n;) {
                for(int j=0;j<size;j++) {
                    r+=delta[dir][0];
                    c+=delta[dir][1];
                    map[r][c] = i++;
                }
                dir = (dir+1)%4;
                if(dir%2==1) {size--;}
            }
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}