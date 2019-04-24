package 게임개발_1516;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main { 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test = Integer.parseInt(br.readLine());
		int[] ans = new int[test];
		int[] cost = new int[test];
		int[] indegree = new int[test];
		
		Queue<Integer> qu = new LinkedList<Integer>();
		ArrayList<Integer>[] ar = new ArrayList[test];
		for(int i = 0; i < test; i++) {
			ar[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < test; i++) {
			String[] s = br.readLine().split(" ");
			ans[i] = 0;
			cost[i] = Integer.parseInt(s[0]);
			for(int j = 1; j < s.length-1; j++) {
				ar[Integer.parseInt(s[j])-1].add(i);
				indegree[i]++;
			}
		}

		for(int i = 0; i < test; i++) {
			for(int j = 0; j < test; j++) {
				if(indegree[j] == 0) {
					qu.add(j);
					indegree[j] = -1;
				}
			}
			
			while(!qu.isEmpty()) {
				int a = qu.poll();
				ans[a] += cost[a];
				for(int b = 0; b < ar[a].size(); b++) {
					if(ans[a] > ans[ar[a].get(b)]) {
						ans[ar[a].get(b)] = ans[a];
					}
					indegree[ar[a].get(b)]--;
				}
			}
		}
		for(int i = 0; i < test; i++) {
			bw.write(ans[i]+"\n");
		}
		bw.flush();
	}
}
