import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C, ans = 0, left = 0;
    static int[][] map;
    static int[][] cnt;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visit = new boolean[R][C];
        for(int r=0;r<R;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<C;c++){
                if((map[r][c] = Integer.parseInt(st.nextToken()))==1) left++;
            }
        }
        ArrayDeque<int[]> dq = new ArrayDeque<>(), oneq = new ArrayDeque<>();
        dq.offer(new int[]{0,0});
        visit[0][0] = true;
        for(;!dq.isEmpty()&&left>0;ans++){
            cnt = new int[R][C];
            for(int s = dq.size();s>0;s--){
                int[] now = dq.pollFirst();
                for(int d=0;d<4;d++){
                    int nr = now[0]+delta[d][0], nc = now[1]+delta[d][1];
                    if(!isIn(nr,nc)||visit[nr][nc]) continue;
                    if(map[nr][nc]==0){
                        visit[nr][nc] = true;
                        dq.offerFirst(new int[]{nr,nc});
                        s++;
                    }else{
                        if(cnt[now[0]][now[1]]==0) dq.offerLast(now);
                        if(cnt[nr][nc]==0) oneq.offerLast(new int[]{nr,nc});
                        cnt[now[0]][now[1]]+=1;
                        cnt[nr][nc]+=1;
                    }
                }
            }
            for(;!oneq.isEmpty();){
                int[] one = oneq.pollFirst();
                if(cnt[one[0]][one[1]]<2) continue;
                map[one[0]][one[1]] = 0;
                left--;
                visit[one[0]][one[1]] = true;
                dq.offerLast(one);
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
    static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}