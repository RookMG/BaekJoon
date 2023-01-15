import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static boolean[] self;
    public int gen(int num){
        return num<10?num:num%10+gen(num/10);
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        self = new boolean[10001];
        Arrays.fill(self,true);
        for(int i=1;i<=10000;i++){
            int num = i+gen(i);
            if(num<10001)
                self[i+gen(i)] = false;
        }
        for(int i=1;i<=10000;i++){
            if(self[i]){sb.append(i).append("\n");}
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}