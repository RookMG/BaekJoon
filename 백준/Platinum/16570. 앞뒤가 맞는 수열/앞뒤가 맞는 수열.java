import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] line, key;
    static int[] pi;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine()), max=0, cnt=0;
        key = new int[n]; line = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=n-1;i>=0;i--){
            key[i]=line[i] = Integer.parseInt(st.nextToken());
        }
        getPi();
        for(int i=0;i<n;i++){
            if(pi[n-1-i]>max){
                max = pi[n-1-i];
                cnt = 1;
            }
            else if(pi[n-1-i]==max){
                cnt++;
            }
        }
        System.out.println(max==0?-1:(max+" "+cnt));
    }
    static void getPi(){
        pi = new int[key.length];
        for(int i=1,j=0;i<key.length;i++){
            while(j>0&&key[i]!=key[j])
                j = pi[j-1];
            if(key[i]==key[j])
                pi[i] = ++j;
        }
    }
}