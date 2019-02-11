package 두배열의합_2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	
	private static int[] sa;
	private static int[] a;
	private static int[] sb;
	private static int[] b;
	private static int[] ssa;
	private static int[] ssb;

	private static int initSa(int start, int end, int node) {
		if(start == end) {
			return sa[node] = a[start];
		}
		
		int mid = (start + end) / 2;
		
		return sa[node] = initSa(start,mid,node*2) + initSa(mid+1,end,node*2+1);
	}
	
	private static int initSb(int start, int end, int node) {
		if(start == end) {
			return sb[node] = b[start];
		}
		
		int mid = (start + end) / 2;
		
		return sb[node] = initSb(start,mid,node*2) + initSb(mid+1,end,node*2+1);
	}
	
	private static int sumA(int start, int end, int left, int right, int node) {
		if(right < start || end < left) {
			return 0;
		}
		
		if(start <= left && right <= end) {
			return sa[node];
		}
		
		int mid = (start + end) / 2;
		
		return sumA(start, mid, left,right,node * 2) + sumA(mid+1,end,left,right,node*2+1);
	}
	
	private static int sumB(int start, int end, int left, int right, int node) {
		if(right < start || end < left) {
			return 0;
		}
		
		if(start <= left && right <= end) {
			return sb[node];
		}
		
		int mid = (start + end) / 2;
		
		return sumB(start, mid, left,right,node * 2) + sumB(mid+1,end,left,right,node*2+1);
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			int lenA = Integer.parseInt(br.readLine());
			String sA[] = br.readLine().split(" ");
			sa = new int[lenA * 4];
			a = new int[lenA];
			int lenB = Integer.parseInt(br.readLine());
			String sB[] = br.readLine().split(" ");
			b = new int[lenB];
			sb = new int[lenB * 4];
			ssa = new int[lenA * 4];
			ssb = new int[lenB * 4];
			int ai = 0;
			int bi = 0;
			for(int i = 0; i < lenA; i++) {
				a[i] = Integer.parseInt(sA[i]);
				ssa[ai++] = a[i];
			}
			for(int i = 0; i < lenB; i++) {
				b[i] = Integer.parseInt(sB[i]);
				ssb[bi++] = b[i];
			}
			initSa(0,a.length-1,1);
			initSb(0,b.length-1,1);
			
			for(int i = 0; i < a.length; i++) {
				for(int j = i+1; j < a.length; j++) {
					ssa[ai++] = sumA(0,a.length-1,i,j,1);
				}
			}
			for(int i = 0; i < b.length; i++) {
				for(int j = i+1; j < b.length; j++) {
					ssb[bi++] = sumB(0,b.length-1,i,j,1);
				}
			}
			
			int count = 0;
			for(int i = 0; i < ai+1; i++) {
				for(int j = 0; j < bi+1; j++) {
					System.out.println(ssa[i] + " " + ssb[j]);
					if(ssa[i] + ssb[j] == num) {
						
						count++;
					}
				}
			}
			

			System.out.println(count);
		} catch (NumberFormatException | IOException e) {}
	}
}
