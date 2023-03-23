import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) bw.write(grundy(Long.parseLong(br.readLine()))?"cubelover\n":"koosaga\n");
        bw.flush();
    }
    static boolean grundy(long num){
        return num%2==0||((num/2)&750599937895082L)!=0;
    }
}