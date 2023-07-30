import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static final int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), target = Integer.parseInt(br.readLine()), tr = N/2+1, tc = N/2+1;
        int[][] ans = new int[N][N];
        ans[N/2][N/2] = 1;
        for(int r=N/2,c=N/2,now=2,d=0,dsize=0;now<=N*N;){
            for(int i=0;i<dsize&&now<=N*N;i++){
                r+=delta[d][0];
                c+=delta[d][1];
                if((ans[r][c] = now++)!=target) continue;
                tr = r+1;
                tc = c+1;
            }
            if((d=(d+1)%4)%2==1) dsize++;
        }
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++) sb.append(ans[r][c]).append(' ');
            sb.append('\n');
        }
        sb.append(tr).append(' ').append(tc);
        bw.write(sb.toString());
        bw.flush();
    }
}