import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int test = 1;test<=T;test++) {
            int sum = 0, min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<7;i++){
                int num = Integer.parseInt(st.nextToken());
                if(num%2==1) continue;
                min = Math.min(min,num);
                sum+= num;
            }
            bw.write(String.format("%d %d\n",sum,min));
        }
        bw.flush();
    }
}