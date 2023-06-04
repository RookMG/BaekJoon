import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] line, key;
    static int[] pi;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        key = line = br.readLine().toCharArray();
        getPi();
        bw.write(Integer.toString(n-pi[n-1]));
        bw.flush();
    }
    static void getPi(){
        pi = new int[key.length];
        for(int i=1,j=0;i<key.length;i++){
            while(j>0&&key[i]!=key[j])
                j = pi[j-1];
            if(key[i]==key[j])
                pi[i] = ++j;
        }
    }
}