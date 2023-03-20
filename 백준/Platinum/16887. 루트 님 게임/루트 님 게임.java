import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), g = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) g^=grundy(Long.parseLong(st.nextToken()));
        bw.write(g==0?"cubelover":"koosaga");
        bw.flush();
    }
    static int grundy(long num){
        if(num<4L) return 0;
        if(num<16L) return 1;
        if(num<82L) return 2;
        if(num<6724L) return 0;
        if(num<50625L) return 3;
        if(num<2562890625L) return 1;
        return 2;
    }
}