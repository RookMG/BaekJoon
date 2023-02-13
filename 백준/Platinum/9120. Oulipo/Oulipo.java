import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] line, key;
    static int[] pi;
    static int l, answer;
    static boolean valid;
    public static void main(String[] args) throws Exception{
    	int test = Integer.parseInt(br.readLine());
    	for(int i=0;i<test;i++){
    		answer = 0;
    		key = br.readLine().toCharArray();
	        line = br.readLine().toCharArray();
	        l = key.length;
	        getPi();
	        kmp();
	        System.out.println(answer);
    	}
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
    static void kmp(){
        for(int i=0,j=0;i<line.length;i++){
            while(j>0&&line[i]!=key[j])
                j=pi[j-1];
            if(line[i]==key[j]){
                if(j==l-1){
                    answer++;
                    j = pi[j];
                }else {
                    j++;
                }
            }
        }
    }
}