package 가장긴증가하는부분수열5_14003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	private static int[] position;
	private static int[] ar;
	private static ArrayList<Integer> ans;

	private static int binary(int n) {
		int start = 0;
		int end = ans.size() - 1;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			if (ans.get(mid) < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;

	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int num = Integer.parseInt(br.readLine());
			position = new int[num];
			ar = new int[num];
			ans = new ArrayList<Integer>();
			String[] s = br.readLine().split(" ");
			ans.add(Integer.parseInt(s[0]));
			position[0] = 0;
			for (int i = 0; i < num; i++) {
				ar[i] = Integer.parseInt(s[i]);
			}
			for (int i = 1; i < num; i++) {
				int n = ar[i];
				if (n > ans.get(ans.size() - 1)) {
					ans.add(n);
					position[i] = ans.size()-1;
				} 
				else {
					int k = binary(n);
					ans.add(k, n);
					position[i] = k;
					ans.remove(k + 1);
				}
			}

			StringBuilder sb = new StringBuilder();

			int cal = ans.size()-1;
			int[] fin = new int[ans.size()];
			for (int i = num-1; i >= 0; i--) {
				if(position[i] == cal) {
					fin[cal] = ar[i];
					cal--;
				}
				if(cal == -1) {
					break;
				}
			}
			for (int i = 0; i < fin.length; i++) {
				sb.append(fin[i] + " ");
			}
			bw.write(ans.size()+"\n");
			bw.write(sb.toString().trim()+"\n");
			bw.flush();
		} catch (NumberFormatException | IOException e) {
		}
	}
}
