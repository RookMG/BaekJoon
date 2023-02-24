import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        char[] line = br.readLine().toCharArray();
        int idx = line.length-1, count = 0;
        for(;idx>=0&&"AEIOU".indexOf(line[idx])>=0;idx--);
        sb.append(line[idx]);
        for(count=0;idx>=0&&count<2;idx--){
            if(line[idx]=='A') count++;
        }
        sb.append("AA");
        if(N-idx+3>=M&&count==2){
            System.out.println("YES");
            for(int i=idx;i>idx-M+3;i--)
                sb.append(line[i]);
            sb.reverse();
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}