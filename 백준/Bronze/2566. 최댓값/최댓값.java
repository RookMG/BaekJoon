import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x=-1,y=-1,max=-1;
        for(int i=1;i<=9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=9;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num>max){
                    max = num;
                    x = i;
                    y = j;
                }
            }
        }
        sb.append(max).append("\n").append(x).append(" ").append(y);
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}