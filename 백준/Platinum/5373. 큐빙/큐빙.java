import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1
//4
//U- D- L+ R+
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static char[][][] cube;
    static int[][][] rotateInfo =  {{{1,0,0},{1,0,1},{1,0,2},{2,0,0},{2,0,1},{2,0,2},{3,0,0},{3,0,1},{3,0,2},{5,2,2},{5,2,1},{5,2,0}},
					    		{{0,2,0},{0,1,0},{0,0,0},{5,2,0},{5,1,0},{5,0,0},{4,2,0},{4,1,0},{4,0,0},{2,2,0},{2,1,0},{2,0,0}},
					    		{{0,2,2},{0,2,1},{0,2,0},{1,0,2},{1,1,2},{1,2,2},{4,0,0},{4,0,1},{4,0,2},{3,2,0},{3,1,0},{3,0,0}},
					    		{{0,0,2},{0,1,2},{0,2,2},{2,0,2},{2,1,2},{2,2,2},{4,0,2},{4,1,2},{4,2,2},{5,0,2},{5,1,2},{5,2,2}},
					    		{{3,2,2},{3,2,1},{3,2,0},{2,2,2},{2,2,1},{2,2,0},{1,2,2},{1,2,1},{1,2,0},{5,0,0},{5,0,1},{5,0,2}},
					    		{{1,2,0},{1,1,0},{1,0,0},{0,0,0},{0,0,1},{0,0,2},{3,0,2},{3,1,2},{3,2,2},{4,2,2},{4,2,1},{4,2,0}}};
    public void spin(char[] direction) {
    	int side = "ULFRDB".indexOf(direction[0]), rotate = "+-".indexOf(direction[1]);
    	char[][] tmpSide= new char[3][3];
    	char[] tmpLine = new char[3];
		int[][] xyz = rotateInfo[side];
    	if(rotate==0) {
	    	for(int i=0;i<3;i++) {
	    		for(int j=0;j<3;j++) {
	    			tmpSide[j][2-i]=cube[side][i][j];
	    		}
	    	}
	    	for(int i=0;i<3;i++) {
	    		tmpLine[i] = cube[xyz[i][0]][xyz[i][1]][xyz[i][2]];
	    		for(int j=1;j<4;j++) {
	    			cube[xyz[3*(j-1)+i][0]][xyz[3*(j-1)+i][1]][xyz[3*(j-1)+i][2]]=cube[xyz[3*j+i][0]][xyz[3*j+i][1]][xyz[3*j+i][2]];
	    		}
	    		cube[xyz[9+i][0]][xyz[9+i][1]][xyz[9+i][2]]=tmpLine[i];
	    	}
    	}else {
    		for(int i=0;i<3;i++) {
	    		for(int j=0;j<3;j++) {
	    			tmpSide[2-j][i]=cube[side][i][j];
	    		}
	    	}
	    	for(int i=0;i<3;i++) {
	    		tmpLine[i] = cube[xyz[9+i][0]][xyz[9+i][1]][xyz[9+i][2]];
	    		for(int j=3;j>0;j--) {
	    			cube[xyz[3*j+i][0]][xyz[3*j+i][1]][xyz[3*j+i][2]]=cube[xyz[3*(j-1)+i][0]][xyz[3*(j-1)+i][1]][xyz[3*(j-1)+i][2]];
	    		}
	    		cube[xyz[i][0]][xyz[i][1]][xyz[i][2]]=tmpLine[i];
	    	}
    	}
    	cube[side]=tmpSide;
    }
    public void solution() throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test<=T; test++) {
        	cube = new char[][][] 
        			{{{'w','w','w'},{'w','w','w'},{'w','w','w'}},
	        		 {{'g','g','g'},{'g','g','g'},{'g','g','g'}},
	        		 {{'r','r','r'},{'r','r','r'},{'r','r','r'}},
	        		 {{'b','b','b'},{'b','b','b'},{'b','b','b'}},
	        		 {{'y','y','y'},{'y','y','y'},{'y','y','y'}},
	        		 {{'o','o','o'},{'o','o','o'},{'o','o','o'}}};
        	int n = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) {
        		spin(st.nextToken().toCharArray());
        	}
        	for(int i=0;i<3;i++) {
        		for(int j=0;j<3;j++) {
        			sb.append(cube[0][i][j]);
        		}
    			sb.append("\n");
        	}
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
