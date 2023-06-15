import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static char[] line, key;
    static int[] pi, perm;
    static int N, K, cnt, len=0;
    static long ans = 0L;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        perm = new int[N];
        for(int i=0;i<N;i++){
            len += (input[i] = br.readLine()).length();
            perm[i] = i;
        }
        K = Integer.parseInt(br.readLine());
        pi = new int[len];
        do{
            sb.setLength(0);
            for(int i=0;i<N;i++) sb.append(input[perm[i]]);
            key = sb.toString().toCharArray();
            sb.append(sb).setLength(sb.length()-1);
            line = sb.toString().toCharArray();
            getPi();
            kmp();
            if(cnt==K) ans++;
        }while(np());
        bw.write(Long.toString(ans));
        bw.flush();
    }
    static void getPi(){
        for(int i=1,j=0;i<len;i++){
            while(j>0&&key[i]!=key[j]) j = pi[j-1];
            if(key[i]==key[j]) pi[i] = ++j;
        }
    }
    static void kmp(){
        cnt = 0;
        for(int i=0,j=0;i<line.length;i++){
            while(j>0&&line[i]!=key[j]) j=pi[j-1];
            if(line[i]!=key[j]) continue;
            if(j==len-1){
                cnt++;
                j = pi[j];
                continue;
            }
            j++;
        }
    }
    static boolean np() {
        int lp, blp, tmp;
        for(lp = N-1;lp>0&&perm[lp-1]>=perm[lp];lp--);
        if(lp==0) return false;
        for(blp = N-1;perm[lp-1]>=perm[blp];blp--);
        tmp = perm[blp];
        perm[blp] = perm[lp-1];
        perm[lp-1] = tmp;
        for(int l = lp, r = N-1;l<r;) {
            tmp = perm[l];
            perm[l++] = perm[r];
            perm[r--] = tmp;
        }
        return true;
    }
}