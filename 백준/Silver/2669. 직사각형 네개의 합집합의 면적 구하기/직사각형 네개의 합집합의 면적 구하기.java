import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        boolean[][] map = new boolean[101][101];
        int answer = 0;
        for(int i=0;i<4;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            for(int x = a;x<c;x++){
                for(int y=b;y<d;y++){
                    if(!map[x][y]){
                        map[x][y]=true;
                        answer++;
                    }
                }
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}