import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        long n = Long.parseLong(br.readLine()), now = 0, answer = -1;
        HashSet<Long> visit = new HashSet<>();
        ArrayDeque<Long> q = new ArrayDeque<>();
        q.offer(n);
        while(now!=1){
            for(int i=q.size();i>0;i--){
                now = q.pollFirst();
                if(now==1)
                    break;
                if(now%2==0&&!visit.contains(now/2)){
                    visit.add(now/2);
                    q.offerLast(now/2);
                }
                if(now%3==0&&!visit.contains(now/3)){
                    visit.add(now/3);
                    q.offerLast(now/3);
                }
                if(!visit.contains(now-1)){
                    visit.add(now-1);
                    q.offerLast(now-1);
                }
            }
            answer++;
        }
        bw.write(Long.toString(answer));
        bw.flush();
    }
}