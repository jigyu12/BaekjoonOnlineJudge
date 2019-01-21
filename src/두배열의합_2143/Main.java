package 두배열의합_2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			int lenA = Integer.parseInt(br.readLine());
			String sA[] = br.readLine().split(" ");
			int sa[] = new int[lenA];
			int a[] = new int[lenA];
			int lenB = Integer.parseInt(br.readLine());
			String sB[] = br.readLine().split(" ");
			int b[] = new int[lenB];
			int sb[] = new int[lenB];
			int sumA = 0, sumB = 0;
			for(int i = 0; i < lenA; i++) {
				a[i] = Integer.parseInt(sA[i]);
				sumA += a[i];
				sa[i] = sumA;
			}
			for(int i = 0; i < lenB; i++) {
				b[i] = Integer.parseInt(sB[i]);
				sumB += b[i];
				sb[i] = sumB;
			}
			
			int count = 0;
			for(int i = 0; i < lenB; i++) {
				for(int k = 0; k < lenA; k++) {
					for(int j = k; j < lenA; j++) {
						int comp = 0;
						if(k == 0) {
							comp = sa[j] + b[i];
							
							if(comp == num) {
								System.out.println(j + " " + i);
								count++;
								break;
							}
							else if(comp > num) {
								break;
							}
						}
						
						else {
							comp = sa[j] - sa[k-1] + b[i];
							
							if(comp == num) {
								System.out.println(j+ " " + (k-1) + " " + i);
								count++;
								break;
							}
							else if(comp > num) {
								break;
							}
						}
					}
					
				}
				System.out.println("------------------");
			}
			for(int i = 0; i < lenA; i++) {
				for(int k = 0; k < lenB; k++) {
					for(int j = k; j < lenB; j++) {
						int comp = 0;
						if(k == 0) {
							comp = sb[j] + a[i];
							
							if(comp == num) {
								System.out.println(j + " " + i);
								count++;
								break;
							}
							else if(comp > num) {
								break;
							}
						}
						
						else {
							comp = sb[j] - sb[k-1] + a[i];
							
							if(comp == num) {
								System.out.println(j+ " " + (k-1) + " " + i);
								count++;
								break;
							}
							else if(comp > num) {
								break;
							}
						}
					}
					
				}
			}

			System.out.println(count);
		} catch (NumberFormatException | IOException e) {}
	}
}
