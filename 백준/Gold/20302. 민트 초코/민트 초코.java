import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int MAX = 100_000;
    public static void main(String[] args) throws Exception {
        boolean[] notPrime = new boolean[MAX+1];
        for(int i=2;i<=(int)Math.sqrt(MAX)+1;i++){
            if(notPrime[i]) continue;
            for(int j=i<<1;j<=MAX;j+=i) notPrime[j] = true;
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i=2;i<=MAX;i++){
            if(notPrime[i]) continue;
            primes.add(i);
        }
        int[] cnt = new int[MAX+1];
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer("* "+br.readLine());
        for(int i=0;i<N;i++){
            boolean isMul = st.nextToken().charAt(0)=='*';
            int num = Integer.parseInt(st.nextToken());
            if(num<0) num=-num;
            else if(num==0){
                bw.write("mint chocolate");
                bw.flush();
                return;
            }
            cnt[num]+=isMul?1:-1;
        }
        String ans = "mint chocolate";
        for(int i=MAX;i>=2;i--){
            if(cnt[i]==0) continue;
            else if(!notPrime[i]){
                if(cnt[i]>=0) continue;
                ans = "toothpaste";
                break;
            }
            int now = i;
            for(int j=0, prime;now>1;j++){
                prime = primes.get(j);
                while(now%prime==0) {
                    cnt[prime] += cnt[i];
                    now /= prime;
                }
            }
            cnt[i] = 0;
        }
        bw.write(ans);
        bw.flush();
    }
}