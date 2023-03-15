import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] line = br.readLine().toCharArray();
        int answer = 1;
        char now = line[0];
        for(int i=0;i<line.length;i++){
            if(now!=line[i]){
                answer++;
                now = line[i];
            }
        }
        bw.write(Integer.toString(answer/2));
        bw.flush();
    }
}