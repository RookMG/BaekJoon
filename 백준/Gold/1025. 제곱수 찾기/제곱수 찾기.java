import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C, ans = -1;
    static HashSet<Integer> sq = new HashSet<>();
    public static void main(String[] args) throws Exception {
        for(int i=0;i<31623;i++) sq.add(i*i);
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][];
        for(int r=0;r<R;r++) map[r] = br.readLine().toCharArray();
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                for(int dr = -R+1;dr<R;dr++){
                    for(int dc = -C+1;dc<C;dc++){
                        if(dr==0&&dc==0){
                            update(map[r][c]-'0');
                            continue;
                        }
                        sb.setLength(0);
                        int rr = r, cc = c;
                        while(isIn(rr,cc)){
                            update(Integer.parseInt(sb.append(map[rr][cc]).toString()));
                            rr += dr;
                            cc += dc;
                        }
                    }
                }
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }

    static void update(int num){
        if(sq.contains(num)) ans = Math.max(ans,num);
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}