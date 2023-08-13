import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), sum = 0, stat = 0;
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = -Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for(int i=0;i<Math.min(42,N);i++){
            sum-=arr[i];
            if(-arr[i]>=250) stat += 5;
            else if(-arr[i]>=200) stat += 4;
            else if(-arr[i]>=140) stat += 3;
            else if(-arr[i]>=100) stat += 2;
            else if(-arr[i]>=60) stat += 1;
        }
        sb.append(sum).append(' ').append(stat);
        bw.write(sb.toString());
        bw.flush();
    }
}