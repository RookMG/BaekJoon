import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        arr[1]=1;
        arr[2]=1;
        arr[3]=1;
        for(int i=1;i<11;i++){
            if(i<8){
                arr[i+3]+=arr[i];
            }
            if(i<9){
                arr[i+2]+=arr[i];
            }
            if(i<10){
                arr[i+1]+=arr[i];
            }
        }
        for(int i=0;i<n;i++){
            sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}