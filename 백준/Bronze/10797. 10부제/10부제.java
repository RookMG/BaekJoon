import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine()), answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<5;i++){
            if(n==Integer.parseInt(st.nextToken())) answer++;
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}