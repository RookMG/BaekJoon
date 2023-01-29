import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        System.out.println(Integer.compare(Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine())));
    }
}