package 전화번호목록_5052no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static class Trie {

		Trie[] tr;
		boolean[] b;

		public Trie get(int num) {
			return tr[num];
		}

		public Trie() {
			tr = new Trie[10];
			b = new boolean[10];
		}

	}

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				Trie trie = new Trie();
				int num = Integer.parseInt(br.readLine());
				boolean find = false;
				for (int j = 0; j < num; j++) {
					String[] ss = br.readLine().split("");
					if(find) {
						continue;
					}
					int[] s = new int[ss.length];
					for (int k = 0; k < ss.length; k++) {
						s[k] = Integer.parseInt(ss[k]);
					}
					Trie tt = trie;
					for (int k = 0; k < s.length; k++) {
						if(tt.b[s[k]]) {
							find = true;
							break;
						}
						if (tt.tr[s[k]] == null) {
							tt.tr[s[k]] = new Trie();
							if (k == s.length - 1) {
								tt.b[s[k]] = true;
							}
							tt = tt.tr[s[k]];

						} 
						else {
							tt = tt.tr[s[k]];
						}
						
						if (k == s.length - 1 && tt.tr[s[k]] != null) {
							find = true;
							
							break;
						}
					}
				}
				if(!find) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}

		} catch (NumberFormatException | IOException e) {
		}
	}
}
