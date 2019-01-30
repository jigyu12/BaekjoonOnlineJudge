package SuffixArray_9248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static class Sa implements Comparable<Sa> {
		int idx;
		int fr;
		int sr;

		public Sa(int idx, int fr, int sr) {
			this.idx = idx;
			this.fr = fr;
			this.sr = sr;
		}

		@Override
		public String toString() {
			return "Sa [idx=" + idx + ", fr=" + fr + ", sr=" + sr + "]";
		}

		@Override
		public int compareTo(Sa arg0) {
			if (this.fr == arg0.fr) {
				return this.sr - arg0.sr;
			}
			return this.fr - arg0.fr;
		}

	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = br.readLine();
			Sa[] ar = new Sa[500002];
			char[] ch = new char[500002];
			for (int i = 1; i <= s.length(); i++) {
				ch[i] = s.charAt(i - 1);
			}
			// 1. 첫 글자 기준으로 정렬
			for (int i = 1; i <= s.length(); i++) {
				ar[i] = new Sa(i, (ch[i] - 'a'), 0);
			}
			Arrays.sort(ar, 1, s.length()+1);

			int[] r = new int[500002];

			// 2. 2글자 ~ N글자 정렬
			for (int len = 1; len < s.length(); len <<= 1) {

				// 2-1 first rank 지장
				r[ar[1].idx] = 1;
				for (int i = 2; i <= s.length(); i++) {
					if (ar[i].fr == ar[i - 1].fr && ar[i].sr == ar[i - 1].sr) {
						r[ar[i].idx] = r[ar[i - 1].idx];
					} else {
						r[ar[i].idx] = r[ar[i - 1].idx] + 1;
					}
				}

				// 2-2 second rank 지정

				for (int i = 1; i <= s.length(); i++) {
					if (ar[i].idx + len <= s.length()) {
						ar[i] = new Sa(ar[i].idx, r[ar[i].idx], r[ar[i].idx + len]);
					} else {
						ar[i] = new Sa(ar[i].idx, r[ar[i].idx], 0);
					}
				}

				// 2-3 정렬
				Arrays.sort(ar, 1, s.length()+1);
			}

			// sa 계산, index 매핑
			int sa[] = new int[500002];
			for (int i = 1; i <= s.length(); i++) {
				sa[i] = ar[i].idx;
				r[sa[i]] = i;
			}

			for (int i = 1; i <= s.length(); i++) {
				System.out.print(r[i] + " ");
			}
			System.out.println();

			// lcp
			int x = 0;
			int m = 0;
			int[] lcp = new int[500002];
			for (int i = 1; i <= s.length(); i++) {
				if (x > 0) {
					x--;
				}
				m = sa[r[i]];
				while (ch[i + x] == ch[m + x] && ch[m + x] != ' ') {
					x++;
				}
				lcp[r[i]] = x;
			}
			
			for (int i = 1; i <= s.length(); i++) {
				System.out.print(lcp[i] + " ");
			}
			System.out.println();

		} catch (IOException e) {
		}
	}

}
