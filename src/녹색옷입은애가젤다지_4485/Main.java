package ≥Ïªˆø ¿‘¿∫æ÷∞°¡©¥Ÿ¡ˆ_4485;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 1;
		while (true) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			int[][] map = new int[n][n];
			int[][] dist = new int[n][n];
			Queue<Node> qu = new LinkedList<Node>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					dist[i][j] = 987654321;
				}
			}

			Node nn = new Node(0, 0);
			qu.add(nn);
			dist[0][0] = map[0][0];
			while (!qu.isEmpty()) {
				Node no = qu.poll();
				if (no.x >= 1 && dist[no.x - 1][no.y] > dist[no.x][no.y] + map[no.x - 1][no.y]) {
					Node nod = new Node(no.x - 1, no.y);
					qu.add(nod);
					dist[no.x - 1][no.y] = dist[no.x][no.y] + map[no.x - 1][no.y];
				}

				if (no.x <= n - 2 && dist[no.x + 1][no.y] > dist[no.x][no.y] + map[no.x + 1][no.y]) {
					Node nod = new Node(no.x + 1, no.y);
					qu.add(nod);
					dist[no.x + 1][no.y] = dist[no.x][no.y] + map[no.x + 1][no.y];
				}

				if (no.y >= 1 && dist[no.x][no.y - 1] > dist[no.x][no.y] + map[no.x][no.y - 1]) {
					Node nod = new Node(no.x, no.y - 1);
					qu.add(nod);
					dist[no.x][no.y - 1] = dist[no.x][no.y] + map[no.x][no.y - 1];
				}

				if (no.y <= n - 2 && dist[no.x][no.y + 1] > dist[no.x][no.y] + map[no.x][no.y + 1]) {
					Node nod = new Node(no.x, no.y + 1);
					qu.add(nod);
					dist[no.x][no.y + 1] = dist[no.x][no.y] + map[no.x][no.y + 1];
				}
			}
			System.out.printf("Problem %d: %d\n",num,dist[n-1][n-1]);
			num++;
		}
	}
}
