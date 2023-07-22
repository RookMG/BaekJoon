import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static long sum = 0L, MOD = 1_000_000_007L;
    static ArrayList<ArrayList<Integer>> links = new ArrayList<>();
    static boolean[] visit;
    static long[] pow;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) links.add(new ArrayList<>());
        visit = new boolean[N];
        pow = new long[M+1];
        String[] input = new String[M];
        for(int i=0;i<M;i++) input[i] = br.readLine();
        pow[0] = 1;
        for(int i=1;i<M;i++) pow[i] = pow[i-1]*3%MOD;
        for(int i=M-1, a, b;i>=0;i--){
            st = new StringTokenizer(input[i]);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            links.get(a).add(b);
            links.get(b).add(a);
            Arrays.fill(visit,false);
            visit[0] = true;
            dfs(0);
            if(visit[N-1]){
                links.get(a).remove(links.get(a).size()-1);
                links.get(b).remove(links.get(b).size()-1);
                sum = (sum+pow[i])%MOD;
            }
        }
        bw.write(Long.toString(sum));
        bw.flush();
    }
    static void dfs(int node){
        if(visit[N-1]) return;
        for(int next:links.get(node)){
            if(visit[next]) continue;
            visit[next] = true;
            dfs(next);
        }
    }
}