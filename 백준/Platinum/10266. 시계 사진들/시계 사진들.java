import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] pi, line, key, linenum, keynum;
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        linenum = new int[N];
        keynum = new int[N];
        line = new int[2*N-1];
        key = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            linenum[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            keynum[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(linenum);
        Arrays.sort(keynum);
        for(int i=0;i<N-1;i++){
            line[i]=line[N+i] = linenum[i+1]-linenum[i];
            key[i] = keynum[i+1]-keynum[i];
        }
        line[N-1] = 360000+linenum[0]-linenum[N-1];
        key[N-1] = 360000+keynum[0]-keynum[N-1];
        pi = new int[key.length];
        getPi();
        kmp();
        System.out.print("impossible");
    }
    static void getPi(){
        for(int i=1,j=0;i<pi.length;i++){
            while(j>0&&key[i]!=key[j])
                j = pi[j-1];
            if(key[i]==key[j])
                pi[i] = ++j;
        }
    }
    static void kmp(){
        for(int i=0,j=0;i<line.length;i++){
            while(j>0&&line[i]!=key[j])
                j=pi[j-1];
            if(line[i]==key[j]){
                if(j==key.length-1){
                    System.out.println("possible");
                    System.exit(0);
                }else {
                    j++;
                }
            }
        }
    }
}