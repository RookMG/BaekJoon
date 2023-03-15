import java.io.*;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        boolean blank = false, first = true;
        while(st.hasMoreTokens()){
            char[] token = st.nextToken().toCharArray();
            for(int i=0;i<token.length;i++){
                if("<>()".indexOf(token[i])>=0){
                    if(!first) bw.write(" ");
                    bw.write(token[i]);
                    blank = true;
                }else if("|&".indexOf(token[i])>=0&&i<token.length-1&&token[i]==token[i+1]){
                    if(!first) bw.write(" ");
                    bw.write(token[i]);
                    bw.write(token[i++]);
                    blank = true;
                }else{
                    if(blank){
                        bw.write(" ");
                        blank = false;
                    }
                    bw.write(token[i]);
                }
                first = false;
            }
            blank = true;
        }
        bw.flush();
    }
}