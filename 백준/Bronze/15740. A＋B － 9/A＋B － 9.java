import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken()).add(new BigInteger(st.nextToken()));
        System.out.println(a.toString());
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}