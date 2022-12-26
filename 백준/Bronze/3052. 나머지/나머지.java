import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<10;i++){
            set.add(Integer.parseInt(br.readLine())%42);
        }
        sb.append(set.size());
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}