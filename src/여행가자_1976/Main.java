package 여행가자_1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> map[] = new ArrayList[n+1]; 
		
		map[0] = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			map[i] = new ArrayList<>();
			for(int j = 1; j <= n; j++) {
				int num = Integer.parseInt(s[j-1]);
				if(num == 1 && j != i) {
					map[i].add(j);
				}
			}
		}
		
		String[] s = br.readLine().split(" ");
		
		boolean ans = true;
		
		for(int i = 0; i < m-1; i++) {
			int st = Integer.parseInt(s[i]);
			int end = Integer.parseInt(s[i+1]);

			Queue<Integer> qu = new LinkedList<>();
			qu.add(st);
			
			boolean[] visited = new boolean[n+1];
			visited[st] = true;
			boolean find = false;
			while(!qu.isEmpty()) {
				int nn = qu.poll();
				
				if(find) {
					break;
				}
				
				if(nn == end) {
					find = true;
					break;
				}
				
				for(int j = 0; j < map[nn].size(); j++) {
					int is = map[nn].get(j);
					if(!visited[is]) {
						if(is == end) {
							find = true;
							break;
						}
						else {
							qu.add(is);
							visited[is] = true;
						}
					}
				}
			}
			
			if(!find) {
				ans = false;
				break;
			}
		}
		
		if(ans) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
	}
}