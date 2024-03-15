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
        TreeMap<Integer,Long> map = new TreeMap<>();
        for(int i=0,j=0;i<N;i=j){
            for(j=i;j<N&&arr[i]==arr[j];j++);
            map.put(arr[i]<<1,map.getOrDefault(arr[i]<<1,0L)+1L*arr[i]*arr[i]*((j-i)>>1));
            boolean[] visit = new boolean[N];
            for(int s=j,e;s<N;s=e){
                for(e=s;e<N&&arr[s]==arr[e];e++);
                for(;visit[s];s++);
                visit[s] = true;
                map.put(arr[i]+arr[s],map.getOrDefault(arr[i]+arr[s],0L)+1L*arr[i]*arr[s]);
            }
        }
        long ans = 0L;
        for(int i:map.keySet()) ans = Math.max(ans,map.get(i));
        bw.write(Long.toString(ans));
        bw.flush();
    }
}