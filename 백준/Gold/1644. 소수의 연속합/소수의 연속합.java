import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), answer = 0, partsum = 0;
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        primes[1]=false;
        ArrayList<Integer> primeSum = new ArrayList<>();
        primeSum.add(0);
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(primes[i]) {
                for(int j=2*i;j<=n;j+=i) {
                    primes[j]=false;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(primes[i]) {
                partsum += i;
                primeSum.add(partsum);
            }
        }
        //투포인터 로직
        int left = 0, right = 1;
        while(left<right&&right<primeSum.size()){
            int now = primeSum.get(right)-primeSum.get(left);
            if(now>n){
                left++;
            }else{
                if(now==n){answer++;}
                right++;
            }
        }

        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}