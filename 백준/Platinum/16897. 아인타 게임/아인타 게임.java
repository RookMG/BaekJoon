import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        for(int i=Integer.parseInt(br.readLine());i>0;i--){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            int div = Math.min(n,m);
            if(k==1){
                bw.write(((n%2==m%2)?(n+1)%2*2:1+(Math.min(n,m)+1)%2*2)==0?"cubelover\n":"koosaga\n");
            }else{
                bw.write((div%(k+1)!=0&&(div/(k+1)+n+m)%2==0)?"cubelover\n":"koosaga\n");
            }
        }
        bw.flush();
    }
}