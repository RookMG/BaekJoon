import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        //입력 시작
        st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()), w=Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        Queue<Integer> q =new LinkedList<>();
        //트럭은 입력 순서대로 건너기 때문에 큐 사용
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            q.offer(Integer.parseInt(st.nextToken()));
        }
        //입력 끝

        LinkedList<int[]> bridge = new LinkedList<>();
        //다리 위에 있는 트럭을 확인하기 위해 LinkedList 생성
        //모든 내용에 접근해 위치를 수정하고(큐,스택,덱 부적합)
        //다리를 다 건넌 트럭을 제거해야 하기 때문에(ArrayList 부적합)
        //자료구조는 LinkedList 사용
        int total = 0, next, time = 0;
        
        for(;!q.isEmpty();time++){

            //우선 다리에 있는 트럭을 한칸씩 전진시키고 다리를 다 건넌 트럭은 제거
            for(int i=bridge.size()-1;i>=0;i--){
                int[] truck = bridge.get(i);
                //밑에서 트럭에는 {무게, 위치} 정보를 저장함

                if(++truck[1]==w){
                    //트럭이 다리를 다 건넜다면 다리 위 하중을 줄이고 트럭을 제거
                    total-=truck[0];
                    bridge.remove(i);
                    //트럭을 제거하면 bridge.size()가 줄어들기 때문에 for문을 역순으로 진행
                }
            }

            next = q.peek();
            //트럭을 다리에 올리기 전에 다리의 최대하중 체크를 먼저 하기 위해 일단 peek
            if(total+next<=L){
                //다리에 트럭을 올려도 최대 하중 초과가 아니라면

                //트럭 무게만큼 다리 위 하중을 늘리고 다리를 건너는 트럭 목록에 추가
                total+=next;
                bridge.add(new int[]{q.poll(),0});
            }
        }
        if(!bridge.isEmpty()){time+=(w-bridge.get(bridge.size()-1)[1]);}
        System.out.println(time);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}