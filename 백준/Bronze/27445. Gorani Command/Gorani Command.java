import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), rmin = 51, cmin, a = 1, b = 1, tmp;
        for(int i=1;i<r;i++){
            tmp = Integer.parseInt(br.readLine());
            if(tmp<rmin){
                rmin = tmp;
                a = i;
            }
        }
        st = new StringTokenizer(br.readLine());
        cmin = Integer.parseInt(st.nextToken());
        if(cmin<rmin){
            a = r;
        }
        for(int i=2;i<=c;i++){
            tmp = Integer.parseInt(st.nextToken());
            if(tmp<cmin){
                cmin = tmp;
                b = i;
            }
        }
        sb.append(a).append(" ").append(b);
        System.out.print(sb);
    }
}