import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int grundy = arr[0] = Integer.parseInt(st.nextToken()), ones = arr[0]==1?1:0, altGrundy = 1;
        boolean alt = arr[0]==1;
        for(int i=1;i<n;i++){
            grundy^=arr[i]=Integer.parseInt(st.nextToken());
            if(arr[i]==1){
                ones++;
                altGrundy^=arr[i];
            }else if(alt){
                alt = false;
                altGrundy^=1;
            }else{
                altGrundy^=arr[i];
            }
        }
        if(alt){
            bw.write(n%2==1 ? "cubelover" : "koosaga");
        }else {
            if (ones > 0 && ones % 2 == 0) grundy = altGrundy;
            bw.write(grundy == 0 ? "cubelover" : "koosaga");
        }
        bw.flush();
    }
}