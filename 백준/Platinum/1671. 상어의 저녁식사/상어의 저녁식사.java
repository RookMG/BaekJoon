import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visit;
    static int[] link;
    static ArrayList<ArrayList<Integer>> l;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), answer = 0;
        int[][] shark = new int[N+1][3];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                shark[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        l = new ArrayList<>();
        l.add(null);
        for(int i=1;i<=N;i++){
            l.add(new ArrayList<>());
            for(int j=1;j<=N;j++){
                if(i!=j&&shark[i][0]>=shark[j][0]&&shark[i][1]>=shark[j][1]&&shark[i][2]>=shark[j][2]){
                    if(shark[i][0]==shark[j][0]&&shark[i][1]==shark[j][1]&&shark[i][2]==shark[j][2]&&i<j)
                        continue;
                    l.get(i).add(j);
                }
            }
        }
        link = new int[N+1];
        for(int i=1;i<=N;i++){
            for(int j=0;j<2;j++) {
                visit = new boolean[N + 1];
                if (dfs(i)) answer++;
            }
        }
        bw.write(Integer.toString(N-answer));
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