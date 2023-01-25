import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String[] codeTable = {"000000","001111","010011","011100","100110","101001","110101","111010"};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        
        decode:for(int i = 0;i<n;i++) {
            String sub = input.substring(i*6, (i+1)*6);
            for(int j = 0;j<8;j++) {
                if(2>Integer.bitCount(Integer.parseInt(sub,2)^Integer.parseInt(codeTable[j],2))) {
                    sb.append((char)('A'+j));
                    continue decode;
                }
            }
            System.out.println(i+1);
            return;
        }
        
        System.out.println(sb);
    }
}