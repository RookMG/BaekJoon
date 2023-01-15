import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<c;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] score = new int[n];
            int sum=0, cnt = 0;
            for(int j=0;j<n;j++){ sum += score[j] = Integer.parseInt(st.nextToken()); }
            for(int j:score){ if(sum<n*j){ cnt++; } }
            sb.append(String.format("%.3f", (double)100*cnt/n)).append("%\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}