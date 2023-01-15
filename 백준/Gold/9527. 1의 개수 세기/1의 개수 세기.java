import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static long[] bit;
    public long bitCount(long num){
        long answer = num%2;
        for(int i=Long.toBinaryString(10000000000000000L).length();i>0;i--){
            if((num&(1L<<i))>0){
                answer += bit[i-1] + 1 + num - (1L<<i);
                num -= (1L<<i);
            }
        }
        return answer;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
        bit = new long[Long.toBinaryString(10000000000000000L).length()+1];
        bit[0] = 1;
        for(int i=1;i<=Long.toBinaryString(10000000000000000L).length();i++){
            bit[i] = 2*bit[i-1] + (1L<<i);
        }
        System.out.println(bitCount(b)-bitCount(a-1));
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}