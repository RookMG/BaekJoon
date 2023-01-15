import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public int gen(int num){
        if(num<10)
            return num;
        return num%10 + gen(num/10);
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=n-n/10-10;i<n;i++){
            if(n==i+gen(i)){answer=i; break;}
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}