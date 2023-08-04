import java.io.*;
import java.util.*;
public class Main {
	static class Box implements Comparable<Box>{
		int z, sx, sy, ex, ey;

		public Box(int z, int sx, int sy, int ex, int ey) {
			this.z = z;
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}

		@Override
		public int compareTo(Box o) {
			return z>o.z?-1:1;
		}

		boolean collide(int px, int lx, int py, int ly){
			return Math.max(0, Math.min(ex, px+lx) - Math.max(sx, px))*Math.max(0, Math.min(ey, py+ly) - Math.max(sy, py))>0;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int LX = Integer.parseInt(st.nextToken()), LY = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		ArrayList<Box> boxes = new ArrayList<>();
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken()), ly = Integer.parseInt(st.nextToken()), lz = Integer.parseInt(st.nextToken());
			int px = Integer.parseInt(st.nextToken()), py = Integer.parseInt(st.nextToken());
			for(Box box:boxes){
				if(box.collide(px,lx,py,ly)){
					lz += box.z;
					break;
				}
			}
			Box b = new Box(lz,px,py,px+lx,py+ly);
			boxes.add(Collections.binarySearch(boxes,b)*-1-1,b);
		}
		bw.write(Integer.toString(boxes.get(0).z));
		bw.flush();
	}
}