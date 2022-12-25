import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x=Integer.parseInt(br.readLine()), n = Integer.parseInt(br.readLine()), money = 0;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            money += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
        }
        sb.append(x==money?"Yes":"No");
        System.out.println(sb);
    }
}