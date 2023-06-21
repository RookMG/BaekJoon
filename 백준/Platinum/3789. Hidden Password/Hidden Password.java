import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, ans = 100000;
    static int[] r, nr, cnt, sa, idx, lcp, isa;
    static char[] line;
    public static void main(String[] args) throws Exception {
        for(int T = Integer.parseInt(br.readLine());T>0;T--, ans=100000) {
            st = new StringTokenizer(br.readLine());
            N = 2*Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            line = (s+s).toCharArray();
            getSA();
            int i=0;
            while(sa[i]>=s.length()) i++;
            for(;i<N;i++){
                if(sa[i]>=s.length()) break;
                ans = Math.min(ans,sa[i]);
            }
            sb.append(ans).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void getSA(){
        int M = Math.max(257,N+1);
        sa = new int[N];
        r = new int[2*N];
        nr = new int[2*N];
        cnt = new int[M];
        idx = new int[N];
        for(int i=0;i<N;++i){
            sa[i] = i;
            r[i] = line[i];
        }
        for(int d=1;d<N;d<<=1){
            Arrays.fill(cnt,0);
            for(int i=0;i<N;++i) cnt[r[i+d]]++;
            for(int i=1;i<M;++i) cnt[i] += cnt[i-1];
            for(int i=N-1;i>=0;--i) idx[--cnt[r[i+d]]] = i;
            Arrays.fill(cnt,0);
            for(int i=0;i<N;++i) cnt[r[i]]++;
            for(int i=1;i<M;++i) cnt[i]+=cnt[i-1];
            for(int i=N-1;i>=0;--i) sa[--cnt[r[idx[i]]]] = idx[i];
            nr[sa[0]] = 1;
            for(int i=1;i<N;++i) nr[sa[i]] = nr[sa[i-1]] + ((r[sa[i-1]]<r[sa[i]]||(r[sa[i-1]]==r[sa[i]]&&r[sa[i-1]+d]<r[sa[i]+d]))?1:0);
            for(int i=0;i<N;++i) r[i] = nr[i];
            if(r[sa[N-1]]==N) break;
        }
    }
    static void getlcp(){
        lcp = new int[N];
        isa = new int[N];
        for(int i=0;i<N;++i) isa[sa[i]] = i;
        for(int k=0, i=0;i<N;++i){
            if(isa[i]>0){
                for(int j=sa[isa[i]-1];Math.max(i+k,j+k)<N&&line[i+k]==line[j+k];++k);
                lcp[isa[i]] = (k!=0 ? k-- : 0);
            }
        }
    }
}