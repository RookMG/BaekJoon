import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int INF = Integer.MAX_VALUE/10;
    static int V, E;
    static ArrayList<ArrayList<int[]>> links;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        links = new ArrayList<>();
        for(int i=0;i<=V;i++){
            links.add(new ArrayList<>());
            links.get(i).add(new int[]{i,i});
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), weight = Integer.parseInt(st.nextToken());
            links.get(from).add(new int[]{to,weight});
            links.get(to).add(new int[]{from,weight});
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        int w1 = dijk(1,a), w2 = dijk(1,b), w3 = dijk(a,b), w4 = dijk(a,V), w5 = dijk(b,V);
        bw.write(Integer.toString(Math.min(w1+w3+w5,w2+w3+w4)));
        bw.flush();
    }
    static int dijk(int from, int to) throws Exception {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        int[] distance = new int[V+1];
        Arrays.fill(distance, INF);
        distance[from] = 0;
        pq.offer(new int[]{from,0});
        while(!pq.isEmpty()){
            int[] minLink = pq.poll();
            for(int[] link : links.get(minLink[0])){
                if(distance[link[0]]>minLink[1]+link[1]) pq.offer(new int[]{link[0], distance[link[0]] = minLink[1]+link[1]});
            }
        }
        if(distance[to]==INF){
            bw.write("-1");
            bw.flush();
            System.exit(0);
        }
        return distance[to];
    }
}