import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken()), c = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[][] cnt = new long[3][3];
        cnt[0][0] = Integer.parseInt(st.nextToken());
        cnt[1][0] = Integer.parseInt(st.nextToken());
        cnt[0][0] -= cnt[1][1] = Math.min(cnt[0][0],cnt[1][0]);
        cnt[1][0] -= cnt[1][1];
        long answer = 0;
        if(b<c) c=b;
        for(int i=2;i<n;i++){
            cnt[i%3][0] = Integer.parseInt(st.nextToken());
            cnt[(i+2)%3][0] -= cnt[i%3][1] = Math.min(cnt[(i+2)%3][0],cnt[i%3][0]);
            cnt[i%3][0] -= cnt[i%3][1];
            cnt[(i+2)%3][1] -= cnt[i%3][2] = Math.min(cnt[(i+2)%3][1],cnt[i%3][0]);
            cnt[i%3][0] -= cnt[i%3][2];
            answer += cnt[(i+1)%3][0]*b+cnt[(i+1)%3][1]*(b+c)+cnt[(i+1)%3][2]*(b+c+c);
        }
        answer += cnt[(n+1)%3][0]*b+cnt[(n+1)%3][1]*(b+c)+cnt[(n+1)%3][2]*(b+c+c);
        answer += cnt[(n+2)%3][0]*b+cnt[(n+2)%3][1]*(b+c)+cnt[(n+2)%3][2]*(b+c+c);
        bw.write(Long.toString(answer));
        bw.flush();
    }
}