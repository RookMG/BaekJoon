import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringBuffer sbuf = new StringBuffer(br.readLine());
            int open=0, close=0;
            for(int j=0;j<sbuf.length();j++){
                char now = sbuf.charAt(j);
                if(now=='('){
                    open++;
                }else{
                    close++;
                    if(close>open)
                        break;
                }
            }
            sb.append(close==open?"YES\n":"NO\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}