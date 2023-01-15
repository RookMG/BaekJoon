import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), count = 0;
        HashSet<String> s = new HashSet<>();
        for(int i=0;i<n;i++){
            s.add(br.readLine());
        }
        for(int j=0;j<m;j++){
            if(s.contains(br.readLine())){count++;}
        }
        System.out.println(count);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}