import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int r=0;r<N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<N;c++){
                map[r][c] = -Integer.parseInt(st.nextToken());
            }
        }
        bw.write(Integer.toString(-recur(0,0,N-1,N-1, N)));
        bw.flush();
    }
    static int recur(int r1, int c1, int r2, int c2, int size){
        if(size==1) return map[r1][c1];
        size>>=1;
        return second(
                recur(r1,c1,(r1+r2)>>1,(c1+c2)>>1,size),
                recur(((r1+r2)>>1)+1,c1,r2,(c1+c2)>>1,size),
                recur(r1,((c1+c2)>>1)+1,(r1+r2)>>1,c2,size),
                recur(((r1+r2)>>1)+1,((c1+c2)>>1)+1,r2,c2,size)
        );
    }
    static int second(int a, int b, int c, int d){
        return Math.max(Math.min(Math.max(a,b),Math.max(c,d)),Math.max(Math.min(a,b),Math.min(c,d)));
    }
}