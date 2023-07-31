import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=Integer.parseInt(br.readLine());i>0;i--,sb.append('\n')) for(int j=Integer.parseInt(br.readLine());j>0;j--) sb.append("=");
        System.out.print(sb);
    }
}