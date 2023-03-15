import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visit;
    static int[] link;
    static ArrayList<ArrayList<Integer>> l;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String line;
        while((line=br.readLine())!=null && !line.isEmpty()){
            st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), answer = 0;
            long time = Long.parseLong(st.nextToken()), vel = 1000 * Long.parseLong(st.nextToken());
            time *= time;
            vel *= vel;
            long[][] rats = new long[N + 1][2], holes = new long[M + 1][2];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                rats[i][0] = (long) (1000 * Double.parseDouble(st.nextToken()));
                rats[i][1] = (long) (1000 * Double.parseDouble(st.nextToken()));
            }
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                holes[i][0] = (long) (1000 * Double.parseDouble(st.nextToken()));
                holes[i][1] = (long) (1000 * Double.parseDouble(st.nextToken()));
            }
            l = new ArrayList<>();
            l.add(null);
            for (int i = 1; i <= N; i++) {
                l.add(new ArrayList<>());
                for (int j = 1; j <= M; j++) {
                    long distSquare = (rats[i][0] - holes[j][0]) * (rats[i][0] - holes[j][0]) + (rats[i][1] - holes[j][1]) * (rats[i][1] - holes[j][1]);
                    if (time * vel >= distSquare) {
                        l.get(i).add(j);
                    }
                }
            }
            link = new int[M + 1];
            for (int i = 1; i <= N; i++) {
                visit = new boolean[N + 1];
                if (dfs(i)) answer++;
            }
            bw.write(Integer.toString(N - answer));
            bw.write("\n");
        }
        bw.flush();
    }
    static boolean dfs(int start){
        visit[start] = true;
        for(int work:l.get(start)){
            if(link[work]==0||(!visit[link[work]]&&dfs(link[work]))){
                link[work] = start;
                return true;
            }
        }
        return false;
    }
}