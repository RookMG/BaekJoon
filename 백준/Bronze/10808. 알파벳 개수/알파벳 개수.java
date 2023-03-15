import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        for(char c : br.readLine().toCharArray()) arr[c-'a']++;
        for(int i:arr){
            bw.write(Integer.toString(i));
            bw.write(" ");
        }
        bw.flush();
    }
}