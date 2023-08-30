import java.io.*;
public class Main {
    static final int[][][] block = {{{2,-1},{5,2},{3,-3}},{{6,-1},{3,6},{0,3},{7,0}},{{8,-1},{3,8},{6,3},{0,6},{9,0}},{{10,-1},{7,10},{2,7},{6,2},{0,6},{11,0}},{{12,-1},{5,12},{8,5},{3,8},{9,3},{0,9},{13,0}}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        recur(N,0);
        bw.write(sb.toString());
        bw.flush();
    }
    static void recur(int n, int d){
        if (n <= 7) {
            for (int[] line : block[n-3]) print(d+line[0], d+line[1]);
            return;
        }
        print(d+2*n-2,d-1);
        print(d+3,d+2*n-2);
        recur(n-4,d+4);
        print(d,d+2*n-5);
        print(d+2*n-1,d);
    }
    static void print(int s, int e){
        sb.append(s).append(" to ").append(e).append("\n");
    }
}