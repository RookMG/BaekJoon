import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            char[] line = br.readLine().toCharArray();
            sb.append(line[0]).append(line[line.length-1]).append("\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}