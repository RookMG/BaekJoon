import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine()), answer = 0;
        st = new StringTokenizer(br.readLine());
        int[][] cnt = new int[n][3];
        cnt[0][0] = Integer.parseInt(st.nextToken());
        cnt[1][0] = Integer.parseInt(st.nextToken());
        cnt[0][0] -= cnt[1][1] = Math.min(cnt[0][0],cnt[1][0]);
        cnt[1][0] -= cnt[1][1];
        for(int i=2;i<n;i++){
            cnt[i][0] = Integer.parseInt(st.nextToken());
            cnt[i-1][0] -= cnt[i][1] = Math.min(cnt[i-1][0],cnt[i][0]);
            cnt[i][0] -= cnt[i][1];
            cnt[i-1][1] -= cnt[i][2] = Math.min(cnt[i-1][1],cnt[i][0]);
            cnt[i][0] -= cnt[i][2];
        }
        for(int i=0;i<n;i++){
            answer += cnt[i][0]*3+cnt[i][1]*5+cnt[i][2]*7;
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}