import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean[][] map = new boolean[102][102]; //true이면 검정 스카프가 있는 부분
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine()), answer = 0;
		// 검정 스카프의 위치를 입력받고, 검정 스카프가 있는 곳을 모두 채움
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			// 입력받은 시작 좌표부터 가로, 세로 10칸씩 채우기
			for(int r=0;r<10;r++) {
				for(int c=0;c<10;c++) {
					map[a+r][b+c] = true;
				}
			}
		}
		
		// 흰 스카프의 영역을 가로로 한번, 세로로 한번 전부 탐색하며
		// 검정 -> 하양으로 바뀌는 부분과 하양 -> 검정으로 바뀌는 부분은 테두리이므로 1씩 더해줌
		for(int r=1;r<102;r++) {
			for(int c=1;c<102;c++) {
				if(map[r][c]!=map[r][c-1]) answer++;
				if(map[c][r]!=map[c-1][r]) answer++;
			}
		}
		
		// 정답 출력
		bw.write(Integer.toString(answer));
		bw.flush();
	}

}
