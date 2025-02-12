// 민정님 코드 수정
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		// 사각형을 만들고 연속되는 수를 최소화하면 됨. 회전이 안되니 쉬움
		// 사격형은 규칙이 있음.
		// 1 2 3 4 5 / 1 / 2 3 4 5  1 / 2 / 3 4 5  1 2 / 3/ 4 5  1 2 3 /4/ 5
		
		// 1 2 3 4/ 1/ 2 3 4 1 /2/ 3 4 1 2 /3/ 4
		// 1 4 1 1     1 n 1 1
		// 6 9 2 1     2+n 2n+1 2 1
		// 11 14 3 1   3+2n 3n+2 3 1
		// 5 5 4 1     n+1 n+1 4 1
		// 10 10 4 2   2n+2
		// 15 15 4 3  3n+3
		// 16 16 4 4  3n+4

		StringBuilder sb= new StringBuilder();
		sb.append(2*(n-1)+1).append("\n");
		for(int i=1; i<n; i++){
			sb.append(i+(i-1)*n).append(" ").append((i-1)+i*n).append(" ").append(i).append(" ").append("1").append("\n");
		}
		for(int i=1; i<n; i++){
			sb.append(i*n+i).append(" ").append(i*n+i).append(" ").append(n).append(" ").append(i+1).append("\n");
		}
		sb.append((n-1)*n+n).append(" ").append((n-1)*n+n).append(" ").append(n).append(" ").append(1);

		System.out.println(sb);
	}
}