package 이진검색트리_5639;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class Main {
	
	private static Tree t;
	private static BufferedWriter bw;
	
	static class Tree{
		int num;
		Tree left;
		Tree right;
		
		public Tree(int num, Tree left, Tree right) {
			this.num = num;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Tree [num=" + num + ", left=" + left + ", right=" + right + "]";
		}

	}
	
	private static void makeTree(Tree cur, Tree ins) {
		
		if(cur.num > ins.num) {
			if(cur.left == null) {
				cur.left = new Tree(ins.num,null,null);
			}
			else {
				makeTree(cur.left, ins);
			}
		}
		else {
			if(cur.right == null) {
				cur.right = new Tree(ins.num,null,null);
			}
			else {
				makeTree(cur.right, ins);
			}
		}
	}
	
	private static void postOrder(Tree cur) throws IOException  {

		if (cur.left!= null) {
			postOrder(cur.left);
		}
		
		if (cur.right != null) {
			postOrder(cur.right);
		}
		bw.write(cur.num+"\n");
	}


	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int c = 0;
		while(sc.hasNext()) {
			int num = sc.nextInt();
			if(c == 0) {
				t = new Tree(num,null,null);
			}
			else {
				makeTree(t,new Tree(num,null,null));
			}
			c++;
		}
		
		postOrder(t);
		bw.flush();
	}
}
