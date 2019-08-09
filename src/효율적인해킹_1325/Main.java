package 효율적인해킹_1325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	private static int n;
	private static int m;
	private static int[] count;
	
	private static ArrayList<Integer> ar[];
	
	private static int find(int son) {
			
		count[son] = 0;
		
		int size = ar[son].size();
		
		for(int i = 0; i < size; i++) {
			int num = ar[son].get(i);
			if(count[num] == -1) {
				count[son] += (find(num) + 1);
			}
			else {
				count[son] += (count[num] + 1);
			}
		}

		return count[son];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nm = br.readLine().split(" ");
		
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		ar = new ArrayList[n+1];
		count = new int[n+1];

		Arrays.fill(count, -1);
		for(int i = 0; i < n+1; i++) {
			ar[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			ar[b].add(a);
		}
		
		
		for(int i = 1; i <= n; i++) {
			if(count[i] == -1) {
				count[i] = find(i);
			}
		}
		
		int max = 0;
		
		for(int i = 1; i < count.length; i++) {
			if(count[i] > max) {
				max = count[i];
			}
		}

		for(int i = 1; i < count.length; i++) {
			if(count[i] == max) {
				bw.write(i + " ");
			}
		}
		bw.flush();
	}
}
