import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C, P;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int[] limits = new int[P], cnt = new int[P];
        ArrayDeque<int[]>[] dqs = new ArrayDeque[P];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<P;i++){
            limits[i] = Integer.parseInt(st.nextToken());
            dqs[i] = new ArrayDeque<>();
        }
        char[][] map = new char[R][];
        for(int r=0;r<R;r++){
            map[r] = br.readLine().toCharArray();
            for(int c=0;c<C;c++){
                if(map[r][c]<'1'||map[r][c]>'9') continue;
                dqs[map[r][c]-'1'].offerLast(new int[]{r, c});
                cnt[map[r][c]-'1']++;
            }
        }
        for(boolean progress = true;progress;){
            progress=false;
            for(int p=1;p<=P;p++){
                for(int l=0;l<limits[p-1]&&dqs[p-1].size()>0;l++){
                    for(int s=dqs[p-1].size();s>0;s--){
                        int[] now = dqs[p-1].pollFirst();
                        for(int d=0;d<delta.length;d++){
                            int nr = now[0]+delta[d][0], nc = now[1]+delta[d][1];
                            if(!isIn(nr,nc)||map[nr][nc]!='.') continue;
                            progress = true;
                            dqs[p-1].offerLast(new int[]{nr,nc});
                            map[nr][nc] = '#';
                            cnt[p-1]++;
                        }
                    }
                }
            }
        }
        for(int i:cnt) sb.append(i).append(' ');
        bw.write(sb.toString());
        bw.flush();
    }
    static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}