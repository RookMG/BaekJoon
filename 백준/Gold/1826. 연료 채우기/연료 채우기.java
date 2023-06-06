import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans = 0;
        int[][] stops = new int[N][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            stops[i][0] = Integer.parseInt(st.nextToken());
            stops[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(stops, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        st = new StringTokenizer(br.readLine());
        int goal = Integer.parseInt(st.nextToken()), fuel = Integer.parseInt(st.nextToken());
        for(int i=0;fuel<goal;ans++,fuel-=pq.poll()){
            while(i<N&&stops[i][0]<=fuel) pq.add(-stops[i++][1]);
            if(pq.isEmpty()){
                ans = -1;
                break;
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}