package 인형들_15954;

import java.util.Scanner;

public class Main  {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, k, num,f=0;
		double sum,sum2,m,low,low2;
		n = sc.nextInt();
		k = sc.nextInt();
		int[] a = new int[n];
		double[] c = new double[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		while(n>=k) {
			num = n - k + 1;
			double[] b = new double[num];
			for(int i = 0; i < num; i++) {
				int x = i;
				sum = 0;
				sum2 = 0;
				for(int j = 0; j < k; j++) {
					sum += a[x++];
				}
				m = sum / (double) k;
				x = i;
				for(int u = 0; u < k; u++) {
					sum2 += Math.pow(((double)a[x++]-m), 2);
				}
				b[i] = Math.sqrt(sum2/k);
			}
			low = b[0];
			for(int i = 0; i < b.length; i++) {
				if(low > b[i]) {
					low = b[i];
				}
			}
			c[f++] = low;
			k++;
		}
		low2 = c[0];
		for(int i = 0; i < c.length; i++) {
			if(low2 > c[i] && c[i] > 0) {
				low2 = c[i];
			}
		}
 	System.out.printf("%.11f",low2);
 	sc.close();
	}
}
