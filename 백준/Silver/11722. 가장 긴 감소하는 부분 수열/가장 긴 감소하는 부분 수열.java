import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n], record = new int[n];
        Arrays.fill(record,1);
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    record[j]=Math.max(record[j],record[i]+1);
                }
            }
        }
        Arrays.sort(record);
        System.out.println(record[n-1]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}