import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        for(int ans=0;;ans=0){
            char[] line = br.readLine().toCharArray();
            if(line.length==1&&line[0]=='#') break;
            for(char ch:line) if("AEIOUaeiou".indexOf(ch)>=0) ans++;
            sb.append(ans).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}