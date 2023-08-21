import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int[] arr = new int[20];
        for(int test= Integer.parseInt(br.readLine()), ans;test>0;test--){
            ans = 0;
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(' ');
            input : for(int i=0;i<20;i++){
                int now = arr[i] = Integer.parseInt(st.nextToken());
                for(int j=0;j<i;j++){
                    if(arr[j]<arr[i]) continue;
                    ans += i-j;
                    for(int k=i;k>j;k--) arr[k] = arr[k-1];
                    arr[j] = now;
                    continue input;
                }
            }
            sb.append(ans).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}