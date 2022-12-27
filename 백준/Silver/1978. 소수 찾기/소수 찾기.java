import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        isPrime[1]=false;
        for(int i=2;i<1001;i++){
            if(isPrime[i]){
                int j = i*2;
                while(j<1001){
                    isPrime[j]=false;
                    j+=i;
                }
            }
        }
        int n = Integer.parseInt(br.readLine()), answer=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            if(isPrime[Integer.parseInt(st.nextToken())]){
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}