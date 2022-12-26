import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<5;i++){
            int tmp=Integer.parseInt(st.nextToken());
            total+=(tmp%10)*(tmp%10);
        }
        sb.append(total%10);
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}