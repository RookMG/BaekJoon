import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int left;
    static char[][] map = new char[3][3];
    static int[][] zeros = new int[9][2];
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        left = 0; //남은 턴 수
        for(int r=0;r<3;r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<3;c++) {
                if('0' == (map[r][c] = st.nextToken().charAt(0))) {
                    zeros[left][0] = r;
                    zeros[left++][1] = c;
                }
            }
        }
        visit = new boolean[left];
        bw.write(left<8?new char[] {'L','D','W'}[1+solve(left)]:'D');
        bw.flush();
    }
    static int solve(int turns) {
        if(turns==0) {
            return 0;
        }
        int result = -1;
        for(int i=0;i<left;i++) {
            if(!visit[i]) {
                int r = zeros[i][0], c = zeros[i][1];
                map[r][c] = turns%2==0?'2':'1';
                if(checkWin()) {
                    map[r][c] = '0';
                    return 1;
                }else {
                    visit[i] = true;
                    result = Math.max(result, -1*solve(turns-1));
                    visit[i] = false;
                    map[r][c] = '0';
                }
            }
        }
        return result;
    }
    static boolean checkWin() {
        boolean win = ((map[0][0]==map[1][1])&&(map[0][0]==map[2][2])&&(map[0][0]!='0'))||((map[0][2]==map[1][1])&&(map[0][2]==map[2][0])&&(map[0][2]!='0'));
        for(int i=0;i<3;i++) {
            win |= (map[0][i]==map[1][i])&&(map[0][i]==map[2][i])&&(map[0][i]!='0');
            win |= (map[i][0]==map[i][1])&&(map[i][0]==map[i][2])&&(map[i][0]!='0');
        }
        return win;
    }
}