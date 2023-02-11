import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static char[] line, key;
    static int[] pi;
    static int n, m;
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine()); m=0;
        line = new char[2*n-1]; key = new char[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++)
            line[i]=line[n+i]=st.nextToken().charAt(0);
        line[n-1] = st.nextToken().charAt(0);
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            key[i]=st.nextToken().charAt(0);
        pi = new int[key.length];
        getPi();
        kmp();
        int div = gcd(m,n);
        sb.append(m/div).append("/").append(n/div);
        System.out.print(sb);
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
                    m++;
                    j = pi[j];
                }else {
                    j++;
                }
            }
        }
    }
    static int gcd(int a, int b){
        return b>0?gcd(b,a%b):a;
    }
}