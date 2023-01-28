import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] primes = new boolean[10001];
        Arrays.fill(primes,true);
        primes[1]=false;
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=101;i++) {
            if(primes[i]) {
                for(int j=2*i;j<10001;j+=i) {
                    primes[j]=false;
                }
            }
        }
        int n = Integer.parseInt(br.readLine());
        loop: for(int l = 0;l<n;l++) {
            int a = Integer.parseInt(br.readLine());
            if(a==0) {break;}
            for(int p = a/2;p>1;p--) {
                if(primes[p]&&primes[a-p]) {
                    sb.append(p).append(" ").append(a-p).append("\n");
                    continue loop;
                }
            }
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}