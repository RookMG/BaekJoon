import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        char[] line = (br.readLine()+" ").toCharArray();
        l:for(int i=0;i<line.length;i++){
            if(line[i]=='X'){
                int cnt=1;
                for(;line[i+1]=='X';i++,cnt++);
                if(cnt%2==1){
                    sb.setLength(0);
                    sb.append("-1 ");
                    break l;
                }
                for(;cnt>=4;cnt-=4) sb.append("AAAA");
                if(cnt==2) sb.append("BB");
            }
            else sb.append(line[i]);
        }
        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
    }
}