import java.io.*;
import java.util.regex.Pattern;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        String input;
        Pattern p = Pattern.compile("^[^aeiou]+$|[aeiou]{3,}|[^aeiou]{3,}|([^eo])\\1+");
        while(!"end".equals(input=br.readLine())){
            sb.append(String.format("<%s> is%s acceptable.\n",input,p.matcher(input).find()?" not":""));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}