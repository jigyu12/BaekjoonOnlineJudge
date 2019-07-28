package 순열장난_10597;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	private static String[] permutation;
	private static boolean[] visited;
	private static String ans;
	private static boolean findans;
	private static void find(int idx, String s,int m) {
		int max = m;
		if(idx >= permutation.length) {
			boolean all = true;
			for(int i = 1; i <= m; i++) {
				if(!visited[i]) {
					all = false;
				}
			}
			if(!all) {
				return;
			}
			ans = s;
			findans = true;
			return ;
		}
		
		StringBuilder sb = new StringBuilder(s);
		int cur = Integer.parseInt(permutation[idx]);
		int next = 0;
		if(idx  < permutation.length-1 && cur > 0) {
			next = cur*10+Integer.parseInt(permutation[idx+1]);
		}
		
		if(cur > 0 && !visited[cur]) {
			if(max < cur) {
				max = cur;
			}
			visited[cur] = true;
			sb.append(cur + " ");
			find(idx+1,sb.toString(),max);
			sb.deleteCharAt(sb.lastIndexOf(" "));
			sb.deleteCharAt(sb.lastIndexOf(String.valueOf(cur)));
			visited[cur] = false;
		}
		
		if(findans) {
			return ;
		}
		max = m;
		
		if(10 <= next && next <= 50 && !visited[next]) {
			if(max < next) {
				max = next;
			}
			visited[next] = true;
			sb.append(next + " ");
			find(idx+2,sb.toString(),max);
			sb.deleteCharAt(sb.lastIndexOf(" "));
			sb.deleteCharAt(sb.lastIndexOf(String.valueOf(next)));
			visited[next] = false;
		}
		if(findans) {
			return ;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		permutation = br.readLine().split("");
		visited = new boolean[51];
		visited[0] = true;
		ans = "";
		findans = false;
		find(0,"",0);
		System.out.println(ans);
	}
}
