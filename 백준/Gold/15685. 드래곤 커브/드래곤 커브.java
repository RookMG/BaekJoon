import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[][] delta = {{0,1},{-1,0},{0,-1},{1,0}}; // →↑←↓
    static boolean[][] visit = new boolean[101][101];;
    static ArrayList<Integer> curve = new ArrayList<>();
    static int N, answer;
    public static void main(String[] args) throws Exception {
        curve.add(0);
        for(int i=1;i<=10;i++){
            for(int j=curve.size()-1;j>=0;j--){
                curve.add((curve.get(j)+1)%4);
            }
        }
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), g = Integer.parseInt(st.nextToken());
            visit[r][c] = true;
            int length = 1<<g;
            for(int j=0;j<length;j++){
                r+=delta[(d+curve.get(j))%4][0];
                c+=delta[(d+curve.get(j))%4][1];
                visit[r][c] = true;
            }
        }
        answer = 0;
        for(int r=1;r<=100;r++){
            for(int c=1;c<=100;c++){
                if(visit[r][c]&&visit[r-1][c]&&visit[r][c-1]&&visit[r-1][c-1]) answer++;
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}