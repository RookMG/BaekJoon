import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static final int MAX = 1003002;
    public static void main(String[] args) throws Exception{
        boolean[] primes = new boolean[MAX];
        Arrays.fill(primes,true);
        primes[1]=false;
        for(int i=2,end=(int)Math.sqrt(MAX)+1;i<=end;i++) {
            if(!primes[i]) continue;
            for(int j=2*i;j<MAX;j+=i) primes[j]=false;
        }
        int n = Integer.parseInt(br.readLine());
        for(;;n++){
            while(!primes[n]) n++;
            sb.setLength(0);
            sb.append(n);
            sb.reverse();
            if(Integer.toString(n).equals(sb.toString())) break;
        }
        bw.write(Integer.toString(n));
        bw.flush();
    }
}