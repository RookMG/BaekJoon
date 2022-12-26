import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int max=0, where=0;
        for(int i=1;i<10;i++){
            int tmp=Integer.parseInt(br.readLine());
            if(max<tmp){
                max=tmp;
                where=i;
            }
        }
        sb.append(max);
        sb.append("\n");
        sb.append(where);
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}