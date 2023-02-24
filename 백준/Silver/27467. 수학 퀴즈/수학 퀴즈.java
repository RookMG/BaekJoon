import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final long[][] table = {{0,1},{1,0},{-1,-1}};
    public static void main(String[] args) throws Exception{
        long n = Integer.parseInt(br.readLine());
        long[] answer = new long[2];
        st = new StringTokenizer(br.readLine());
        for(long i=0;i<n;i++){
            int idx = (int)(Long.parseLong(st.nextToken())%3);
            answer[0]+=table[idx][0];
            answer[1]+=table[idx][1];
        }
        System.out.printf("%f %f",(float)answer[0],(float)answer[1]);
    }
}