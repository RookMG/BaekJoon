import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        String input = "";
        while((input=br.readLine())!=null&&!input.equals("")){
            st = new StringTokenizer(input);
            double r = Double.parseDouble(st.nextToken()), h = Double.parseDouble(st.nextToken()), d1 = Double.parseDouble(st.nextToken()), theta = Double.parseDouble(st.nextToken()), d2 = Double.parseDouble(st.nextToken());
            theta -= Double.parseDouble(st.nextToken());
            if(theta<0) theta += 360;
            theta = Math.min(theta,360-theta);
            sb.append(String.format("%.2f\n",Math.sqrt(d1*d1+d2*d2-2*d1*d2*Math.cos(Math.PI/180*r*theta/Math.sqrt(h*h+r*r)))));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}