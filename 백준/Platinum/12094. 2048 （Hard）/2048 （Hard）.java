import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, answer = 0, max = 0;
    static int[] dp;
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        dp = new int[11];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) max += map[i][j] = Integer.parseInt(st.nextToken());
        }
        max = Integer.highestOneBit(max);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) answer = Math.max(map[i][j],answer);
        }
        recur(10, map, answer);
        bw.write(Integer.toString(answer));
        bw.flush();
    }
    static void recur(int left, int[][] map, int bmax){
        if(left==0){
            dp[0] = answer = Math.max(answer, bmax);
            return;
        }
        if(answer==max) return;
        int[][] nmap;
        int tmp, height, idx;
        boolean go;

        //left
        nmap = new int[N][N];
        tmp = bmax;
        go = false;
        for(int i=0;i<N;i++){
            height = -1;
            dq.clear();
            for(int j=0;j<N;j++){
                if(map[i][j]!=0){
                    dq.offerLast(map[i][j]);
                    height=j;
                }
            }
            idx = 0;
            while(!dq.isEmpty()){
                int now = dq.pollFirst();
                if(!dq.isEmpty()&&dq.peekFirst()==now){
                    tmp = Math.max(tmp,2*dq.peekFirst());
                    nmap[i][idx++] = 2*dq.pollFirst();
                }else nmap[i][idx++] = now;
            }
            if(height!=idx-1) go=true;
        }
        dp[left] = Math.max(dp[left],tmp);
        if(go&&tmp>=dp[left-1]/2) recur(left-1,nmap, tmp);

        //right
        nmap = new int[N][N];
        tmp = bmax;
        go = false;
        for(int i=0;i<N;i++){
            height = -1;
            dq.clear();
            for(int j=0;j<N;j++){
                if(map[i][j]!=0){
                    dq.offerFirst(map[i][j]);
                    height=j;
                }
            }
            idx = 0;
            while(!dq.isEmpty()){
                int now = dq.pollFirst();
                if(!dq.isEmpty()&&dq.peekFirst()==now){
                    tmp = Math.max(tmp,2*dq.peekFirst());
                    nmap[i][N-1-idx++] = 2*dq.pollFirst();
                }else nmap[i][N-1-idx++] = now;
            }
            if(height!=idx-1) go=true;
        }
        dp[left] = Math.max(dp[left],tmp);
        if(go&&tmp>=dp[left-1]/2) recur(left-1,nmap, tmp);

        //up
        nmap = new int[N][N];
        tmp = bmax;
        go = false;
        for(int i=0;i<N;i++){
            height = -1;
            dq.clear();
            for(int j=0;j<N;j++){
                if(map[j][i]!=0){
                    dq.offerLast(map[j][i]);
                    height=j;
                }
            }
            idx = 0;
            while(!dq.isEmpty()){
                int now = dq.pollFirst();
                if(!dq.isEmpty()&&dq.peekFirst()==now){
                    tmp = Math.max(tmp,2*dq.peekFirst());
                    nmap[idx++][i] = 2*dq.pollFirst();
                }else nmap[idx++][i] = now;
            }
            if(height!=idx-1) go=true;
        }
        dp[left] = Math.max(dp[left],tmp);
        if(go&&tmp>=dp[left-1]/2) recur(left-1,nmap, tmp);

        //down
        nmap = new int[N][N];
        tmp = bmax;
        go = false;
        for(int i=0;i<N;i++){
            height = -1;
            dq.clear();
            for(int j=0;j<N;j++){
                if(map[j][i]!=0){
                    dq.offerFirst(map[j][i]);
                    height=j;
                }
            }
            idx = 0;
            while(!dq.isEmpty()){
                int now = dq.pollFirst();
                if(!dq.isEmpty()&&dq.peekFirst()==now){
                    tmp = Math.max(tmp,2*dq.peekFirst());
                    nmap[N-1-idx++][i] = 2*dq.pollFirst();
                }else nmap[N-1-idx++][i] = now;
            }
            if(height!=idx-1) go=true;
        }
        dp[left] = Math.max(dp[left],tmp);
        if(go&&tmp>=dp[left-1]/2) recur(left-1,nmap, tmp);
    }
}