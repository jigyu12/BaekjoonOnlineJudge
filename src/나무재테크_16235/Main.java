package ��������ũ_16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;
		
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", age=" + age + "]";
		}

		@Override
		public int compareTo(Tree o) {
			if(this.x == o.x) {
				if(this.y == o.y) {
					return this.age - o.age;
				}
				return this.y - o.y;
			}
			return this.x - o.x;
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmk = br.readLine().split(" ");
		
		int n = Integer.parseInt(nmk[0]);
		int m = Integer.parseInt(nmk[1]);
		int k = Integer.parseInt(nmk[2]);
		
		int[][] map = new int[n+2][n+2];
		int[][] nutri = new int[n+2][n+2];
		
		Queue<Tree> tree = new LinkedList<>();
		for(int i = 0; i <= n+1; i++) {
			Arrays.fill(nutri[i], -1);
		}
		
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= n; j++) {
				nutri[i][j] = 5;
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		for(int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			int z = Integer.parseInt(s[2]);
			tree.add(new Tree(x,y,z));
		}
		
		
		for(int w = 1; w <= k; w++) {
			int size = tree.size();
			int[][] dead = new int[n+2][n+2];
			ArrayList<Tree> ar = new ArrayList<>();
			
			for(int i = 0; i < size; i++) {
				ar.add(tree.poll());
			}
			Collections.sort(ar);
			for(int i = 0; i < size; i++) {
				Tree t = ar.get(i);
				int tx = t.x;
				int ty = t.y;
				int ta = t.age;
				
				if(nutri[tx][ty] >= ta) {
					nutri[tx][ty] -= ta;
					ta++;
					tree.add(new Tree(tx,ty,ta));
				}
				
				else {
					dead[tx][ty] += (ta / 2);
					continue;
				}
				
				if(ta % 5 == 0) {
					if(nutri[tx-1][ty] > -1) {
						tree.add(new Tree(tx-1,ty,1));
					}
					if(nutri[tx+1][ty] > -1) {
						tree.add(new Tree(tx+1,ty,1));
					}
					if(nutri[tx][ty-1] > -1) {
						tree.add(new Tree(tx,ty-1,1));
					}
					if(nutri[tx][ty+1] > -1) {
						tree.add(new Tree(tx,ty+1,1));
					}
					if(nutri[tx-1][ty-1] > -1) {
						tree.add(new Tree(tx-1,ty-1,1));
					}
					if(nutri[tx-1][ty+1] > -1) {
						tree.add(new Tree(tx-1,ty+1,1));
					}
					if(nutri[tx+1][ty-1] > -1) {
						tree.add(new Tree(tx+1,ty-1,1));
					}
					if(nutri[tx+1][ty+1] > -1) {
						tree.add(new Tree(tx+1,ty+1,1));
					}
					
				}
			}
			if(w < k) {
				for(int i = 1; i <= n; i++) {
					for(int j = 1; j <= n; j++) {
						nutri[i][j] += (map[i][j] + dead[i][j]);
					}
				}
			}
		}
		System.out.println(tree.size());
	}
}