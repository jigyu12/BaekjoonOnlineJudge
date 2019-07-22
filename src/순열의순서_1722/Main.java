package 순열의순서_1722;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[] ar;
	static long[] mul;
	static long order;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		mul = new long[21];
		mul[1] = 1;
		
		for(int i = 2; i <= 20; i++) {
			mul[i] = mul[i-1] * i;
		}

		n = Integer.parseInt(br.readLine());
		ar = new int[n];
		
		visited = new boolean[n+1];
		String[] s = br.readLine().split(" ");
		
		int command = Integer.parseInt(s[0]);
		if(command == 1) {
			order = Long.parseLong(s[1]);
			findArray(1);
		}
		else {
			for(int i = 1; i <= n; i++) {
				ar[i-1] = Integer.parseInt(s[i]);
			}
			long ans = 1;
			int cal = n-1;
			
			for(int i = 0; i < n ; i++) {
				int cnt = 1;
				for(int j = 1; j <= n; j++) {
					if(visited[j]) {
						continue;
					}
					if(!visited[j] && j == ar[i]) {
						ans += (mul[cal] * (cnt - 1));
						cal--;
						visited[j] = true;
						break;
					}
					cnt++;
				}
			}
			bw.write(ans+"\n");
		}
		bw.flush();
	}
	
	static void findArray(int idx) throws IOException {
		
		if(idx == n) {
			for(int i = 1; i <= n; i++) {
				if(!visited[i]) {
					bw.write(i+" ");
					return ;
				}
			}
		}
		long cal = mul[n-idx];
		int cnt = 1;
		for(int i = 1; i <= n; i++) {
			if(visited[i]) {
				continue;
			}
			if(order <= cal * cnt) {
				visited[i] = true;
				order -= cal * (cnt - 1);
				bw.write(i+" ");
				findArray(idx+1);
				break;
			}
			cnt++;
		}
		
	}

}
