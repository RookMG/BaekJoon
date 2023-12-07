import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), ans = 0;
        long D = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> enemy = new PriorityQueue<>(), weapon = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken())==1) enemy.offer(Integer.parseInt(st.nextToken()));
            else weapon.offer(Integer.parseInt(st.nextToken()));
        }
        while(!enemy.isEmpty()){
            if(D>1_000_000_000){
                ans = N;
                weapon.clear();
                break;
            }
            if(enemy.peek()>=D){
                if(weapon.isEmpty()) break;
                D *= weapon.poll();
                ans++;
                continue;
            }
            D += enemy.poll();
            ans++;
        }
        ans += weapon.size();
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}