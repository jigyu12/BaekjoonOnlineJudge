package 개똥벌레_3020;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	private static int[] all;
	private static int[] goup;
	private static int[] godown;
	private static int h;
	
	private static int binarySearchUp(int s,int e, int h) {
		int ret = -1;
		int mid = (s + e) / 2;
		
		if(s > e) {
			return s;
		}

		if(goup[mid] > h) {
			ret = binarySearchUp(s, mid-1, h);
		}
		else if(goup[mid] < h) {
			ret = binarySearchUp(mid+1, e, h);
		}
		else {
			if(mid > 0 && goup[mid-1] < goup[mid]) {
				return mid;
			}
			else if(mid == 0) {
				return 0;
			}
			ret = binarySearchUp(s, mid-1, h);
		}
		
		
		return ret;
	}
	
	private static int binarySearchDown(int s,int e, int he) {
		int ret = -1;
		int mid = (s + e) / 2;
		
		if(s > e) {
			return s;
		}

		if(godown[mid] > he) {
			ret = binarySearchDown(s, mid-1, he);
		}
		else if(godown[mid] < he) {
			ret = binarySearchDown(mid+1, e, he);
		}
		else {
			if(mid > 0 && godown[mid-1] <godown[mid]) {
				return mid;
			}
			else if(mid == 0) {
				return 0;
			}
			ret = binarySearchDown(s, mid-1, he);
		}
		
		
		return ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] nh = sc.nextLine().split(" ");
		int n = Integer.parseInt(nh[0]);
		h = Integer.parseInt(nh[1]);
		
		all = new int[n];
		goup = new int[n/2];
		godown = new int[n/2];
		
		for(int i = 0 ; i < n; i++) {
			all[i] = sc.nextInt();
			if(i % 2 == 0) {
				goup[i/2] = all[i];
			}
			else {
				godown[i/2] = all[i];
			}
		}
		
		Arrays.sort(goup);
		Arrays.sort(godown);

		int obs = Integer.MAX_VALUE;
		int count = 0;
		for(int i = 1; i <= h; i++) {
			int up = n/2 - binarySearchUp(0, n/2-1, i);
			int down = n/2 - binarySearchDown(0, n/2-1, h - i + 1);
			if(obs >= up + down) {
				if(obs > up + down) {
					obs = up + down;
					count = 1;
				}
				else {
					count++;
				}
			}
		}
		System.out.println(obs + " " + count);

	}

}

