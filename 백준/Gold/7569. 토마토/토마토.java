import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
        int[] dx = {1,-1,0,0,0,0}, dy = {0,0,1,-1,0,0}, dz = {0,0,0,0,1,-1};
        int[][][] box = new int[h][n][m];
        LinkedList<LinkedList<Integer>> q = new LinkedList<>(), nq = new LinkedList<>();
        int remain = 0, time = -1;
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    int num = Integer.parseInt(st.nextToken());
                    box[i][j][k] = num;
                    if(num==0){
                        remain++;
                    }else if(num==1){
                        q.offer(new LinkedList<>());
                        q.getLast().offer(i);
                        q.getLast().offer(j);
                        q.getLast().offer(k);
                    }
                }
            }
        }
        while(!q.isEmpty()){
            time++;
            while(!q.isEmpty()){
                LinkedList<Integer> point = q.pop();
                int x = point.get(0), y = point.get(1), z = point.get(2);
                for(int i=0;i<6;i++){
                    int nx = x + dx[i], ny = y + dy[i], nz = z + dz[i];
                    if((0<=nx&&nx<h&&0<=ny&&ny<n&&0<=nz&&nz<m)&&(box[nx][ny][nz]==0)){
                        box[nx][ny][nz]=1;
                        nq.offer(new LinkedList<>());
                        nq.getLast().offer(nx);
                        nq.getLast().offer(ny);
                        nq.getLast().offer(nz);
                        remain--;
                    }
                }
            }
            q = nq;
            nq = new LinkedList<>();
        }
        System.out.println(remain==0?time:-1);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}