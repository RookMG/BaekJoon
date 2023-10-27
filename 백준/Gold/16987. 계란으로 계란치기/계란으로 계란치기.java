import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] egg;
    static int N, ans = 0;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        egg = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            egg[i][0] = Integer.parseInt(st.nextToken());
            egg[i][1] = Integer.parseInt(st.nextToken());
        }
        recur(0,0);
        bw.write(Integer.toString(ans));
        bw.flush();
    }
    static void recur(int order, int score){
        if(order==N){
            ans = Math.max(ans, score);
            return;
        }
        if(egg[order][0]<=0){
            recur(order+1,score);
            return;
        }
        boolean visit = false;
        for(int i=0, nscore;i<N;i++){
            if(i==order||egg[i][0]<=0) continue;
            nscore = score;
            if((egg[i][0] -= egg[order][1])<=0) nscore++;
            if((egg[order][0] -= egg[i][1])<=0) nscore++;
            visit = true;
            recur(order+1,nscore);
            egg[i][0] += egg[order][1];
            egg[order][0] += egg[i][1];
        }
        if(!visit) recur(order+1,score);
    }
}