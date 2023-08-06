import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[] mbti;
    static int[] selected = new int[3];
    static int min;
    public static void main(String[] args) throws Exception {
        for(int T = Integer.parseInt(br.readLine());T>0;T--){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            if(N>32){
                sb.append("0\n");
                continue;
            }
            mbti = new String[N];
            for(int i=0;i<N;i++) mbti[i] = st.nextToken();
            min = 12;
            recur(0,0);
            sb.append(min).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void recur(int depth, int start){
        if(depth==3){
            min = Math.min(min,update());
            return;
        }
        for(int i=start;i<mbti.length;i++){
            selected[depth] = i;
            recur(depth+1,i+1);
        }
    }
    static int update(){
        int ret = 0;
        for(int i=0;i<4;i++){
            if(mbti[selected[0]].charAt(i)==mbti[selected[1]].charAt(i)&&mbti[selected[0]].charAt(i)==mbti[selected[2]].charAt(i)) continue;
            ret += 2;
        }
        return ret;
    }
}