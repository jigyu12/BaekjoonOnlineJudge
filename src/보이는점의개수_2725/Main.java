package 보이는점의개수_2725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[][] visited = new boolean[1001][1001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		

		
		for(int i = 1; i <= 1000; i++) {
			for(int j = 1; j <= 1000; j++) {
				int a = i+i, b = j+j;
				while(a <= 1000 && b <= 1000) {
					if(!visited[a][b]) {
						visited[a][b] = true;
					}
					a+=i;
					b+=j;
				}
			}
		}
		
		int num = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < num; t++) {
			int ans = 2;
			
			int n = Integer.parseInt(br.readLine());
			
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(!visited[i][j]) {
						ans++;
					}
				}
			}

			bw.write(ans+"\n");
		}
		bw.flush();
	}
	
}

