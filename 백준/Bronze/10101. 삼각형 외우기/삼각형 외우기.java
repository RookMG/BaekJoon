import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine()), c = Integer.parseInt(br.readLine());
        if(a+b+c!=180) bw.write("Error");
        else if(a==b&&b==c) bw.write("Equilateral");
        else if(a!=b&&b!=c&&c!=a) bw.write("Scalene");
        else bw.write("Isosceles");
        bw.flush();
    }
}