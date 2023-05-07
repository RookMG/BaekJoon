import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int diff = -Integer.parseInt(br.readLine())+ Integer.parseInt(br.readLine());
        if(diff<=0) bw.write("Congratulations, you are within the speed limit!");
        else if(diff<=20) bw.write("You are speeding and your fine is $100.");
        else if(diff<=30) bw.write("You are speeding and your fine is $270.");
        else bw.write("You are speeding and your fine is $500.");
        bw.flush();
    }
}