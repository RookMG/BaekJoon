import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 최장수열을 이용하여 구하려했더니 N*N으로 시간초과.
* 위상정렬 이용.
* 각 번호에 대해 N번은 내 앞에 1 ~ N-1까지 모두 와있어야 한다.
* => N-1만 확인하여 내 앞에 있으면 모두 내 앞에 있음. 앞에서 차례대로 정렬이 되므로
* 내 앞에 모두 와있다면 나는 이동할 필요가 없으니 패스.
* 아니라면 나를 맨뒤로 이동시켜야 하므로 count +1
* */
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] children = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            children[num] = i;
        }
        int[] dp = new int[N+1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            if( children[i-1]<children[i]){
                answer = Math.max(answer,(dp[i] = dp[i-1] +1));
            }else{
                dp[i] = 1;
            }
        }

        System.out.println(N-answer);
    }
}