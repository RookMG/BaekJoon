import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
    static int N, M, K, answer=5000;
    static int[][] map, rotate, rotateInfo;
    static int[] rotateOrder;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        map = new int [N][M]; rotate = new int [N][M]; rotateOrder = new int[K]; rotateInfo = new int[K][4]; //r, c, s, visit
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                rotateInfo[i][j] = Integer.parseInt(st.nextToken())-1;
            }
            rotateInfo[i][2] = Integer.parseInt(st.nextToken());
            rotateOrder[i]=i;
        }
        do{ updateAnswer(); }while(np());
        System.out.print(answer);
    }
    static boolean np() {
    	int lp=0, blp=0, tmp;
    	for(lp = K-1;lp>0&&rotateOrder[lp-1]>=rotateOrder[lp];lp--);
    	if(lp==0) return false;
    	for(blp = K-1;rotateOrder[lp-1]>=rotateOrder[blp];blp--);
    	tmp = rotateOrder[blp];
    	rotateOrder[blp] = rotateOrder[lp-1];
    	rotateOrder[lp-1] = tmp;
    	for(int l = lp, r = K-1;l<r;) {
    		tmp = rotateOrder[l];
        	rotateOrder[l++] = rotateOrder[r];
        	rotateOrder[r--] = tmp;
    	}
    	return true;
    }
    static void updateAnswer(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                rotate[i][j] = map[i][j];
            }
        }
        for(int i=0;i<K;i++){
            int centerR = rotateInfo[rotateOrder[i]][0], centerC = rotateInfo[rotateOrder[i]][1], s = rotateInfo[rotateOrder[i]][2];
            for(int j=1;j<=s;j++){
                int r = centerR - j, c = centerC - j, tmp = rotate[r][c];
                for(int d = 0;d<4;d++){
                    for(int k = 0;k<2*j;k++){
                        int nr = r+delta[d][0], nc = c+delta[d][1];
                        rotate[r][c] = rotate[nr][nc];
                        r = nr; c = nc;
                    }
                }
                rotate[r][c+1] = tmp;
            }
        }
        for(int i=0;i<N;i++){
            int sum = 0;
            for(int j=0;j<M;j++){
                sum+=rotate[i][j];
            }
            answer = Math.min(answer,sum);
        }
    }
}