import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        boolean asc = false, desc = false;
        for(int i = 1;i<8;i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(prev>tmp)
                desc = true;
            else
                asc = true;
            prev = tmp;
        }
        if(asc&&desc)
            sb.append("mixed");
        else if(asc)
            sb.append("ascending");
        else
            sb.append("descending");
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}