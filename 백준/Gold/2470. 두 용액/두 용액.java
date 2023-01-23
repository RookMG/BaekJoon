import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int left=0, right=n-1;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] answer = {Math.abs(arr[0]+arr[n-1]),0,n-1};
        while(left<right){
            if(Math.abs(arr[left]+arr[right])<answer[0]){
                answer[0]=Math.abs(arr[left]+arr[right]);
                answer[1]=left;
                answer[2]=right;
            }
            if(arr[left]+arr[right]>0){
                right--;
            }else{
                left++;
            }
        }
        System.out.println(arr[answer[1]]+" "+arr[answer[2]]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}