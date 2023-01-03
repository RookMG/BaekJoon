import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] word = br.readLine().toCharArray();
        long answer = 0;
        for (int i=n-1;i>=0;i--){
            answer = (((answer<<5) - answer) + (word[i] - 'a' + 1)) % 1234567891;
        }
        System.out.println(answer%1234567891);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}