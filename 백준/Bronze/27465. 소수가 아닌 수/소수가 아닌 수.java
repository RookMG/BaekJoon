import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        loop: for(int i=Integer.parseInt(br.readLine());;i++){
            int end = (int)Math.sqrt(i)+1;
            for(int j=2;j<end;j++){
                if(i%j==0) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}