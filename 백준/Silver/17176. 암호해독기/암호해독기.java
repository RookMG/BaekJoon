import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[53];
        for(int i=0;i<N;i++) arr[Integer.parseInt(st.nextToken())]++;
        for(char ch:br.readLine().toCharArray()){
            if(ch==' ') arr[0]--;
            else if('A'<=ch&&ch<='Z') arr[1+ch-'A']--;
            else arr[27+ch-'a']--;
        }
        boolean v = true;
        for(int i:arr) v&=(i==0);
        bw.write(v?'y':'n');
        bw.flush();
    }
}