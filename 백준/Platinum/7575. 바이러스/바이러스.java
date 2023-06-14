import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] line, key;
    static int[] pi, rpi;
    static int N, K, s;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] input = new int[N][];
        for(int i=0, l;i<N;i++){
            input[i] = new int[l= Integer.parseInt(br.readLine())];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<l;j++) input[i][j] = Integer.parseInt(st.nextToken());
        }
        pi = new int[K];
        rpi = new int[K];
        key = input[0];
        String ans = "NO";
        search : for(s=0;s+K<=key.length;s++) {
            getPi();
            for (int i = 1; i < N; i++) {
                line = input[i];
                if(!kmp()) continue search;
            }
            ans = "YES";
            break;
        }
        bw.write(ans);
        bw.flush();
    }
    static void getPi(){
        Arrays.fill(pi,0);
        for(int i=1,j=0;i<K;i++){
            while(j>0&&key[s+i]!=key[s+j])
                j = pi[j-1];
            if(key[s+i]==key[s+j])
                pi[i] = ++j;
        }
        Arrays.fill(rpi,0);
        for(int i=1,j=0;i<K;i++){
            while(j>0&&key[s+K-1-i]!=key[s+K-1-j])
                j = pi[j-1];
            if(key[s+K-1-i]==key[s+K-1-j])
                pi[i] = ++j;
        }
    }
    static boolean kmp(){
        for(int i=0,j=0;i<line.length;i++){
            while(j>0&&line[i]!=key[s+j]) j=pi[j-1];
            if(line[i]!=key[s+j]) continue;
            if(j++==K-1) return true;
        }
        for(int i=0,j=0;i<line.length;i++){
            while(j>0&&line[i]!=key[s+K-1-j]) j=rpi[j-1];
            if(line[i]!=key[s+K-1-j]) continue;
            if(j++==K-1) return true;
        }
        return false;
    }
}