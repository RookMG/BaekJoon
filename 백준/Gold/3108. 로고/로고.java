import java.io.*;
import java.util.*;
public class Main {
    static class Rect{
        int x1, y1, x2, y2;
        Rect(int a, int b, int c, int d){
            x1 = Math.min(a,c);
            x2 = Math.max(a,c);
            y1 = Math.min(b,d);
            y2 = Math.max(b,d);
        }
        boolean isCrossing(Rect r){
            return (x2>=r.x1&&r.x2>=x1&&y2>=r.y1&&r.y2>=y1)
                    &&!(((x1<r.x1&&r.x2<x2)&&(y1<r.y1&&r.y2<y2))||((r.x1<x1&&x2<r.x2)&&(r.y1<y1&&y2<r.y2)));
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans = N;
        parent = new int[N+1];
        Rect[] rects = new Rect[N+1];
        rects[0] = new Rect(0,0,0,0);
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            rects[i] = new Rect(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            parent[i] = i;
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<=N;j++){
                if(!rects[i].isCrossing(rects[j])) continue;
                int ap = findP(i), bp = findP(j);
                if(ap==bp) continue;
                ans--;
                parent[Math.min(ap,bp)] = Math.max(ap,bp);
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
    static int findP(int num){
        return parent[num] = parent[num]==num?num:findP(parent[num]);
    }
}