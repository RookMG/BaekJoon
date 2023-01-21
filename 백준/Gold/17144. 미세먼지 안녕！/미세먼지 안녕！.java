import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int r,c,t, purifier;
    int[][] map, next, wind;
    int[][] delta = {{0,-1},{0,1},{-1,0},{1,0}};
    //좌우상하
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        int answer = 0;
        map = new int[r][c];
        wind = new int[r][c];
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                int cell = Integer.parseInt(st.nextToken());
                // 공기청정기는 세로로 두칸 붙어있고, 맨 왼쪽에 있음
                // 아래쪽 칸의 높이를 purifier에 저장하고 값은 0으로 바꿈
                if(cell==-1){
                    purifier = i;
                    cell = 0;
                }
                //공기청정기 값이 0이기 때문에 총합 = 미세먼지의 양
                answer+=(map[i][j]=cell);
            }
        }
        //공기청정기가 순환하는 길을 미리 배열에 저장해둠
        for(int i=purifier;i<r-1;i++){
            wind[i][0] = 3;
            wind[i+1][c-1] = 2;
        }
        for(int i=purifier-1;i>0;i--){
            wind[i][0] = 2;
            wind[purifier-1-i][c-1] = 3;
        }for(int i=0;i<c-1;i++){
            wind[0][i] = 1;
            wind[r-1][i] = 1;
            wind[purifier-1][1+i] = 0;
            wind[purifier][1+i] = 0;
        }
        
        
        for(int time=0;time<t;time++){
            //확산 단계 : 동시에 모든 미세먼지가 확산되어야 하기 때문에,
            //next라는 배열에 변화량을 저장한 후 나중에 반영했음
            next = new int[r][c];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(map[i][j]>0){
                        int diffusion = map[i][j]/5;
                        for(int k=0;k<4;k++){
                            int ni = i+delta[k][0], nj = j+delta[k][1];
                            if(isIn(ni,nj)){
                                next[ni][nj]+=diffusion;
                                map[i][j]-= diffusion;
                            }
                        }
                    }
                }
            }
            
            //위에서 확산된 먼지량을 반영하는 단계
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    map[i][j]+=next[i][j];
                }
            }
            
            // 아래쪽 순환 : 미리 만들어둔 wind 배열을 따라 한 칸씩 이동시킴
            // 공기청정기 아래에 있는 한칸만큼 먼지가 없어짐
            answer-=map[purifier+1][0];
            for(int i=purifier+1,j=0;!(i==purifier&&j==0);){
                int ni = i + delta[wind[i][j]][0], nj = j + delta[wind[i][j]][1];
                map[i][j] = map[ni][nj];
                i = ni;
                j = nj;
            }
            //위쪽 순환
            answer-=map[purifier-2][0];
            for(int i=purifier-2,j=0;!(i==purifier-1&&j==0);){
                int ni = i + delta[wind[i][j]][0], nj = j + delta[wind[i][j]][1];
                map[i][j] = map[ni][nj];
                i = ni;
                j = nj;
            }
        }
        System.out.println(answer);
    }
    static boolean isIn(int x, int y){
        return 0<=x&&x<r&&0<=y&&y<c&&!(y==0&&(x==purifier||x==purifier-1));
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}