import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @link : https://www.acmicpc.net/problem/1244
 * @perf : 11600kb,	76ms
 * @category : 구현, 시뮬레이션
 * @author : tngks1995
 * @note : 주의사항
 */
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] sw = new int[n+1];
    	st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
        	sw[i] = Integer.parseInt(st.nextToken());
        }
        int order = Integer.parseInt(br.readLine());
        for(int i=0;i<order;i++) {
        	st = new StringTokenizer(br.readLine());
        	if(Integer.parseInt(st.nextToken())==1) {
        		int num = Integer.parseInt(st.nextToken());
        		for(int j = num;j<=n;j+=num) {
        			sw[j] = sw[j]==1?0:1;
        		}
        	}else {
        		int num = Integer.parseInt(st.nextToken());
        		sw[num] = sw[num]==1?0:1;
        		for(int j=1;num-j>0&&num+j<=n&&sw[num-j]==sw[num+j];j++) {
        			sw[num-j] = sw[num+j] = sw[num+j]==1?0:1;
        		}
        	}
        }
        for(int i=1;i<=n;i++) {
        	sb.append(sw[i]).append(i%20==0?"\n":" ");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
