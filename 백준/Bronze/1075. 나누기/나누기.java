import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        sb.append(br.readLine());
        sb.setLength(sb.length()-2);
        sb.append("00");
        int n = Integer.parseInt(sb.toString()),div = Integer.parseInt(br.readLine());
        sb.setLength(0);
        for(int i=0;i<100;i++){
            if((n+i)%div==0){
                sb.append(i);
                break;
            }
        }
        if(sb.length()==1){
            sb.insert(0,"0");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}