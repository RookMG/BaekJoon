import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C;
    static long G;
    static long[] dp = new long[1<<20];
    public static void main(String[] args) throws Exception {
        for(int test = 1; test <= 3; test++){
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            G = 0;
            for(int r=0;r<R-R%2;r+=2){
                int status = 0;
                char[] up = br.readLine().toCharArray(), down = br.readLine().toCharArray();
                for(int i=0;i<C;i++){
                    status<<=2;
                    status |= (up[i]=='.'?2:0)|(down[i]=='.'?1:0);
                }
                Arrays.fill(dp,-1);
                dp[0] = 0;
                grundy(status);
                G^=dp[status];
            }
            if(R%2==1){
                int status = 0;
                char[] up = br.readLine().toCharArray();
                for(int i=0;i<C;i++){
                    status<<=2;
                    status |= (up[i]=='.'?2:0);
                }
                Arrays.fill(dp,-1);
                dp[0] = 0;
                grundy(status);
                G^=dp[status];
            }
            sb.append(G==0?"M\n":"Y\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void grundy(int status){
        if(dp[status]!=-1||status==0) return;
        HashSet<Long> mex = new HashSet<>();
        for(int i=15;i<(1<<20)&&i<=status;i<<=2){
            if((status&i) != i) continue;
            grundy(status^i);
            mex.add(dp[status^i]);
        }
        for(int i=1;i<(1<<20);i<<=1){
            if((status&i) == 0) continue;
            grundy(status^i);
            mex.add(dp[status^i]);
        }
        dp[status] = 0;
        while(mex.contains(dp[status])) dp[status]++;
        //print(status,dp[status]);
    }
    static void print(int status, long value){
        for (int i=(1<<(C*2-1));i>0;i>>=2){
            System.out.print((status&i)==0?'#':'.');
        }
        System.out.println();
        for (int i=(1<<(C*2-2));i>0;i>>=2){
            System.out.print((status&i)==0?'#':'.');
        }
        System.out.println();
        System.out.println(value);
    }
}