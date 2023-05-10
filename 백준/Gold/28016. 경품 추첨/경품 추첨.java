import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int R, C, sc;
    static int[][] map;
    static double[][] result;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        result = new double[R][C];
        for(int r=0;r<R;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<C;c++){
                if(2==(map[r][c] = Integer.parseInt(st.nextToken()))){
                    result[r][c] = 1.0;
                }
            }
        }
        for(int r=0;r<R-1;r++){
            for(int c=0;c<C;c++){
                if(map[r+1][c]!=1){
                    result[r+1][c]+=result[r][c];
                }else{
                    boolean left = map[r][c-1]!=1&&map[r+1][c-1]!=1, right = map[r][c+1]!=1&&map[r+1][c+1]!=1;
                    if(left){
                        result[r+1][c-1]+=result[r][c]/2;
                    }
                    if(right){
                        result[r+1][c+1]+=result[r][c]/2;
                    }
                }
            }
        }
        int answer = -1;
        double cnt = 0.0;
        for(int c=0;c<C;c++){
            if(result[R-1][c]>cnt){
                cnt = result[R-1][c];
                answer = c;
            }
        }
        bw.write(Long.toString(answer));
        bw.flush();
    }
}