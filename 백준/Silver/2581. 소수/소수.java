import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine());
        int sum = 0, first = 0;
        boolean[] primes = new boolean[b+1];
        Arrays.fill(primes,true);
        primes[1]=false;
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=(int)Math.sqrt(b);i++) {
            if(primes[i]) {
                for(int j=2*i;j<=b;j+=i) {
                    primes[j]=false;
                }
            }
        }
        for(int i=b;i>=a;i--){
            if(primes[i]){
                sum+=i;
                first = i;
            }
        }
        System.out.println(sum==0?-1:sum+"\n"+first);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}