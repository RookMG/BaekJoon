import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int[][] points = new int[3][2];
        for(int i=0;i<3;i++) {
        	points[i][0] = Integer.parseInt(st.nextToken());
        	points[i][1] = Integer.parseInt(st.nextToken());
        }
        double[] m = new double[3], c = new double[3];
        double sumX = 0, sumY = 0;
        Arrays.sort(points,(p1,p2)->{return p1[0]-p2[0];});
        for(int i=0;i<3;i++) {
        	m[i] = (double)(points[(i+1)%3][1]-points[i][1])/(points[(i+1)%3][0]-points[i][0]);
        	c[i] = points[i][1] - m[i]*points[i][0];
        	sumX += (points[(i+1)%3][0]-points[i][0])!=0?(Math.PI*(m[i]*m[i]*(Math.pow(points[(i+1)%3][0],3)-Math.pow(points[i][0],3))/3+m[i]*c[i]*(Math.pow(points[(i+1)%3][0],2)-Math.pow(points[i][0],2))+c[i]*c[i]*(points[(i+1)%3][0]-points[i][0]))):0;
        }
        for(int i=0;i<3;i++) {int tmp = points[i][1];points[i][1]=points[i][0];points[i][0]=tmp;}
        Arrays.sort(points,(p1,p2)->{return p1[0]-p2[0];});
        for(int i=0;i<3;i++) {
        	m[i] = (double)(points[(i+1)%3][1]-points[i][1])/(points[(i+1)%3][0]-points[i][0]);
        	c[i] = points[i][1] - m[i]*points[i][0];
        	sumY += (points[(i+1)%3][0]-points[i][0])!=0?(Math.PI*(m[i]*m[i]*(Math.pow(points[(i+1)%3][0],3)-Math.pow(points[i][0],3))/3+m[i]*c[i]*(Math.pow(points[(i+1)%3][0],2)-Math.pow(points[i][0],2))+c[i]*c[i]*(points[(i+1)%3][0]-points[i][0]))):0;
        }
        System.out.printf("%.9f %.9f\n",Math.abs(sumX),Math.abs(sumY));
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}