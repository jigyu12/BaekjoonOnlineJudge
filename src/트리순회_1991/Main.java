package 트리순회_1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static class Tree {
		String me;
		Tree left;
		Tree right;

		public Tree(String me, Tree left, Tree right) {
			this.me = me;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Tree [me=" + me + ", left=" + left + ", right=" + right + "]";
		}

	}

	static Tree t;
	static BufferedWriter bw;

	private static void find(Tree par, Tree ins) {
		Tree p = par, i = ins;
		if (par.me.equals(i.me)) {
			p.left = i.left;
			p.right = i.right;
		} 
		else {
			if (p.left != null) {
				find(p.left, i);
			}
			if (p.right != null ) {
				find(p.right, i);
			}
		}
	}

	private static void inOrder(Tree cur) throws IOException {
		bw.write(cur.me);
		if (cur.left != null) {
			inOrder(cur.left);
		}
		if (cur.right != null) {
			inOrder(cur.right);
		}
	}

	private static void preOrder(Tree cur) throws IOException {

		if (cur.left != null) {
			preOrder(cur.left);
		}
		bw.write(cur.me);
		if (cur.right != null) {
			preOrder(cur.right);
		}
	}

	private static void postOrder(Tree cur) throws IOException {

		if (cur.left!= null) {
			postOrder(cur.left);
		}
		
		if (cur.right != null) {
			postOrder(cur.right);
		}
		bw.write(cur.me);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			Tree left, right;

			if (s[1].equals(".")) {
				left = null;
			} else {
				left = new Tree(s[1], null, null);
			}

			if (s[2].equals(".")) {
				right = null;
			} else {
				right = new Tree(s[2], null, null);
			}

			if (i == 0) {
				t = new Tree(s[0], left, right);
			}

			else {
				find(t, new Tree(s[0], left, right));
			}

		}
		
		inOrder(t);
		bw.write("\n");
		preOrder(t);
		bw.write("\n");
		postOrder(t);
		bw.write("\n");
		bw.flush();
	}
}

