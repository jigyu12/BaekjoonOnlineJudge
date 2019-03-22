package MissingRunners_16546;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		boolean[] ar = new boolean[num+1];

		ar[0] = true;
		for(int i = 0; i < num-1; i++) {
			ar[Integer.parseInt(s[i])] = true;
		}
		int ans = -1;
		for(int i = 0; i < num+1; i++) {
			if(!ar[i]) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}
