package 전공책_16508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static int[][] bookar;
	private static int[] inputar;
	private static int limit;
	private static boolean findans;
	private static int ans;
	private static int num;
	private static Book[] b;
	
	static class Book implements Comparable<Book>{
		int money;
		String name;
		
		public Book(int money, String name) {
			this.money = money;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Book [money=" + money + ", name=" + name + "]";
		}

		@Override
		public int compareTo(Book o) {
			return this.money - o.money;
		}
	}

	
	private static void dfs(int visit, int find, int cost, int start) {
		
		if(visit == limit || ans < cost) {
			return ;
		}
		
		int f = find;
		int c = cost;
		boolean add = false;
		
		for(int i = 0; i < inputar.length; i++) {
			if(bookar[start][inputar[i]] > 0 && ((f & (1 << i)) == 0)) {
				bookar[start][inputar[i]]--;
				f |= (1 << i);
				add = true;
			}
		}
		
		if(add) {
			c += b[start].money;
		}
		
		if(f == (1 << inputar.length) - 1) {
			findans = true;
			if(ans > c) {
				ans = c;	
			}
			return;
		}
		
		for(int i = start+1; i < num; i++) {
			dfs(visit+1,f,c,i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputs = br.readLine();
		findans = false;
		inputar = new int[inputs.length()];
		
		for(int i = 0; i < inputs.length(); i++) {
			inputar[i] = (inputs.charAt(i) - 65);
		}
		
		num = Integer.parseInt(br.readLine());
		b = new Book[num];
		int[][] copy = new int[num][26];
		
		bookar = new int[num][26];
		ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < num; i++) {
			String[] s = br.readLine().split(" ");
			b[i] = new Book(Integer.parseInt(s[0]),s[1]);
		}
		
		Arrays.sort(b);
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < b[i].name.length(); j++) {
				++copy[i][b[i].name.charAt(j) - 65];
			}
		}
		
		for(int i = 1; i <= num; i++) {
			limit = i;
			
			for(int j = 0; j < num; j++) {
				for(int k = 0; k < num; k++) {
					for(int l = 0; l < 26; l++) {
						if(copy[k][l] > 0) {
							bookar[k][l] = copy[k][l];
						}
					}
				}
				dfs(0,0,0,j);
			}
		}
		
		if(!findans) {
			System.out.println("-1");
		}
		else {
			System.out.println(ans);
		}
	}
}
