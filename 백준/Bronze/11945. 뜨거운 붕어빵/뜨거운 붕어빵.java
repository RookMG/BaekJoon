import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][];
        for(int r=0;r<R;r++){
            map[r] = br.readLine().toCharArray();
            for(int c=C-1;c>=0;c--){
                sb.append(map[r][c]);
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}