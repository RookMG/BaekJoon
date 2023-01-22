import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int rows, cols;
    static int[] rpos, cpos;
    class Shark{
        public int r, c, velocity, direction, size;
        public Shark(int r, int c, int velocity, int direction, int size){
            this.r = r;
            this.c = c;
            this.velocity = direction<3?velocity%(2*(rows-1)):velocity%(2*(cols-1));;
            this.direction = direction;
            this.size = size;
        }
        public Shark(){
        }
        public int getR(){
            return rpos[r];
        }
        public int getC(){
            return cpos[c];
        }
        public void updatePosition(){
            switch(direction){
                case 1:
                    r = (rpos.length+r-velocity)%rpos.length;
                    break;
                case 2:
                    r = (r+velocity)%rpos.length;
                    break;
                case 4:
                    c = (cpos.length+c-velocity)%cpos.length;
                    break;
                case 3:
                    c = (c+velocity)%cpos.length;
                    break;
                default:
                    break;
            }
        }
    }
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken()); cols = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()), answer = 0;
        int[][] map = new int[rows][cols];
        ArrayList<Shark> sharks = new ArrayList<>();
        PriorityQueue<Integer> del = new PriorityQueue<>();
        rpos = new int[2*(rows-1)];
        cpos = new int[2*(cols-1)];
        for(int i=0;i<rpos.length;i++){
            rpos[i] = i<rows?i:rpos.length-i;
        }
        for(int i=0;i<cpos.length;i++){
            cpos[i] = i<cols?i:cpos.length-i;
        }
        sharks.add(new Shark());
        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken())-1, col = Integer.parseInt(st.nextToken())-1;
            sharks.add(new Shark(row,col,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            //int형 배열인 map은 0으로 가득 차 있기 때문에, 상어의 Index는 1부터 시작
            map[row][col] = i;
        }

        //1단계 : 낚시왕이 오른쪽으로 한 칸 이동 (for문으로 구현)
        for(int king = 0; king<cols&&!sharks.isEmpty(); king++){

            //2단계 : 낚시왕이 있는 열에서 땅과 제일 가까운 상어 포획
            for(int row = 0;row<rows;row++){
                if(map[row][king]!=0){
                    //위쪽부터 탐색하며 상어를 찾았다면 ArrayList에서 제거하고 크기를 더함
                    //ArrayList를 쓴 이유?? 상어를 순차적으로 탐색하는 횟수는 많은 반면에
                    //제거하는 횟수는 최악의 경우에도 10000개의 상어 배열에서 100번
                    answer += sharks.get(map[row][king]).size;
                    del.offer(-map[row][king]);
                    break;
                }
            }

            while(!del.isEmpty()){
                sharks.remove(-del.poll());
            }

            //3단계 : 상어 이동
            map = new int[rows][cols];
            for(int i = 1;i<sharks.size();i++){
                Shark s = sharks.get(i);
                s.updatePosition();
                if(map[s.getR()][s.getC()]==0){
                    map[s.getR()][s.getC()]=i;
                }else{
                    Shark tmp = sharks.get(map[s.getR()][s.getC()]);
                    if(tmp.size<s.size){
                        del.offer(-map[s.getR()][s.getC()]);
                        map[s.getR()][s.getC()] = i;
                    }else{
                        del.offer(-i);
                    }
                }
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}