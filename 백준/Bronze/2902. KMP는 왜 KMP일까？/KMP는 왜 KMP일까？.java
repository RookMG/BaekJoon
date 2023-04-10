import java.io.*;

import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine(),"-");

while(st.hasMoreTokens()){

bw.write(st.nextToken().charAt(0));

}

bw.flush();

    }

}