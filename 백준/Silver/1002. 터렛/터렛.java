import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()), r1 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken()), r2 = Integer.parseInt(st.nextToken());
            int dPow = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
            if(dPow==0&&r1==r2) {
                sb.append(r1==r2?-1:1).append("\n");
            }
            else if(dPow>(r1+r2)*(r1+r2) || (dPow<(r1-r2)*(r1-r2))) {
                sb.append(0).append("\n");
            }
            else if(dPow==(r1+r2)*(r1+r2) || (dPow==(r1-r2)*(r1-r2))) {
                sb.append(1).append("\n");
            }
            else {
                sb.append(2).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}