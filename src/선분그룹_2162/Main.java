package 선분그룹_2162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static class Edge {
		int num;
		long x1;
		long y1;
		long x2;
		long y2;

		public Edge(int num, long x1, long y1, long x2, long y2) {
			this.num = num;
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		@Override
		public String toString() {
			return "Edge [num=" + num + ", x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
		}
	}

	private static void init(int i) {
		parent[i] = i;
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(size[x] > size[y]) {
			size[x] += size[y];
			size[y] = 0;
			parent[y] = x;
		}
		else {
			size[y] += size[x];
			size[x] = 0;
			parent[x] = y;
		}
	}

	private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long t = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
		return (t > 0) ? 1 : (t < 0) ? -1 : 0;
	}

	private static boolean check(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
		if (x1 == x2 && x2 == x3 && x3 == x4 && x4 == x1) {
			long maxi = y1 > y2 ? y1 : y2;
			long minj = y3 < y4 ? y3 : y4;
			if (minj > maxi) {
				return false;
			}
			long mini = y1 < y2 ? y1 : y2;
			long maxj = y3 > y4 ? y3 : y4;
			if (mini > maxj) {
				return false;
			}
		} else if (y1 == y2 && y2 == y3 && y3 == y4 && y4 == y1) {
			long maxi = x1 > x2 ? x1 : x2;
			long minj = x3 < x4 ? x3 : x4;
			if (minj > maxi) {
				return false;
			}
			long mini = x1 < x2 ? x1 : x2;
			long maxj = x3 > x4 ? x3 : x4;
			if (mini > maxj) {
				return false;
			}
		}
		return true;
	}

	private static int parent[];
	private static int size[];
	private static Edge ar[];

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		try {
			num = Integer.parseInt(br.readLine());
			parent = new int[num];
			ar = new Edge[num];
			size = new int[num];
			Arrays.fill(size, 1);
			Arrays.fill(parent, -1);
			for (int i = 0; i < num; i++) {
				init(i);
				String[] s = br.readLine().split(" ");
				ar[i] = new Edge(i, Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]),
						Integer.parseInt(s[3]));
			}

			for (int i = 0; i < num; i++) {
				for (int j = i+1; j < num; j++) {
					if (ccw(ar[i].x1, ar[i].y1, ar[i].x2, ar[i].y2, ar[j].x1, ar[j].y1)
							* ccw(ar[i].x1, ar[i].y1, ar[i].x2, ar[i].y2, ar[j].x2, ar[j].y2) <= 0
							&& ccw(ar[j].x1, ar[j].y1, ar[j].x2, ar[j].y2, ar[i].x1, ar[i].y1)
									* ccw(ar[j].x1, ar[j].y1, ar[j].x2, ar[j].y2, ar[i].x2, ar[i].y2) <= 0) {
						boolean b = check(ar[i].x1, ar[i].y1, ar[i].x2, ar[i].y2, ar[j].x1, ar[j].y1, ar[j].x2,
								ar[j].y2);
						if (!b) {
							continue;
						}

						union(ar[i].num, ar[j].num);

					}
				}
			}
			int[] count = new int[num];
			int c = 0;
//			for(int i = 0; i < num; i++) {
//				 count[size[i]]++;
//			}
			int max = 0;
			for (int i = 0; i < num; i++) {
				if (size[i] > 0) {
					c++;
				}
				if (size[i] > max) {
					max = size[i];
				}
			}

			System.out.println(c);
			System.out.println(max);
		} catch (NumberFormatException | IOException e) {
		}
	}
}
