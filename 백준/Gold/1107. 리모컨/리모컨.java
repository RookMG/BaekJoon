import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int target, ans, len;
    static ArrayList<Integer> buttons = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        target = Integer.parseInt(s);
        len = s.length()+1;
        ans = Math.abs(target-100);
        boolean[] broken = new boolean[10];
        int fails = Integer.parseInt(br.readLine());
        if(fails!=0) st = new StringTokenizer(br.readLine());
        for(int i=0;i<fails;i++) broken[Integer.parseInt(st.nextToken())] = true;
        for(int i=0;i<10;i++) if(!broken[i]) buttons.add(i);
        for(int i:buttons){
            recur(1,i);
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
    static void recur(int cnt, int now){
        if(cnt>len) return;
        ans = Math.min(ans,cnt+Math.abs(target-now));
        for(int i:buttons){
            int next = now*10+i;
            recur(cnt+1,next);
        }
    }
}