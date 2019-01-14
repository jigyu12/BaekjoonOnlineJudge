package 전화번호목록_5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static class Node{
		String num;
		Node next;
		
		public Node(String num, Node next) {
			super();
			this.num = num;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", next=" + next + "]";
		}
	}

	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for(int i = 0; i < t; i++) {
				int num = Integer.parseInt(br.readLine());
				for(int j = 0; j < num; j++) {
					String[] s = br.readLine().split("");
					
				}
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
