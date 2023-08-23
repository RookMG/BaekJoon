import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        while(true){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), ans = 0;
            if(M==0&&N==0) break;
            parent = new int[M];
            for (int i = 0; i < M; i++) parent[i] = i;
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[2], o2[2]);
                }
            });
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                ans += arr[2];
                pq.offer(arr);
            }
            for (int i = 1; i < M; ) {
                int[] now = pq.poll();
                if (findP(now[0]) == findP(now[1])) continue;
                i++;
                parent[findP(now[0])] = parent[findP(now[1])];
                ans -= now[2];
            }
            sb.append(ans).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static int findP(int num){
        return parent[num] = num==parent[num]?num:findP(parent[num]);
    }
}