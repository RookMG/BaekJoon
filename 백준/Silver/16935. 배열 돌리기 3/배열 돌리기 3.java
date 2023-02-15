import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;
    static final int[] inverse = {0,1,2,4,3,6,5};
    static Deque<Integer> command = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<R;i++) command.offer(Integer.parseInt(st.nextToken()));
        while(!command.isEmpty()) {
        	int now = command.pollFirst();
        	if(!command.isEmpty()&&inverse[now]==command.peekFirst()) {command.poll();continue;}
        	flip(now);
        }
        for(int i=0;i<map.length;i++) {
        	for(int j=0;j<map[0].length;j++) {
        		sb.append(map[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.print(sb);
    }
    static void flip(int num){
    	int R = map.length, C = map[0].length, divR = R>>1, divC = C>>1;;
    	int[][] nmap = new int[R][C];
    	switch(num) {
    	case 1:
    		for(int i=0;i<R;i++) {
            	for(int j=0;j<C;j++) {
            		nmap[i][j] = map[R-1-i][j];
            	}
            }
    		break;
    	case 2:
    		for(int i=0;i<R;i++) {
            	for(int j=0;j<C;j++) {
            		nmap[i][j] = map[i][C-1-j];
            	}
            }
    		break;
    	case 3:
    		nmap = new int[C][R];
    		for(int i=0;i<C;i++) {
            	for(int j=0;j<R;j++) {
            		nmap[i][j] = map[R-1-j][i];
            	}
            }
    		break;
    	case 4:
    		nmap = new int[C][R];
    		for(int i=0;i<C;i++) {
            	for(int j=0;j<R;j++) {
            		nmap[i][j] = map[j][C-1-i];
            	}
            }
    		break;
    	case 5:
    		for(int i=0;i<R;i++) {
            	for(int j=0;j<C;j++) {
            		int bigR = i/divR, bigC = j/divC;
            		nmap[i][j] = map[(1-bigC)*divR + i%divR][bigR*divC + j%divC];
            	}
            }
    		break;
    	case 6:
    		for(int i=0;i<R;i++) {
            	for(int j=0;j<C;j++) {
            		int bigR = i/divR, bigC = j/divC;
            		nmap[i][j] = map[bigC*divR + i%divR][(1-bigR)*divC + j%divC];
            	}
            }
    		break;
    	}
    	map = nmap;
    }
}