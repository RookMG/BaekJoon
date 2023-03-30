import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static char[][] map = new char[9][];
    static int[] visit = new int[9];
    public static void main(String[] args) throws Exception {
        for(int r=0;r<9;r++) {
            map[r] = br.readLine().toCharArray();
            for(int c=0;c<9;c++){
                if(map[r][c]=='0') continue;
                int num = 1<<(map[r][c]-'1');
                visit[r] |= num;
                visit[c] |= num<<9;
                visit[r/3*3+c/3] |= num<<18;
            }
        }
        recur(0);
    }
    static void recur(int n) throws IOException {
        if(n==81){
            for(int r=0;r<9;r++) sb.append(map[r]).append("\n");
            bw.write(sb.toString());
            bw.flush();
            System.exit(0);
        }
        int r = n/9, c = n%9;
        if(map[r][c]!='0') recur(n+1);
        else for(int i=0;i<9;i++){
            int num = 1<<i;
            if(((visit[r]&num)|(visit[c]&(num<<9))|(visit[r/3*3+c/3]&(num<<18))) != 0) continue;
            visit[r] |= num;
            visit[c] |= num<<9;
            visit[r/3*3+c/3] |= num<<18;
            map[r][c] = (char)('1'+i);
            recur(n+1);
            visit[r] ^= num;
            visit[c] ^= num<<9;
            visit[r/3*3+c/3] ^= num<<18;
            map[r][c] = '0';
        }
    }
}