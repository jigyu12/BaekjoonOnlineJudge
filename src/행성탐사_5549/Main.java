package 행성탐사_5549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static class Land{
		int jungleCnt;
		int oceanCnt;
		int iceCnt;
		
		public Land(int jungleCnt, int oceanCnt, int iceCnt) {
			this.jungleCnt = jungleCnt;
			this.oceanCnt = oceanCnt;
			this.iceCnt = iceCnt;
		}
		
		@Override
		public String toString() {
			return this.jungleCnt + " " + this.oceanCnt + " " + this.iceCnt;
		}
	}
	
	static int M,N,K;
	static int[][] map;
	static Land[][] landCnt;
	static final String Delimeter = " ";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		String[] nm = br.readLine().split(" ");
		
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		K = Integer.parseInt(br.readLine());
		map = new int[N+1][M+1];
		landCnt = new Land[N+1][M+1];
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= M ; j++) {
				landCnt[i][j] = new Land(0,0,0);
			}
		}
		
		for(int i = 1; i <= N; i++) {
			String[] input = br.readLine().split("");
			for(int j = 1; j <= M; j++) {
				switch(input[j-1]) {
				case "J":
					landCnt[i][j].jungleCnt++;
					break;
				case "O":
					landCnt[i][j].oceanCnt++;
					break;
				case "I":
					landCnt[i][j].iceCnt++;
					break;
				}
			}
		}
		
		madeTotalLandCnt();
		
		for(int t = 0; t < K; t++) {
			String[] abcd = br.readLine().split(" ");
			int a = Integer.parseInt(abcd[0]);
			int b = Integer.parseInt(abcd[1]);
			int c = Integer.parseInt(abcd[2]);
			int d = Integer.parseInt(abcd[3]);
			
			Land rightBelowEdge = landCopy(c,d);
			
			landSub(rightBelowEdge,c,b-1);
			landSub(rightBelowEdge,a-1,d);
			landAdd(rightBelowEdge,a-1,b-1);
			
			answer.append(rightBelowEdge.jungleCnt);
			answer.append(Delimeter);
			answer.append(rightBelowEdge.oceanCnt);
			answer.append(Delimeter);
			answer.append(rightBelowEdge.iceCnt);
			answer.append("\n");
		}
		
		System.out.println(answer.toString());
	}
	
	private static void landSub(Land land, int a, int b) {
		land.jungleCnt -= landCnt[a][b].jungleCnt;
		land.oceanCnt -= landCnt[a][b].oceanCnt;
		land.iceCnt -= landCnt[a][b].iceCnt;
	}
	
	private static void landAdd(Land land, int a, int b) {
		land.jungleCnt += landCnt[a][b].jungleCnt;
		land.oceanCnt += landCnt[a][b].oceanCnt;
		land.iceCnt += landCnt[a][b].iceCnt;
	}
	
	private static Land landCopy(int a, int b) {
		Land land = new Land(0,0,0);
		land.jungleCnt = landCnt[a][b].jungleCnt;
		land.oceanCnt = landCnt[a][b].oceanCnt;
		land.iceCnt = landCnt[a][b].iceCnt;
		return land;
	}
	
	private static void madeTotalLandCnt() {
	
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				landCnt[i][j].jungleCnt += landCnt[i-1][j].jungleCnt 
						+ landCnt[i][j-1].jungleCnt - landCnt[i-1][j-1].jungleCnt;
				landCnt[i][j].oceanCnt += landCnt[i-1][j].oceanCnt 
						+ landCnt[i][j-1].oceanCnt - landCnt[i-1][j-1].oceanCnt;
				landCnt[i][j].iceCnt += landCnt[i-1][j].iceCnt 
						+ landCnt[i][j-1].iceCnt - landCnt[i-1][j-1].iceCnt;
				
			}
		}
//		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= M; j++) {
//				System.out.print(landCnt[i][j] + " / ");
//			}
//			System.out.println();
//		}
	}

}
