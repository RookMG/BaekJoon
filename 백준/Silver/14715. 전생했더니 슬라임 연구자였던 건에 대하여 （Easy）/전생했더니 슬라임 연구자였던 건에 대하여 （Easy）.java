import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine()), cnt = 0, div = n;
        for(int i=2;i<n;i++){
            if(n%i==0){
                while(div%i==0){
                    cnt++;
                    div/=i;
                }
            }
        }
        System.out.println((int)Math.ceil(Math.log(Math.max(cnt,1))/Math.log(2)));
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}