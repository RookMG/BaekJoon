import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), answer = 0, idx, max;
        ArrayList<ArrayDeque<Integer>> uses = new ArrayList<>();
        ArrayList<Integer> power = new ArrayList<>();
        for(int i=0;i<=K;i++) uses.add(new ArrayDeque<>());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[K];
        for(int i=0;i<K;i++) uses.get(arr[i] = Integer.parseInt(st.nextToken())).add(i);
        use: for(int now:arr){
            uses.get(now).pollFirst();
            if(power.contains(now)) continue;
            if(power.size()<N){
                power.add(now);
                continue;
            }
            answer++;
            idx = 0;
            if(uses.get(power.get(idx)).isEmpty()){
                power.remove(0);
                power.add(now);
                continue;
            }
            max = uses.get(power.get(idx)).peekFirst();
            for(int i=1;i<N;i++){
                if(uses.get(power.get(i)).isEmpty()){
                    power.remove(i);
                    power.add(now);
                    continue use;
                }
                if(max<uses.get(power.get(i)).peekFirst()){
                    max = uses.get(power.get(i)).peekFirst();
                    idx = i;
                }
            }
            power.remove(idx);
            power.add(now);
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}