import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int MAX = 100_000_000;
    static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    static int N, R, C, er, ec;
    static char[][] map;
    static int[][] link, dp;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        N = 1;
        map = new char[R][C];
        for(int i=0;i<R;i++){
            char[] line = br.readLine().toCharArray();
            for(int j=0;j<C;j++){
                if(line[j]=='S'){
                    map[i][j] = 'a';
                }else if(line[j]=='X'){
                    map[i][j] = (char)(N+++'a');
                }else{
                    map[i][j] = line[j];
                }
            }
        }
        loop : for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] == 'E'){
                    er = i;
                    ec = j;
                    map[i][j] = (char)(N+'a');
                    break loop;
                }
            }
        }

        link = new int[N+1][N+1];
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++)  Arrays.fill(dp[i], MAX);
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]=='.'||map[i][j]=='#') continue;
                visit = new boolean[R][C];
                Deque<int[]> q = new ArrayDeque<>();
                int cost = 0;
                q.offer(new int[]{i,j});
                visit[i][j] = true;
                while(!q.isEmpty()){
                    int size = q.size();
                    for(int k=0;k<size;k++){
                        int[] now = q.pollFirst();
                        if(map[now[0]][now[1]]!='.'&&map[now[0]][now[1]]!='#'){
                            link[map[now[0]][now[1]]-'a'][map[i][j]-'a'] = cost;
                            link[map[i][j]-'a'][map[now[0]][now[1]]-'a'] = cost;
                        }
                        for(int d=0;d<4;d++){
                            int nr = now[0]+delta[d][0], nc = now[1]+delta[d][1];
                            if(!isIn(nr,nc)||visit[nr][nc]) continue;
                            visit[nr][nc] = true;
                            if(map[nr][nc]!='#') q.offerLast(new int[]{nr,nc});
                        }
                    }
                    cost++;
                }
            }
        }
        visit = new boolean[N][1 << N];
        bw.write(Integer.toString(dfs(0, 1)));
        bw.write("\n");
        bw.flush();
    }
    static int dfs(int now, int bit){
        if(bit+1==(1<<N)) return link[now][N];
        if(visit[now][bit]) return dp[now][bit];
        for(int i=1;i<N;i++){
            if(link[now][i]!=0&&(bit&(1<<i))==0){
                dp[now][bit] = Math.min(dp[now][bit],link[now][i]+dfs(i,bit|(1<<i)));
            }
        }
        visit[now][bit] = true;
        return dp[now][bit];
    }
    static boolean isIn(int nr, int nc){
        return 0<=nr&&nr<R&&0<=nc&&nc<C;
    }
}