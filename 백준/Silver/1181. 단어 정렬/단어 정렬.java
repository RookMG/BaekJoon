import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (e1,e2) -> {
            if(e1.length() == e2.length()){
                return e1.compareTo(e2);
            }else{
                return e1.length()-e2.length();
            }
        }
        );
        sb.append(arr[0]);
        sb.append("\n");
        for(int i=1;i<n;i++){
            if(arr[i].equals(arr[i-1]))
                continue;
            sb.append(arr[i]);
            sb.append("\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}