package ť_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int[] qu;
	private static int front;
	private static int back;
	private static int size;
	
	private static void push(int a) {
		qu[back++] = a;
	}
	
	private static void pop () {
		if(size == 0) {
			System.out.println("-1");
		}
		else if(size > 0) {
			 System.out.println(qu[front++]);
		}
	}
	
	private static void size() {
		System.out.println(size);
	}
	
	private static void empty(){
		if(size == 0) {
			System.out.println("1");
		}
		else if(size > 0) {
			System.out.println("0");
		}
	}
	
	private static void front() {
		if(size == 0) {
			System.out.println("-1");
		}
		else if(size > 0) {
			System.out.println(qu[front]);
		}
	}
	
	private static void back() {
		if(size == 0) {
			System.out.println("-1");
		}
		else if(size > 0) {
			System.out.println(qu[back-1]);
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			qu = new int[10001];
			front = 0;
			back = 0;
			for(int i = 0; i < num ; i++) {
				size = back - front;
				String[] s = br.readLine().split(" ");
				switch(s[0]) {
				case "push":
					push(Integer.parseInt(s[1]));
					break;
				case "front":
					front();
					break;
				case "back":
					back();
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
