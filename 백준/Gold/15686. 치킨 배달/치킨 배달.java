import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, answer, size;
    static int[] bbqGoldenOlive;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); answer = Integer.MAX_VALUE;
        ArrayList<int[]> house = new ArrayList<>(), chicken = new ArrayList<>();
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		int now = Integer.parseInt(st.nextToken());
        		if(now==1) {house.add(new int[] {i,j});}
        		else if(now==2) {chicken.add(new int[] {i,j,0});}
        	}
        }
        size = chicken.size();
        bbqGoldenOlive = new int[size];
        for(int i=0;i<m;i++) {
        	bbqGoldenOlive[size-1-i]=1;
        }
        
        do {
        	int sum = 0;
        	for(int i=0;i<house.size();i++) {
        		int now = 2*n;
        		for(int j=0;j<size;j++) {
        			if(bbqGoldenOlive[j]==1) {
        				now = Math.min(now, Math.abs(house.get(i)[0]-chicken.get(j)[0])+Math.abs(house.get(i)[1]-chicken.get(j)[1]));
        			}
        		}
        		sum+=now;
        	}
        	answer = Math.min(answer, sum);
        }while(np());
        
        System.out.print(answer);
    }
    static boolean np() {
    	int lp=0, blp=0, tmp;
    	for(lp = size-1;lp>0&&bbqGoldenOlive[lp-1]>=bbqGoldenOlive[lp];lp--);
    	if(lp==0) return false;
    	for(blp = size-1;bbqGoldenOlive[lp-1]>=bbqGoldenOlive[blp];blp--);
    	tmp = bbqGoldenOlive[blp];
    	bbqGoldenOlive[blp] = bbqGoldenOlive[lp-1];
    	bbqGoldenOlive[lp-1] = tmp;
    	for(int l = lp, r = size-1;l<r;) {
    		tmp = bbqGoldenOlive[l];
        	bbqGoldenOlive[l++] = bbqGoldenOlive[r];
        	bbqGoldenOlive[r--] = tmp;
    	}
    	return true;
    }
}