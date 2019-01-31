package 다각형의면적_2166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	static class Point implements Comparable<Point>{
		long x;
		long y;
		
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if(o.x == this.x) {
				return (int) (o.y - this.y);
			}
			return (int) (o.x - this.x);
		}

		
		
	}
	
	public static int ccw(long ax, long ay, long bx, long by, long cx, long cy) {
		long t = (ax * by + bx * cy + cx * ay) - (ay * bx + by * cx + cy * ax);
		return t > 0 ? 1 : t < 0 ? -1 : 0; 
	}
	
	public static int ccw(Point A,Point B) {
		return ccw(0,0,A.x,A.y,B.x,B.y);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			Point[] ar = new Point[num];
			for(int i = 0; i < num; i++) {
				String[] s = br.readLine().split(" ");
				ar[i] = new Point(Long.parseLong(s[0]),Long.parseLong(s[1]));
			}
			Arrays.sort(ar);
			long sum = 0;
			for(int i = 0; i < num; i++) {
				if(i < num - 1) {
					int ccw = ccw(ar[i],ar[i+1]);
					switch(ccw) {
					case -1:
						long width1 = ar[i].x * ar[i+1].y - ar[i].y * ar[i+1].x;
						sum += Math.abs(width1);
						break;
					case 1:
						long width2 = ar[i].x * ar[i+1].y - ar[i].y * ar[i+1].x;
						sum += Math.abs(width2);
						break;
					}
				}
				else {
					int ccw = ccw(ar[i],ar[0]);
					switch(ccw) {
					case -1:
						long width1 = ar[i].x * ar[0].y - ar[i].y * ar[0].x;
						sum += Math.abs(width1);
						break;
					case 1:
						long width2 = ar[i].x * ar[0].y - ar[i].y * ar[0].x;
						sum += Math.abs(width2);
						break;
					}
				}
				
			}
			double ans = sum / 2;
			System.out.format("%.1f\n", ans);
		} catch (NumberFormatException | IOException e) {}
	}
}
