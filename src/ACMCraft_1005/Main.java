package ACMCraft_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	private static int[] ar;
	private static ArrayList<Integer>[] dest;
	private static int ans;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 0; i < test; i++) {
				String[] nk = br.readLine().split(" ");
				int n = Integer.parseInt(nk[0]);
				int k = Integer.parseInt(nk[1]);
				ar = new int[n+1];
				int sum[] = new int[n+1];
				dest = new ArrayList[n+1];
				int indegree[] = new int[n+1];
				ans = 0;
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < s.length; j++) {
					ar[j+1] = Integer.parseInt(s[j]);
					sum[j+1] = ar[j+1];
					dest[j+1] = new ArrayList<Integer>();
				}
				
				for(int j = 0; j < k; j++) {
					String[] ss = br.readLine().split(" ");
					int a = Integer.parseInt(ss[0]);
					int b = Integer.parseInt(ss[1]);
					dest[a].add(b);
					indegree[b]++;
				}
				
				Queue<Integer> qu = new LinkedList<Integer>();
				for(int j = 1; j <= n; j++) {
					for(int z = 1; z <= n; z++) {
						if(indegree[z] == 0) {
							qu.add(z);
							indegree[z] = -1;
						}
					}
					
					while(!qu.isEmpty()) {
						int num = qu.poll();
						for(int z = 0; z < dest[num].size(); z++) {
							if(sum[dest[num].get(z)] < sum[num] + ar[dest[num].get(z)]) {
								sum[dest[num].get(z)] = sum[num] + ar[dest[num].get(z)];
							}
							indegree[dest[num].get(z)]--;
						}
					}
					
				}	
				int start = Integer.parseInt(br.readLine());
				System.out.println(sum[start]);
			}
		} 
		catch (NumberFormatException | IOException e) {}
	}
}
