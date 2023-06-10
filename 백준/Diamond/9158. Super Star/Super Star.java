import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            double[][] pnts = new double[N + 1][3];
            double x = 0, y = 0, z = 0, r = 0, alp = 0.1, tmp;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                x += pnts[i][0] = Double.parseDouble(st.nextToken());
                y += pnts[i][1] = Double.parseDouble(st.nextToken());
                z += pnts[i][2] = Double.parseDouble(st.nextToken());
            }
            x /= N;
            y /= N;
            z /= N;
            for (int i = 0, idx; i < 33333; i++) {
                idx = 1;
                r = 0;
                for (int j = 1; j <= N; j++) {
                    if ((tmp = Math.sqrt((x - pnts[j][0]) * (x - pnts[j][0]) + (y - pnts[j][1]) * (y - pnts[j][1]) + (z - pnts[j][2]) * (z - pnts[j][2]))) <= r)
                        continue;
                    r = tmp;
                    idx = j;
                }
                x += (pnts[idx][0] - x) * alp;
                y += (pnts[idx][1] - y) * alp;
                z += (pnts[idx][2] - z) * alp;
                alp *= 0.999;
            }
            if (Math.abs(r) < 1e-7) r = 0;
            sb.append(String.format("%.5f\n", r));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}