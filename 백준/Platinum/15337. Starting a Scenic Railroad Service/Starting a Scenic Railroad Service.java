import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] psum = new int[100_001], ssum = new int[100_001], cnt = new int[100_001];
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), p1 = 0, p2 = 0;
        int[][] line = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            cnt[line[i][0] = Integer.parseInt(st.nextToken())]++;
            cnt[line[i][1] = Integer.parseInt(st.nextToken())]--;
            ssum[line[i][0]]++;
            psum[line[i][1]]++;
        }
        for(int i=0;i<100000;i++){
            psum[i+1]+=psum[i];
            ssum[99999-i]+=ssum[100000-i];
            p2 = Math.max(p2,cnt[i+1]+=cnt[i]);
        }
        for(int i=0;i<N;i++) p1 = Math.max(p1,N-psum[line[i][0]]-ssum[line[i][1]]);
        sb.append(p1).append(' ').append(p2);
        bw.write(sb.toString());
        bw.flush();
    }
}