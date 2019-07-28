package 오큰수_17298;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int ar[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(s[i]);
		}
		
		int ans[] = new int[n];

		Stack<Integer> st = new Stack<>();

		for(int i = n-1; i >= 0; i--) {
			while(!st.isEmpty() && st.peek() <= ar[i]) {
				st.pop();
			}
			
			if(!st.isEmpty()) {
				ans[i] = st.peek();
			}
			
			st.add(ar[i]);
		}
		
		for(int i = 0; i < n; i++) {
			if(ans[i] != 0) {
				bw.write(ans[i] + " ");
			}
			else {
				bw.write("-1 ");
			}
		}
		bw.flush();
	}
}
