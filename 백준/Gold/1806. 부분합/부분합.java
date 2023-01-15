import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int left=0, right=0, sum=0, answer = 100001;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i+1] = (sum+=Integer.parseInt(st.nextToken()));
        }
        while(true){
            if(arr[right]-arr[left]>=s){
                answer = Math.min(answer,right-left);
                left++;
            }else if(right==n){break;}
            else{ right++; }
        }
        System.out.println(answer==100001?0:answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}