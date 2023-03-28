import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        if(R%2==1){
            for(int r=0;r<R;r++){
                char ch = r%2==0?'R':'L';
                for(int c=1;c<C;c++) sb.append(ch);
                sb.append('D');
            }
            sb.setLength(sb.length()-1);
        }else if(C%2==1){
            for(int c=0;c<C;c++){
                char ch = c%2==0?'D':'U';
                for(int r=1;r<R;r++) sb.append(ch);
                sb.append('R');
            }
            sb.setLength(sb.length()-1);
        }else{
            int mr = 0, mc = 0, min = Integer.MAX_VALUE, now = 0;
            for(int r=0;r<R;r++) {
                st = new StringTokenizer(br.readLine());
                for(int c=0;c<C;c++){
                    now = Integer.parseInt(st.nextToken());
                    if((r+c)%2==1&&now<min){
                        min = now;
                        mr = r;
                        mc = c;
                    }
                }
            }
            if(mr==0){
                for(int c=0;c<mc;c++){
                    sb.append(c%2==0?'D':'U').append('R');
                }
                for(int c=mc+1;c<C;c++){
                    sb.append('R').append(c%2==0?'U':'D');
                }
                for(int r=mr+2;r<R;r++){
                    char ch = r%2==0?'L':'R';
                    sb.append('D');
                    for(int c=1;c<C;c++) sb.append(ch);
                }
            }else{
                for(int r=0;r<mr-1;r++){
                    char ch = r%2==0?'R':'L';
                    for(int c=1;c<C;c++) sb.append(ch);
                    sb.append('D');
                }
                if(mr%2!=0){
                    for(int c=0;c<mc;c++){
                        sb.append(c%2==0?'D':'U').append('R');
                    }
                    for(int c=mc+1;c<C;c++){
                        sb.append('R').append(c%2==0?'U':'D');
                    }
                }else{
                    for(int c=C-1;c>mc;c--){
                        sb.append(c%2==0?'U':'D').append('L');
                    }
                    for(int c=mc-1;c>=0;c--){
                        sb.append('L').append(c%2==0?'D':'U');
                    }
                }
                for(int r=mr+1;r<R;r++){
                    char ch = r%2==0?'L':'R';
                    sb.append('D');
                    for(int c=1;c<C;c++) sb.append(ch);
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}