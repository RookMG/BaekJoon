import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fill = new int[n];
        fill[0]=1;
        if(n!=1){
            fill[1]=2;
        }
        for(int i=2;i<n;i++){
            fill[i]=(fill[i-2]+fill[i-1])%10007;
        }
        System.out.println(fill[n-1]%10007);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}