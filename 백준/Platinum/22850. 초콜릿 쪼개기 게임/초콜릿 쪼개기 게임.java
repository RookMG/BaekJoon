import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static char[] small = "_00112031103322405223301130211045274011203110332244552".toCharArray(), big = "3301130211045374811203110332244559".toCharArray();
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        bw.write((grundy(N)+grundy(M))==0?"hs":"sh");
        bw.flush();
    }
    static int grundy(int num){
        if(num<54) return small[num]-'0';
        return big[(num+14)%34]-'0';
    }
}