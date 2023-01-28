import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        long ans=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){ans+=i;}
        }
        System.out.println(ans*5-24);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}