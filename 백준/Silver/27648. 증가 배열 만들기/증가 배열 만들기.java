import java.io.*;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        if(N+M-1>K){
            bw.write("NO");
            bw.flush();
            return;
        }
        bw.write("YES\n");
        for(int i=1;i<=N;i++){
            for(int j=0;j<M;j++){
                bw.write(Integer.toString(i+j));
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}