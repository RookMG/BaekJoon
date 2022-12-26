import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] record = new int[10];
        int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine()), c = Integer.parseInt(br.readLine());
        char[] now = Integer.toString(a*b*c).toCharArray();
        for(int i=0;i<now.length;i++){
            record[now[i]-'0']++;
        }
        for(int i=0;i<10;i++){
            sb.append(record[i]);
            sb.append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}