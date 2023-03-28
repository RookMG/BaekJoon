import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int start, end, answer;
    static boolean[] visit, primes;
    static ArrayDeque<Integer> q;
    public static void main(String[] args) throws Exception {
        primes = new boolean[10000];
        Arrays.fill(primes,true);
        primes[1]=false;
        for(int i=2;i<=100;i++) {
            if(primes[i]) {
                for(int j=2*i;j<10000;j+=i) {
                    primes[j]=false;
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        tc:for(int test = 1;test<=T;test++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            visit = new boolean[10000];
            answer = -1;
            q = new ArrayDeque<>();
            q.add(start);
            visit[start] = true;
            int now = 0;
            while(now!=end){
                for(int i=q.size();i>0;i--){
                    now = q.pollFirst();
                    if(now == end) break;
                    for(int s=0;s<4;s++){
                        int div = (int)Math.pow(10,s);
                        for(int j=0;j<10;j++){
                            int next = now - (now/div%10)*div + j*div;
                            if(next<1000||visit[next]||!primes[next]) continue;
                            visit[next] = true;
                            q.offerLast(next);
                        }
                    }
                }
                if(q.isEmpty()&&now!=end){
                    bw.write("Impossible\n");
                    continue tc;
                }
                answer++;
            }
            bw.write(String.format("%d\n",answer));
        }
        bw.flush();
    }
}