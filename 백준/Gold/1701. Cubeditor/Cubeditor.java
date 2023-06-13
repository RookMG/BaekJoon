import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] line;
    static int[] pi;
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        line = br.readLine().toCharArray();
        pi = new int[line.length];
        for(int i=0; i<line.length; i++){
            for(int j=i+1, k=0; j<line.length; j++){
                while(k>0&&line[j]!=line[i+k]) k = pi[k-1];
                if(line[j] == line[i+k]) ans = Math.max(ans, ++k);
                pi[j-i] = k;
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}