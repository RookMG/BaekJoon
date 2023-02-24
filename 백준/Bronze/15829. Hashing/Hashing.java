import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] word = br.readLine().toCharArray();
        long answer = 0;
        for(int i=0;i<n;i++){
            answer += ((int)word[i]-(int)'a'+1)*(Math.pow(31,i)%1234567891);
            answer %= 1234567891;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}