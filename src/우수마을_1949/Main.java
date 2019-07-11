package 우수마을_1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	private static int n;
	private static int[] popul;
	private static ArrayList<Integer> map[];
	private static ArrayList<Integer> tree[];
	private static boolean[] visited;
	
	private static void makeTree(int n) {
		for(int i = 0; i < map[n].size(); i++) {
			int num = map[n].get(i);
			if(!visited[num]) {
				tree[n].add(num);
				visited[num] = true;
				makeTree(num);
			}
		}
	}
	
	private static int find(int v, boolean prev) {

		int cost = 0;
		
		for(int i = 0; i < tree[v].size(); i++) {
			int num = tree[v].get(i);
			if(!prev) {
				cost += Math.max(find(num,false), find(num,true) + popul[num]);
			}
			else {
				cost += find(num,!prev);
			}
		}
		
		return cost;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		popul = new int[n+1];
		map = new ArrayList[n+1];
		tree = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		String[] s = br.readLine().split(" ");
		
		for(int i = 1; i <= n; i++) {
			popul[i] = Integer.parseInt(s[i-1]);
			map[i] = new ArrayList<>();
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < n-1; i++) {
			String[] ss = br.readLine().split(" ");
			int st = Integer.parseInt(ss[0]);
			int ed = Integer.parseInt(ss[1]);
			
			map[st].add(ed);
			map[ed].add(st);
		}
		
		visited[1] = true;
		makeTree(1);
		
		System.out.println(Math.max(find(1,false), find(1,true) + popul[1]));
	} 
}
