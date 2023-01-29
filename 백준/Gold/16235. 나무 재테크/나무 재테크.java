import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] nutrient, s2d2, delta = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    static int N, M, K;
    class Tree implements Comparable<Tree>{
        int r, c, age;
        public Tree(int r, int c, int age){
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return age-o.age;
        }
    }

    static boolean isIn(int r, int c){
        return 0<=r&&r<N&&0<=c&&c<N;
    }
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        nutrient = new int[N][N]; s2d2 = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                nutrient[i][j] = 5;
                s2d2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<Tree> pq = new PriorityQueue<>();
        Deque<Tree> trees = new LinkedList<>(), dead = new LinkedList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new Tree(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));
        }
        while(!pq.isEmpty()){
            trees.offer(pq.poll());
        }
        for(int year = 1;year<=K;year++){
            Deque<Tree> next = new LinkedList<>();
            //spring
            while(!trees.isEmpty()){
                Tree toGrow = trees.pop();
                if(nutrient[toGrow.r][toGrow.c]< toGrow.age){
                    dead.offer(toGrow);
                }else{
                    nutrient[toGrow.r][toGrow.c] -= toGrow.age;
                    toGrow.age++;
                    if(toGrow.age%5==0){
                        for(int i=0;i<delta.length;i++){
                            int nr = toGrow.r+delta[i][0], nc = toGrow.c+delta[i][1];
                            if(isIn(nr,nc)){
                                next.offerFirst(new Tree(nr,nc,1));
                            }
                        }
                    }
                    next.offerLast(toGrow);
                }
            }

            //summer
            while(!dead.isEmpty()){
                Tree toDead = dead.pop();
                nutrient[toDead.r][toDead.c]+= toDead.age/2;
            }

            //fall
            trees = next;

            //winter
            for(int i = 0;i<N;i++){
                for(int j=0;j<N;j++){
                    nutrient[i][j]+=s2d2[i][j];
                }
            }
        }
        System.out.println(trees.size());
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}