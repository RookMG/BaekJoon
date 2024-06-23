// 나건 코드

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int DIV = 1_000_000_007;

    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count;
    static long ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        for(int n=1; n<=N; n++){
            graph[n] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        ans = 1;

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int n=1; n<=N; n++){
            if(visited[n]) continue;

            visited[n] = true;
            count = 1;
            dfs(n);
            ans = ans * count % DIV;
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static void dfs(int num){
        for(int child : graph[num]){
            if(visited[child]) continue;
            visited[child] = true;
            count++;
            dfs(child);
        }
    }
}