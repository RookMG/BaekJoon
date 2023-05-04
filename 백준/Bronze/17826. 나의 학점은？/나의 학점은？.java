import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=50;i++) {
            if(Integer.parseInt(st.nextToken())==N){
                bw.write(score(i));
                break;
            }
        }
        bw.flush();
    }
    static String score(int num){
        if(num<6) return "A+";
        if(num<16) return "A0";
        if(num<31) return "B+";
        if(num<36) return "B0";
        if(num<46) return "C+";
        if(num<49) return "C0";
        return "F";
    }
}