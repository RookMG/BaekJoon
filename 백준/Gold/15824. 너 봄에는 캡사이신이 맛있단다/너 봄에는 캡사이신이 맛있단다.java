import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static final long MOD = 1000000007L;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] pows;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        int[] arr = new int[n];
        pows = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                answer+=((long)(arr[j]-arr[i]))*pow(j-i-1)%MOD;
            }
        }
        System.out.print(answer%MOD);
    }
    static long pow(int k){
        if(k<2) return k+1;
        if(pows[k]!=0) return pows[k];
        long prev = pow(k/2);
        return pows[k] = (int)(k%2==0?(prev*prev)%MOD:(prev*prev*2)%MOD);
    }
}