import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] tree, level;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), root = N*(N+1)>>1;
        tree = new int[N+1][2];
        level = new int[N+1][2];
        for(int i=1;i<=N;i++){
            level[i][0] = N;
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
            if((tree[p][0] = l)!=-1) root -= l;
            if((tree[p][1] = r)!=-1) root -= r;
        }
        dfs(root,1,0);
        int max = 1, depth = 1;
        for(int l=2;l<=N;l++){
            if(level[l][1]-level[l][0]<max) continue;
            max = level[l][1]-level[l][0]+1;
            depth = l;
        }
        sb.append(depth).append(' ').append(max);
        bw.write(sb.toString());
        bw.flush();
    }
    static int dfs(int node, int depth, int start){
        int l = tree[node][0]==-1?0:dfs(tree[node][0],depth+1,start), r = tree[node][1]==-1?0:dfs(tree[node][1],depth+1,start+l+1);
        level[depth][0] = Math.min(level[depth][0],start+l+1);
        level[depth][1] = Math.max(level[depth][1],start+l+1);
        return l+r+1;
    }
}