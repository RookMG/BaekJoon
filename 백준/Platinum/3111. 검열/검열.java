import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        char[] key = br.readLine().toCharArray(), line = br.readLine().toCharArray();
        ArrayDeque<Character> left = new ArrayDeque<>(), right = new ArrayDeque<>();
        for(int l=0,r=line.length-1;l<=r;){
            forward:for(;l<=r;l++){
                left.offerLast(line[l]);
                if(line[l]!=key[key.length-1]||left.size()<key.length) continue;
                for(int i=key.length-1;i>=0;i--){
                    char ch = left.pollLast();
                    if(ch==key[i]) continue;
                    left.offerLast(ch);
                    for(int j=i+1;j<key.length;j++) left.offerLast(key[j]);
                    continue forward;
                }
                l++;
                break;
            }
            backward:for(;l<=r;r--){
                right.offerFirst(line[r]);
                if(line[r]!=key[0]||right.size()<key.length) continue;
                for(int i=0;i<key.length;i++){
                    char ch = right.pollFirst();
                    if(ch==key[i]) continue;
                    right.offerFirst(ch);
                    for(int j=i-1;j>=0;j--) right.offerFirst(key[j]);
                    continue backward;
                }
                r--;
                break;
            }
        }
        concat : while(!right.isEmpty()){
            left.offerLast(right.pollFirst());
            if(left.peekLast()!=key[key.length-1]||left.size()<key.length) continue;
            for(int i=key.length-1;i>=0;i--){
                char ch = left.pollLast();
                if(ch==key[i]) continue;
                left.offerLast(ch);
                for(int j=i+1;j<key.length;j++) left.offerLast(key[j]);
                continue concat;
            }
        }
        while(!left.isEmpty()) sb.append(left.pollFirst());
        bw.write(sb.toString());
        bw.flush();
    }
}