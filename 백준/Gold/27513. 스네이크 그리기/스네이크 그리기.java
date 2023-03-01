import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		bw.write(Integer.toString(R*C%2==1?R*C-1:R*C));
		if(R%2==0){
			int r = 0, c = 1;
			for(;r<R;) print(++r,c);
			for(;r>=1;){
				for(;c<C;) print(r,++c);
				print(--r,c);
				for(;c>2;) print(r,--c);
				if(--r!=0) print(r,c);
			}
		}else if(C%2==0){
			int c = 0, r = 1;
			for(;c<C;) print(r,++c);
			for(;c>=1;){
				for(;r<R;) print(++r,c);
				print(r,--c);
				for(;r>2;) print(--r,c);
				if(--c!=0) print(r,c);
			}
		}else{
			int r = 1, c = 1;
			for(;c<C;) print(r,++c);
			for(;c>3;){
				for(;r<R;) print(++r,c);
				print(r,--c);
				for(;r>2;) print(--r,c);
				print(r,--c);
			}
			for(;r<R;) print(++r,c);
			c--;
			for(;r>1;){
				print(r,c--);
				print(r--,c);
				print(r,c++);
				print(r--,c);
			}
		}
		bw.flush();
	}
	static void print(int r, int c) throws Exception {
		bw.write("\n");
		bw.write(Integer.toString(r));
		bw.write(" ");
		bw.write(Integer.toString(c));
	}
}