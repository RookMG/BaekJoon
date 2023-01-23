import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    int n, sharkR=0, sharkC=0, size = 2, count = 0;;
    int[][] map, delta = {{-1,0},{1,0},{0,-1},{0,1}};
    boolean[][] visit;
    PriorityQueue<int[]> eatable;

    public boolean isIn(int r, int c){
        return 0<=r&&r<n&&0<=c&&c<n;
    }

    public void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int answer = 0;
        Queue<int[]> toGo = new LinkedList<>(), nextGo;
        eatable = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]==o2[2]) {return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];}
                else{return o1[2]-o2[2];}
            }
        });
        for(int r=0;r<n;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<n;c++){
                if(9 == (map[r][c] = Integer.parseInt(st.nextToken()))){
                    sharkR = r; sharkC = c; map[r][c]=0;
                }
            }
        }
        while(true){
            visit = new boolean[n][n];
            eatable.clear();
            toGo = new LinkedList<>();
            toGo.offer(new int[]{sharkR, sharkC, 0});
            while(eatable.isEmpty()){
                nextGo = new LinkedList<>();
                while(!toGo.isEmpty()){
                    int[] next = toGo.poll();
                    if(map[next[0]][next[1]]<size&&map[next[0]][next[1]]>0){eatable.offer(new int[]{next[0],next[1],next[2]});}
                    for(int i=0;i<4;i++){
                        int nr = next[0]+delta[i][0], nc = next[1]+delta[i][1];
                        if(isIn(nr,nc)&&!visit[nr][nc]&&map[nr][nc]<=size){
                            nextGo.offer(new int[] {nr,nc,next[2]+1});
                            visit[nr][nc] = true;
                        }
                    }
                }
                toGo = nextGo;
                if(nextGo.isEmpty()){
                    break;
                }
            }

            if(eatable.isEmpty()){
                break;
            }
            int[] best = eatable.poll();
            answer += best[2];
            sharkR = best[0];
            sharkC = best[1];
            if(++count==size){
                size++;
                count=0;
            }
            map[sharkR][sharkC]=0;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}