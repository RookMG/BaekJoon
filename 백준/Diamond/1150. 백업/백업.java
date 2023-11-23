import java.io.*;
import java.util.*;
public class Main {
    static class Company implements Comparable<Company>{
        int left, right;
        int dist;

        public Company(int left, int right, int dist) {
            this.left = left;
            this.right = right;
            this.dist = dist;
        }

        @Override
        public int compareTo(Company o) {
            return Integer.compare(dist, o.dist);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        Company[] companies = new Company[N+2];
        PriorityQueue<Company> pq = new PriorityQueue<>();
        companies[0] = new Company(0,0,0);
        companies[N] = new Company(N-1,N+1,0);
        companies[N+1] = new Company(N,N+1,0);
        for(int i=1, prev = Integer.parseInt(br.readLine());i<N;i++){
            companies[i] = new Company(i-1,i+1,prev);
            companies[i].dist = (prev = Integer.parseInt(br.readLine())) - companies[i].dist;
            pq.offer(new Company(i,i+1,companies[i].dist));
        }
        long ans = 0L;
        for(int i=0;;){
            Company now = pq.poll();
            int l = now.left, r = now.right;
            if(l<1||r>N||companies[l].right!=r||companies[r].left!=l) continue;
            ans += now.dist;
            if(++i==K) break;
            int ll = companies[l].left, rr = companies[r].right;
            now.left = ll;
            now.right = rr;
            now.dist = companies[ll].dist = companies[ll].dist + companies[r].dist - now.dist;
            pq.offer(now);
            companies[ll].right = rr;
            companies[rr].left = ll;
        }
        bw.write(Long.toString(ans));
        bw.flush();
    }
}