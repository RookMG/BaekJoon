import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, K, D, answer;

	static class Student implements Comparable<Student>{
		int tier, know;

		Student(int tier,int know){
			this.tier = tier;
			this.know = know;
		}

		@Override
		public int compareTo(Student o) {
			return Integer.compare(tier,o.tier);
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		Student[] students = new Student[N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()), know = 0, tier = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				know |= (1<<Integer.parseInt(st.nextToken()));
			}
			students[i] = new Student(tier,know);
		}
		Arrays.sort(students);
		int[] know = new int[K+1];
		for(int left = 0, right = 0;left<=right&&right<N;){
			int lt = students[left].tier, rt = students[right].tier;
			if(rt-lt>D){
				int lknow = students[left].know;
				for(int i=1;i<=K;i++){
					if(((1<<i)&lknow)!=0) know[i]--;
				}
				left++;
			}else {
				int rknow = students[right].know, score = 0;
				for (int i = 1; i <= K; i++) {
					if (((1 << i) & rknow) != 0) know[i]++;
					if (know[i] > 0 && know[i] < right - left + 1) score++;
				}
				answer = Math.max(answer, (right - left + 1) * score);
				right++;
			}

		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}