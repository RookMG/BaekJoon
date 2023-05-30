import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> r = new ArrayDeque<>(), b = new ArrayDeque<>();
        char[] line = br.readLine().toCharArray();
        for(int i=0;i<N;i++){
            if(line[i]=='R') r.offerLast(i);
            else if(line[i]=='B') b.offerFirst(i);
        }
        int[][] left = new int[4][N];
        for(int i=0;i<4;i++) Arrays.fill(left[i],-1);
        int first = 0, second = 0;
        for(int num:r){
            for(;second<first;second++) left[1][second] = num;
            for(;first<=num;first++) left[0][first] = num;
        }
        first = N-1;
        second = N-1;
        for(int num:b){
            for(;second>first;second--) left[2][second] = num;
            for(;first>=num;first--) left[3][first] = num;
        }
        for(int q=0;q<Q;q++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            if(left[0][s]<left[1][s]&&left[1][s]<left[2][e]&&left[2][e]<left[3][e]&&left[0][s]!=-1){
                sb.append(String.format("%d %d %d %d\n",left[0][s],left[1][s],left[2][e],left[3][e]));
            }else sb.append("-1\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}