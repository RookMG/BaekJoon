import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), answer = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++) {
            //투포인터 로직
            int left = i==0?1:0, right = i==n-1?n-2:n-1, target = arr[i];
            while (left < right && right < n) {
                int now = arr[right] + arr[left];
                if (now == target) {
                    answer++;break;
                } else if(now < target) {
                    left+=left==i-1?2:1;
                } else{
                    right-=right==i+1?2:1;
                }
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}