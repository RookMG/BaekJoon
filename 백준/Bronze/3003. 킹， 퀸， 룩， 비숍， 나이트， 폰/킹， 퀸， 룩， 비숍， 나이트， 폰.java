import java.io.InputStreamReader;
import java.io.BufferedReader;
public class Main {
    public static void main(String[] args) throws Exception {
        String[] param = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        String answer = "";
        int[] count = {1,1,2,2,2,8};
        for(int i=0;i<6;i++){
            answer+=(count[i]-Integer.parseInt(param[i]))+" ";
        }
        System.out.println(answer);
    }
}