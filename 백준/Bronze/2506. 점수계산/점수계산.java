import java.io.*;

import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

int ans = 0, now =0, n=Integer.parseInt(br.readLine());

StringTokenizer st = new StringTokenizer (br.readLine());

		for(int i=0;i<n;i++) {

			if(Integer.parseInt(st.nextToken())==0){now=0;}

else ans+=++now;

		}

bw.write(Integer.toString(ans));

bw.flush();

	}

}