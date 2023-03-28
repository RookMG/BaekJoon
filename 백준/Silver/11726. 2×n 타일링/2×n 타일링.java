import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        int[] fill = new int[n];
        fill[0]=1;
        if(n!=1) fill[1]=2;
        for(int i=2;i<n;i++) fill[i]=(fill[i-2]+fill[i-1])%10007;
        bw.write(Integer.toString(fill[n-1]%10007));
        bw.flush();
    }
}