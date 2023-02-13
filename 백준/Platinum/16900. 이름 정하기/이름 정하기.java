import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[] key;
    static int[] pi;
    static long n, k;
    public static void main(String[] args) throws Exception{
    	st = new StringTokenizer(br.readLine());
    	key = st.nextToken().toCharArray();
    	k = Integer.parseInt(st.nextToken());
    	n = key.length;
        pi = new int[(int)n];
        getPi();
        long answer = (n-pi[(int)n-1])*k+pi[(int)n-1];
        System.out.print(answer);
    }
    static void getPi(){
        for(int i=1,j=0;i<pi.length;i++){
            while(j>0&&key[i]!=key[j])
                j = pi[j-1];
            if(key[i]==key[j])
                pi[i] = ++j;
        }
    }
}