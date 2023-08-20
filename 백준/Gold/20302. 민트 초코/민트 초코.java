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
        int[] cnt = new int[MAX+1];
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer("* "+br.readLine());
        for(int i=0, num;i<N;i++){
            boolean isMul = st.nextToken().charAt(0)=='*';
            if((num = Integer.parseInt(st.nextToken()))<0) num=-num;
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
            for(int j=2;now>1;j++){
                if(notPrime[j]) continue;
                while(now%j==0) {
                    cnt[j] += cnt[i];
                    now /= j;
                }
            }
            cnt[i] = 0;
        }
        bw.write(ans);
        bw.flush();
    }
}