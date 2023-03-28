import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashSet<Long> visit;
    static ArrayDeque<Long> q;
    public static void main(String[] args) throws Exception{
        long n = Long.parseLong(br.readLine()), now = 0, answer = -1;
        visit = new HashSet<>();
        q = new ArrayDeque<>();
        q.offer(n);
        while(now!=1){
            for(int i=q.size();i>0;i--){
                now = q.pollFirst();
                if(now==1)
                    break;
                if(now%3==0) next(now/3);
                if(now%2==0) next(now/2);
                next(now-1);
            }
            answer++;
        }
        bw.write(Long.toString(answer));
        bw.flush();
    }
    static void next(long num){
        if(visit.contains(num)) return;
        visit.add(num);
        q.offerLast(num);
    }
}