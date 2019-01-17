package 전화번호목록_5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	private static int[] hashmap;

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				boolean check = true;
				hashmap = new int[10000];
				int n = Integer.parseInt(br.readLine());
				
				for(int j = 0; j < 10000; j++) {
					hashmap[j] = -1;
				}
				int max = 10;
				xx: for (int j = 0; j < n; j++) {
					String s = br.readLine();
					int len = s.length();
					int num = Integer.parseInt(s);
					int find = (int)(num % Math.pow(10, len));
					System.out.println(find);
	
					if(hashmap[find] != -1) {
						if(hashmap[find] == num) {
							check = false;
							break xx;
						}
						else {
							while(hashmap[find] != -1) {
								find--;
							}
							hashmap[find] = num;
						}
					}
					else {
						hashmap[find] = num;
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
//					String num = br.readLine();
//					String[] s = num.split("");
//					if (hashmap[Integer.parseInt(s[0])][0] == null) {
//						hashmap[Integer.parseInt(s[0])][0] = num;
//					} 
//					else {
//						int a = 0;
//						// System.out.println(hashmap[Integer.parseInt(s[0])][a] + " " + comp);
//						while (hashmap[Integer.parseInt(s[0])][a] != null) {
////							System.out.println(num + " " + hashmap[Integer.parseInt(s[0])][a]);
//							boolean what = false;
//							String[] sz = hashmap[Integer.parseInt(s[0])][a].split("");
//							if (sz.length >= s.length) {
//								for (int m = 0; m < s.length; m++) {
////									System.out.println(sz[m] + " " + s[m]);
//									if (!sz[m].equals(s[m])) {
//										what = true;
//										break;
//									}
//								}
//							} 
//							else {
//								for (int m = 0; m < sz.length; m++) {
////									System.out.println(sz[m] + " " + s[m]);
//									if (!sz[m].equals(s[m])) {
//										what = true;
//										break;
//									}
//								}
//							}
//							if (!what) {
//								check = false;
//								System.out.println("NO");
//								break xx;
//							}
//							a++;
//						}
//
//						hashmap[Integer.parseInt(s[0])][a] = num;
//					}
				}
				// for(int j = 0; j < 10; j++) {
				// int a = 0;
				// while (hashmap[j][a] != null) {
				// System.out.print(hashmap[j][a] + " ");
				// a++;
				// }
				// System.out.println();
				// }
				if (check) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
