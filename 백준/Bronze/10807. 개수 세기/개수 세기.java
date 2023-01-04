import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[201];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num>=0){
                arr[num]++;
            }else{
                arr[num+201]++;
            }
        }
        int m = Integer.parseInt(br.readLine());
        System.out.println(m>=0?arr[m]:arr[m+201]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}