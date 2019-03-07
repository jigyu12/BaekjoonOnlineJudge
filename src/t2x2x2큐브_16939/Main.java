package t2x2x2Å¥ºê_16939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	private static Deque<Integer> widthU;
	private static Deque<Integer> widthD;
	private static Deque<Integer> heightL;
	private static Deque<Integer> heightR;
	private static Deque<Integer> depthF;
	private static Deque<Integer> depthB;
	private static int[] num;
	private static int ans;
	private static int widthSame;
	private static int heightSame;
	private static int depthSame;

	private static void makeWidthU() {
		widthU.add(num[13]);
		widthU.add(num[14]);
		widthU.add(num[5]);
		widthU.add(num[6]);
		widthU.add(num[17]);
		widthU.add(num[18]);
		widthU.add(num[21]);
		widthU.add(num[22]);
	}

	private static void makeWidthD() {
		widthD.add(num[15]);
		widthD.add(num[16]);
		widthD.add(num[7]);
		widthD.add(num[8]);
		widthD.add(num[19]);
		widthD.add(num[20]);
		widthD.add(num[23]);
		widthD.add(num[24]);
	}

	private static void makeHeightL() {
		heightL.add(num[1]);
		heightL.add(num[3]);
		heightL.add(num[5]);
		heightL.add(num[7]);
		heightL.add(num[9]);
		heightL.add(num[11]);
		heightL.add(num[24]);
		heightL.add(num[22]);
	}

	private static void makeHeightR() {
		heightR.add(num[2]);
		heightR.add(num[4]);
		heightR.add(num[6]);
		heightR.add(num[8]);
		heightR.add(num[10]);
		heightR.add(num[12]);
		heightR.add(num[23]);
		heightR.add(num[21]);
	}
	
	private static void makedepthF() {
		depthF.add(num[3]);
		depthF.add(num[4]);
		depthF.add(num[17]);
		depthF.add(num[19]);
		depthF.add(num[10]);
		depthF.add(num[9]);
		depthF.add(num[16]);
		depthF.add(num[14]);
	}
	
	private static void makedepthB() {
		depthB.add(num[1]);
		depthB.add(num[2]);
		depthB.add(num[18]);
		depthB.add(num[20]);
		depthB.add(num[12]);
		depthB.add(num[11]);
		depthB.add(num[15]);
		depthB.add(num[13]);
	}

	private static void rotateWidthUpLeft() {
		int cal = widthSame;
		int a = widthU.pollFirst();
		int b = widthU.pollFirst();
		widthU.addLast(a);
		widthU.addLast(b);
		for(int i = 0; i < 4; i++) {
			int z = widthU.pollFirst();
			int x = widthU.pollFirst();
			int c = widthD.pollFirst();
			int v = widthD.pollFirst();
			if(z == x && x == c && c == v && v == z) {
				cal++;
			}
			widthU.addLast(z);
			widthU.addLast(x);
			widthD.addLast(c);
			widthD.addLast(v);
		}
		
		int f = widthU.pollLast();
		int n = widthU.pollLast();
		widthU.addFirst(f);
		widthU.addFirst(n);
		
		
		if(cal == 6) {
			ans = 1;
		}
	}

	private static void rotateWidthUpRight() {
		int cal = widthSame;
		int a = widthU.pollLast();
		int b = widthU.pollLast();
		widthU.addFirst(a);
		widthU.addFirst(b);
		for(int i = 0; i < 4; i++) {
			int z = widthU.pollLast();
			int x = widthU.pollLast();
			int c = widthD.pollLast();
			int v = widthD.pollLast();
			if(z == x && x == c && c == v && v == z) {
				cal++;
			}
			widthU.addFirst(z);
			widthU.addFirst(x);
			widthD.addFirst(c);
			widthD.addFirst(v);
		}
		
		int f = widthU.pollFirst();
		int n = widthU.pollFirst();
		widthU.addLast(f);
		widthU.addLast(n);

		if(cal == 6) {
			ans = 1;
		}
	}

	private static void rotateWidthDownLeft() {
		int cal = widthSame;
		int a = widthD.pollFirst();
		int b = widthD.pollFirst();
		widthD.addLast(a);
		widthD.addLast(b);
		for(int i = 0; i < 4; i++) {
			int z = widthU.pollFirst();
			int x = widthU.pollFirst();
			int c = widthD.pollFirst();
			int v = widthD.pollFirst();
			if(z == x && x == c && c == v && v == z) {
				cal++;
			}
			widthU.addLast(z);
			widthU.addLast(x);
			widthD.addLast(c);
			widthD.addLast(v);
		}
		
		int f = widthD.pollLast();
		int n = widthD.pollLast();
		widthD.addFirst(f);
		widthD.addFirst(n);
		
		if(cal == 6) {
			ans = 1;
		}
	}

	private static void rotateWidthDownRight() {
		int cal = widthSame;
		int a = widthD.pollLast();
		int b = widthD.pollLast();
		widthD.addFirst(a);
		widthD.addFirst(b);
		for(int i = 0; i < 4; i++) {
			int z = widthU.pollLast();
			int x = widthU.pollLast();
			int c = widthD.pollLast();
			int v = widthD.pollLast();
			if(z == x && x == c && c == v && v == z) {
				cal++;
			}
			widthU.addFirst(z);
			widthU.addFirst(x);
			widthD.addFirst(c);
			widthD.addFirst(v);
		}
		
		int f = widthD.pollFirst();
		int n = widthD.pollFirst();
		widthD.addLast(f);
		widthD.addLast(n);
		
		if(cal == 6) {
			ans = 1;
		}
	}
	
	private static void rotateHeightLeftUp() {
		int cal = heightSame;
		int a = heightL.pollFirst();
		int b = heightL.pollFirst();
		heightL.addLast(a);
		heightL.addLast(b);
		for(int i = 0; i < 4; i++) {
			int z = heightL.pollFirst();
			int x = heightL.pollFirst();
			int c = heightR.pollFirst();
			int v = heightR.pollFirst();
			if(z == x && x == c && c == v && v == z) {
				cal++;
			}
			heightL.addLast(z);
			heightL.addLast(x);
			heightR.addLast(c);
			heightR.addLast(v);
		}
		
		int f = heightL.pollLast();
		int n = heightL.pollLast();
		heightL.addFirst(f);
		heightL.addFirst(n);
		
		if(cal == 6) {
			ans = 1;
		}
	}

	private static void rotateHeightLeftDown() {
		int cal = heightSame;
		int a = heightL.pollLast();
		int b = heightL.pollLast();
		heightL.addFirst(a);
		heightL.addFirst(b);
		for(int i = 0; i < 4; i++) {
			int z = heightL.pollLast();
			int x = heightL.pollLast();
			int c = heightR.pollLast();
			int v = heightR.pollLast();
			if(z == x && x == c && c == v && v == z) {
				cal++;
			}
			heightL.addFirst(z);
			heightL.addFirst(x);
			heightR.addFirst(c);
			heightR.addFirst(v);
		}
		
		int f = heightL.pollFirst();
		int n = heightL.pollFirst();
		heightL.addLast(f);
		heightL.addLast(n);
		
		
		if(cal == 6) {
			ans = 1;
		}
	}

	private static void rotateHeightRightUp() {
		int cal = heightSame;
		int a = heightR.pollFirst();
		int b = heightR.pollFirst();
		heightR.addLast(a);
		heightR.addLast(b);
		for(int i = 0; i < 4; i++) {
			int z = heightL.pollFirst();
			int x = heightL.pollFirst();
			int c = heightR.pollFirst();
			int v = heightR.pollFirst();
			if(z == x && x == c && c == v && v == z) {
				cal++;
			}
			heightL.addLast(z);
			heightL.addLast(x);
			heightR.addLast(c);
			heightR.addLast(v);
		}
		
		int f = heightR.pollLast();
		int n = heightR.pollLast();
		heightR.addFirst(f);
		heightR.addFirst(n);
		
		if(cal == 6) {
			ans = 1;
		}
	}

	private static void rotateHeightRightDown() {
		int cal = heightSame;
		int a = heightR.pollLast();
		int b = heightR.pollLast();
		heightR.addFirst(a);
		heightR.addFirst(b);
		for(int i = 0; i < 4; i++) {
			int z = heightL.pollLast();
			int x = heightL.pollLast();
			int c = heightR.pollLast();
			int v = heightR.pollLast();
			if(z == x && x == c && c == v && v == z) {
				cal++;
			}
			heightL.addFirst(z);
			heightL.addFirst(x);
			heightR.addFirst(c);
			heightR.addFirst(v);
		}
		
		int f = heightR.pollFirst();
		int n = heightR.pollFirst();
		heightR.addLast(f);
		heightR.addLast(n);
		
		if(cal == 6) {
			ans = 1;
		}
	}
	
	private static void rotateDepthFrontLeft() {
		int cal = depthSame;
		int a = depthF.pollFirst();
		int b = depthF.pollFirst();
		depthF.addLast(a);
		depthF.addLast(b);
		for(int i = 0; i < 4; i++) {
			int z = depthF.pollFirst();
			int x = depthF.pollFirst();
			int c = depthB.pollFirst();
			int v = depthB.pollFirst();
			if(z == x && x == c && c == v && v == z) {
				cal++;
				
			}
			depthF.addLast(z);
			depthF.addLast(x);
			depthB.addLast(c);
			depthB.addLast(v);
		}
		
		int f = depthF.pollLast();
		int n = depthF.pollLast();
		depthF.addFirst(f);
		depthF.addFirst(n);
		

		if(cal == 6) {
			ans = 1;
		}
	}

	private static void rotateDepthFrontRight() {
		int cal = depthSame;
		int a = depthF.pollLast();
		int b = depthF.pollLast();
		depthF.addFirst(a);
		depthF.addFirst(b);
		for(int i = 0; i < 4; i++) {
			int z = depthF.pollFirst();
			int x = depthF.pollFirst();
			int c = depthB.pollFirst();
			int v = depthB.pollFirst();
			if(z == x && x == c && c == v && v == z) {
				cal++;
			}
			depthF.addLast(z);
			depthF.addLast(x);
			depthB.addLast(c);
			depthB.addLast(v);
		}
		
		int f = depthF.pollFirst();
		int n = depthF.pollFirst();
		depthF.addLast(f);
		depthF.addLast(n);

		if(cal == 6) {
			ans = 1;
		}
	}

	private static void rotateDepthBackLeft() {
		int cal = depthSame;
		int a = depthB.pollFirst();
		int b = depthB.pollFirst();
		depthB.addLast(a);
		depthB.addLast(b);
		for(int i = 0; i < 4; i++) {
			int z = depthF.pollFirst();
			int x = depthF.pollFirst();
			int c = depthB.pollFirst();
			int v = depthB.pollFirst();
			if(z == x && x == c && c == v && v == z) {
				cal++;
			}
			depthF.addLast(z);
			depthF.addLast(x);
			depthB.addLast(c);
			depthB.addLast(v);
		}
		
		int f = depthB.pollLast();
		int n = depthB.pollLast();
		depthB.addFirst(f);
		depthB.addFirst(n);

		
		if(cal == 6) {
			ans = 1;
		}
	}

	private static void rotateDepthBackRight() {
		int cal = depthSame;
		int a = depthB.pollLast();
		int b = depthB.pollLast();
		depthB.addFirst(a);
		depthB.addFirst(b);
		for(int i = 0; i < 4; i++) {
			int z = depthF.pollLast();
			int x = depthF.pollLast();
			int c = depthB.pollLast();
			int v = depthB.pollLast();
			if(z == x && x == c && c == v && v == z) {
				cal++;
			}
			depthF.addFirst(z);
			depthF.addFirst(x);
			depthB.addFirst(c);
			depthB.addFirst(v);
		}
		
		int f = depthB.pollFirst();
		int n = depthB.pollFirst();
		depthB.addLast(f);
		depthB.addLast(n);

		if(cal == 6) {
			ans = 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		num = new int[s.length + 1];
		ans = 0;
		for (int i = 1; i < num.length; i++) {
			num[i] = Integer.parseInt(s[i - 1]);
		}
		widthSame = 0;
		heightSame = 0;
		depthSame = 0;
		
		widthU = new ArrayDeque<>();
		widthD = new ArrayDeque<>();
		heightL = new ArrayDeque<>();
		heightR = new ArrayDeque<>();
		depthF = new ArrayDeque<>();
		depthB = new ArrayDeque<>();

		makeWidthU();
		makeWidthD();
		makeHeightL();
		makeHeightR();
		makedepthF();
		makedepthB();

		if(num[1] == num[2] && num[2] == num[3] && num[3] == num[4] && num[4] == num[1]) {
			widthSame++;
		}
		
		if(num[9] == num[10] && num[10] == num[10] && num[11] == num[11] && num[12] == num[9]) {
			widthSame++;
		}
		
		if(num[13] == num[14] && num[14] == num[15] && num[15] == num[16] && num[16] == num[13]) {
			heightSame++;
		}
		
		if(num[17] == num[18] && num[18] == num[19] && num[19] == num[20] && num[20] == num[17]) {
			heightSame++;
		}
		
		if(num[5] == num[6] && num[6] == num[7] && num[7] == num[8] && num[8] == num[5]) {
			depthSame++;
		}
		
		if(num[21] == num[22] && num[22] == num[23] && num[23] == num[24] && num[24] == num[21]) {
			depthSame++;
		}

		rotateWidthUpLeft();
		rotateWidthUpRight();
		rotateWidthDownLeft();
		rotateWidthDownRight();
		rotateHeightLeftUp();
		rotateHeightLeftDown();
		rotateHeightRightUp();
		rotateHeightRightDown();
		rotateDepthFrontLeft();
		rotateDepthFrontRight();
		rotateDepthBackLeft();
		rotateDepthBackRight();
		
		System.out.println(ans);
	}
}
