import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static final int MOD = 1000000007;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                answer+=(arr[j]-arr[i])*pow(2,j-i-1);
                answer%=MOD;
            }
        }
        System.out.print(answer);
    }
    static long pow(int n, int k){
        if(k==0) return 1;
        else if(k==1) return n;
        long prev = pow(n,k/2);
        return k%2==0?prev*prev%MOD:prev*prev*n%MOD;
    }
}