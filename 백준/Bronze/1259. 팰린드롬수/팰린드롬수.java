import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringBuffer sbuf = new StringBuffer(br.readLine());
            if(sbuf.toString().equals("0")){
                break;
            }
            if(sbuf.toString().equals(sbuf.reverse().toString())){
                sb.append("yes\n");
            }else{
                sb.append("no\n");
            }
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}