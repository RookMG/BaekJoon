import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine()), answer = 0;
        String s = br.readLine(), p = "I";
        for(int i=0;i<n;i++)
            p+="OI";
        for(int i=0;i<m-2*n;i++){
            if(p.equals(s.substring(i,i+2*n+1))){
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}