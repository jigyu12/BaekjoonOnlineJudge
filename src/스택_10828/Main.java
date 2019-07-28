package 스택_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int[] st;
	private static int top;
	
	private static void push(int a) {
		st[++top] = a;
	}
	
	private static void pop () {
		if(top >= 0) {
			System.out.println(st[top--]);
		}
		else if(top < 0){
			System.out.println("-1");
		}
		 
	}
	
	private static void size() {
		System.out.println(top+1);
	}
	
	private static void empty(){
		if(top >= 0) {
			System.out.println("0");
		}
		else if(top < 0){
			System.out.println("1");
		}
	}
	
	private static void top() {
		if(top >= 0) {
			System.out.println(st[top]);
		}
		else if(top < 0){
			System.out.println("-1");
		}
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			st = new int[10001];
			top = -1;
			for(int i = 0; i < num ; i++) {
				String[] s = br.readLine().split(" ");
				switch(s[0]) {
				case "push":
					push(Integer.parseInt(s[1]));
					break;
				case "top":
					top();
					break;
				case "pop":
					pop();
					break;
				case "size":
					size();
					break;
				case "empty":
					empty();
					break;
				}
			}
		} catch (NumberFormatException | IOException e) {
		}
		
	}

}
