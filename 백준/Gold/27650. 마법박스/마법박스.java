import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        boolean[] primes = new boolean[n+1];
        ArrayList<Integer> prime = new ArrayList<>();
        Arrays.fill(primes,true);
        primes[1]=false;
        for(int i=2;i<Math.sqrt(n)+1;i++) {
            if(primes[i]) {
                for(int j=2*i;j<=n;j+=i) {
                    if(primes[j]) {
                        primes[j]=false;
                    }
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(primes[i]) prime.add(i);
        }
        int left = 0, right = prime.size()-1, mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            if(left==right) break;
            bw.write("? ");
            bw.write(Integer.toString(prime.get(mid)));
            bw.write("\n");
            bw.flush();
            int out = Integer.parseInt(br.readLine());
            if(out==1) left = mid+1;
            else right = mid;
        }
        bw.write("! ");
        bw.write(Integer.toString(prime.get(mid)));
        bw.write("\n");
        bw.flush();
    }
}