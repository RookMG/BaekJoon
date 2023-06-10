import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        double[][] pnts = new double[N+1][3];
        double r = 0, alp, tmp, ans = 1000000;
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            pnts[0][0] += pnts[i][0] = Double.parseDouble(st.nextToken());
            pnts[0][1] += pnts[i][1] = Double.parseDouble(st.nextToken());
            pnts[0][2] += pnts[i][2] = Double.parseDouble(st.nextToken());
        }
        pnts[0][0]/=N;
        pnts[0][1]/=N;
        pnts[0][2]/=N;
        for(int side=0;side<3;side++) {
            alp=0.1;
            double s1 = pnts[0][side], s2 = pnts[0][(side+1)%3];
            for (int i = 0, idx; i < 33333; i++) {
                idx = 1;
                r = 0;
                for (int j = 1; j <= N; j++) {
                    if ((tmp = Math.sqrt((s1 - pnts[j][side]) * (s1 - pnts[j][side]) + (s2 - pnts[j][(side+1)%3]) * (s2 - pnts[j][(side+1)%3]))) <= r)
                        continue;
                    r = tmp;
                    idx = j;
                }
                s1 += (pnts[idx][side] - s1) * alp;
                s2 += (pnts[idx][(side+1)%3] - s2) * alp;
                alp *= 0.999;
            }
            if (Math.abs(r) < 1e-7) r = 0;
            ans = Math.min(ans,2*r);
        }
        bw.write(Double.toString(ans));
        bw.flush();
    }
}