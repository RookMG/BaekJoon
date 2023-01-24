import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, maxDepth, root;
    static List<List<Integer>> tree;
    static int[] depth, ins;
    static int[][] parents;

    public void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        ins = new int[n+1];
        for(int i=0;i<=n;i++) {
            tree.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            ins[b]++;
        }
        for(int i=1;i<=n;i++){
            if(ins[i]==0){
                root = i;
            }
        }
        depth = new int[n+1]; maxDepth = 0;
        for(int i=1;i<=n;i<<=1){
            maxDepth++;
        }
        parents = new int[n+1][maxDepth];
        findParent(root,1);
        findAncester();


        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        if(depth[a]<depth[b]){
            int tmp = a; a = b; b = tmp; //swap
        }
        for(int j = maxDepth-1;j>=0;j--){
            if(Math.pow(2,j)<= depth[a]-depth[b]){
                a = parents[a][j];
            }
        }
        if(a==b){
            sb.append(a).append("\n");
        }else{
            for(int j = maxDepth-1;j>=0;j--){
                if(parents[a][j]!=parents[b][j]){
                    a = parents[a][j];
                    b = parents[b][j];
                }
            }
            sb.append(parents[a][0]).append("\n");
        }


        System.out.print(sb);
    }

    static void findParent(int node, int d){
        depth[node] = d;
        for(Integer child:tree.get(node)){
            if(depth[child] == 0){
                findParent(child, d+1);
                parents[child][0] = node;
            }
        }
    }

    static void findAncester(){
        for(int i=1;i<maxDepth;i++){
            for(int j=1;j<=n;j++){
                parents[j][i] = parents[parents[j][i-1]][i-1];
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        for(int test = 0;test<T;test++) {
            new Main().solution();
        }
    }
}