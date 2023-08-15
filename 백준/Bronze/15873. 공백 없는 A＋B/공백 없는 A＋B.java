import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int a = 0;
        String in = br.readLine();
        if(in.length()==2) a=in.charAt(0)+in.charAt(1)-2*'0';
        else if(in.length()==4) a=20;
        else if(in.charAt(1)=='0') a=10+in.charAt(2)-'0';
        else a=10+in.charAt(0)-'0';
        bw.write(Integer.toString(a));
        bw.flush();
    }
}