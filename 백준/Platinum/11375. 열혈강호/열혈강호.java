import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visit;
    static int[] link;
    static ArrayList<ArrayList<Integer>> l;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), answer = 0;
        l = new ArrayList<>();
        l.add(null);
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            l.add(new ArrayList<>(size));
            for(int j=0;j<size;j++){
                l.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        link = new int[M+1];
        for(int i=1;i<=N;i++){
            visit = new boolean[N+1];
            if(dfs(i)) answer++;
        }
        bw.write(Integer.toString(answer));
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