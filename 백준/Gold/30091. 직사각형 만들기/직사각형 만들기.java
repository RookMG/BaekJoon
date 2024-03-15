import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        HashMap<Integer,Long> map = new HashMap<>();
        for(int s=0,sn;s<N;s=sn){
            for(sn=s;sn<N&&arr[s]==arr[sn];sn++);
            map.put(arr[s]*2,map.getOrDefault(arr[s]*2,0L)+1L*arr[s]*arr[s]*((sn-s)/2));
            boolean[] visit = new boolean[N];
            for(;s<sn;s++) for(int e=sn,en;e<N;e=en){
                for(en=e;en<N&&arr[e]==arr[en];en++);
                for(;e<en;e++){
                    if(visit[e]) continue;
                    visit[e] = true;
                    map.put(arr[s]+arr[e],map.getOrDefault(arr[s]+arr[e],0L)+1L*arr[s]*arr[e]);
                    break;
                }

            }
        }
        long ans = 0L;
        for(int i:map.keySet()) ans = Math.max(ans,map.get(i));
        bw.write(Long.toString(ans));
        bw.flush();
    }
}