import java.io.*;
import java.util.*;
public class Main {
    static class Problem implements Comparable<Problem>{
        long M, P, R;
        double comp;
        public Problem(int m) {
            M = m;
        }
        void setP(int p){
            P = p;
        }
        void setR(int r){
            R = r;
            comp = 1.0*r/P;
        }
        @Override
        public int compareTo(Problem o) {
            return Double.compare(comp,o.comp);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, T;
    static long[][] dp;
    static boolean[][] visit;
    static ArrayList<Problem> input = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        dp = new long[N+1][T+1];
        visit = new boolean[N+1][T+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) input.add(new Problem(Integer.parseInt(st.nextToken())));
        st = new StringTokenizer(br.readLine());
        for(Problem p:input) p.setP(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(Problem p:input) p.setR(Integer.parseInt(st.nextToken()));
        Collections.sort(input);
        bw.write(Long.toString(recur(0,0)));
        bw.flush();
    }
    static long recur(int idx, int t){
        if(idx==N) return 0;
        if(!visit[idx][t]){
            visit[idx][t] = true;
            Problem p = input.get(idx);
            if(t+p.R<=T) dp[idx][t] = Math.max(dp[idx][t],recur(idx+1,t+(int)p.R)+p.M-p.P*(t+p.R));
            dp[idx][t] = Math.max(dp[idx][t],recur(idx+1,t));
        }
        return dp[idx][t];
    }
}