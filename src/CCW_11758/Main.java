package CCW_11758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static class Point{
		long x;
		long y;
		
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static int ccw(long ax, long ay, long bx, long by, long cx, long cy) {
		long t = (ax * by + bx * cy + cx * ay) - (ay * bx + by * cx + cy * ax);
		return t > 0 ? 1 : t < 0 ? -1 : 0;
	}
	
	public static int ccw(Point A, Point B, Point C) {
		return ccw(A.x,A.y,B.x,B.y,C.x,C.y);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] s1 = br.readLine().split(" ");
			String[] s2 = br.readLine().split(" ");
			String[] s3 = br.readLine().split(" ");
			Point A = new Point(Long.parseLong(s1[0]),Long.parseLong(s1[1]));
			Point B = new Point(Long.parseLong(s2[0]),Long.parseLong(s2[1]));
			Point C = new Point(Long.parseLong(s3[0]),Long.parseLong(s3[1]));
			System.out.println(ccw(A,B,C));
		} catch (IOException e) {
		}
	}
}
