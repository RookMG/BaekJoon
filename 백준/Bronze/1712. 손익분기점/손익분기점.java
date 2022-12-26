import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken()), c=Integer.parseInt(st.nextToken());
        sb.append(b<c?a/(c-b)+1:-1);
        System.out.println(sb);
    }
}