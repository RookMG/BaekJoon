import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] A, B;
    static long[] dp;
    static ArrayList<long[]> scope = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        dp = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) B[i] = Integer.parseInt(st.nextToken());
        scope.add(new long[]{B[0],0});
        for(int i=1;i<N;i++){
            scope.add(new long[]{B[i],dp[i] = solve(i)});
            while(scope.size()>2&&calc(scope.size()-3,scope.size()-2)>calc(scope.size()-2,scope.size()-1)){
                scope.remove(scope.size()-2);
            }
        }
        bw.write(Long.toString(dp[N-1]));
        bw.flush();
    }
    static long solve(int idx){
        int left = 0, right = scope.size()-1;
        while(left<right){
            int mid = (left+right)/2;
            if(calc(mid,mid+1)<=A[idx]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return scope.get(left)[0]*A[idx] + scope.get(left)[1];
    }
    static long calc(int a, int b){
        return (scope.get(a)[1]-scope.get(b)[1])/(scope.get(b)[0]-scope.get(a)[0]);
    }
}