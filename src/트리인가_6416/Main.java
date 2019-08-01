package 트리인가_6416;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	static class Indegree{
		int num;
		int cnt;
		
		public Indegree(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Indegree [num=" + num + ", cnt=" + cnt + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = 0;
		int count = 0;
		HashSet<Integer> hs = new HashSet<>();
		
		xx : while(true) {
			++k;
			hs.clear();
			count = 0;
			aa : while(true) {
				int st = sc.nextInt();
				int end = sc.nextInt();

				
				if(st == 0 && end == 0) {
					break aa;
				}
				
				if(st == -1 && end == -1) {
					break xx;
				}
				

				hs.add(st);
				hs.add(end);
				
				count++;
				
			
			}
			if(count == 0 || count + 1 == hs.size()) {
				bw.write("Case "+ k +" is a tree.\n");
			}
			else {
				bw.write("Case "+ k +" is not a tree.\n");
			}

		}
		bw.flush();
	}
}
