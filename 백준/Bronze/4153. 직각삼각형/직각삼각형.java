import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()),b = Integer.parseInt(st.nextToken()),c = Integer.parseInt(st.nextToken());
            if(a==0)
                break;
            int big = a<b?(b<c?c*c:b*b):(a<c?c*c:a*a), total = a*a+b*b+c*c;
            sb.append(big*2==total?"right\n":"wrong\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}