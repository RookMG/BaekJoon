import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for(int i=1,j,k;i<N;i++){
            if(arr[i]+1!=arr[i+1]) continue;
            k = i+1;
            while(k!=N+1&&arr[i+1]==arr[k]) k++;
            if(k==N+1) {
                j = i;
                while (arr[i] == arr[j]) j--;
                arr[j + 1]++;
                arr[i + 1]--;
            }else{
                arr[i+1] = arr[k];
                arr[k] = arr[i]+1;
            }
        }
        for(int i=1;i<=N;i++) sb.append(arr[i]).append(' ');
        bw.write(sb.toString());
        bw.flush();
    }
}