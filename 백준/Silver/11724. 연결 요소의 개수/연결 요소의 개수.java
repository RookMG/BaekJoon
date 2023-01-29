import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent;
    static int findP(int idx){
        return parent[idx] = (idx==parent[idx]?idx:findP(parent[idx]));
    }
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), answer = n;
        parent = new int[n+1];
        for(int i=1;i<=n;i++){parent[i]=i;}
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            if(a>b){int tmp = a;a=b;b=tmp;} //항상 a<b
            int ap = findP(a), bp = findP(b);
            if(findP(a)!=findP(b)){
                answer--;
                parent[bp] = parent[ap];
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}