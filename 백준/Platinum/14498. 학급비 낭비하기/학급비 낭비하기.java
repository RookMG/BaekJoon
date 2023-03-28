import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MAX_SIZE = 550;
    static StringTokenizer st;
    static ArrayList<Integer>[] link;
    static int[] start;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), answer = 0;
        int[][] data = new int[K][3];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        link = new ArrayList[MAX_SIZE];
        for(int i=0;i<MAX_SIZE;i++) link[i] = new ArrayList<>();
        for(int i=0;i<K;i++){
            for(int j=i+1;j<K;j++){
                if((data[i][0]==data[j][0] || data[i][1]==data[j][1])&&data[i][2]!=data[j][2]){
                    if(data[i][2]==0) link[i].add(j);
                    else link[j].add(i);
                }
            }
        }
        start = new int[MAX_SIZE];
        Arrays.fill(start,-1);
        for(int i=0;i<K;i++){
            visit = new boolean[MAX_SIZE];
            if(match(i)) answer++;
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
    static boolean match(int idx){
        for(int i : link[idx]){
            if(visit[i]) continue;
            visit[i] = true;
            if(start[i]==-1||match(start[i])){
                start[i] = idx;
                return true;
            }
        }
        return false;
    }
}