package 전화번호목록_5052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int HASH_SIZE = 3500;
	static int[][] hashtable;
	static char[][] datatable;
	static int PN = 23;
	static int num_size;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());
			boolean success = true;
			hashtable = new int[HASH_SIZE][20];
			datatable = new char[10000][11];
			num_size = 0;
			for (int j = 0; j < num; j++) {
				String input = br.readLine();
				char[] ar = input.toCharArray();
				if(!isAble(input)) {
					success = false;
				}
				else {
					add(ar);
				}
			}
			if(success) {
				bw.write("YES\n");
			}
			else {
				bw.write("NO\n");
			}
		}
		bw.flush();
	}
	
	static int get_key(char[] input) {
		int p = 1, key = 0, len = input.length;
		for(int i = 0; i < len; i++) {
			key += (p * input[i]);
			p *= PN;
		}
		
		if(key  <  0) key *= -1;
	
		return (key % HASH_SIZE);
	}
	
	static boolean strcmp(char[] a, char[] b) {
		int lenA = a.length, lenB = b.length;
		
		if(lenA != lenB) {
			return false;
		}
		
		for(int i = 0 ; i < lenA; i++) {
			if((a[i] != b[i]) || ((a[i] != '/') && (b[i] != '/'))) {
				return false;
			}
		}
		
		return true;
	}
	
	static int contain(char[] data) {
		int key = get_key(data);
		int size = hashtable[key][0];
		for(int i = 1 ; i <= size; i++) {
			if(strcmp(data, datatable[hashtable[key][i]])) {
				return i;
			}
		}
		
		return -1;
	}
	
	static void add(char[] input) {
		int key = get_key(input);
		int len = input.length;
		for(int i = 0 ; i < len; i++) {
			datatable[num_size][i] = input[i];
		}
		datatable[num_size][len] = '/';
		hashtable[key][++hashtable[key][0]] = num_size;
		num_size++;
	}
	
	static boolean remove(char[] input) {
		int key = get_key(input);
		int size = hashtable[key][0];
		int idx = 0;
		boolean find = false;
		for(int i = 1 ; i <= size; i++) {
			if(strcmp(input, datatable[hashtable[key][i]])) {
				idx = i;
				find= true;
				break;
			}
		}
		for(int i = idx ; i <= size; i++) {
			hashtable[key][i] = hashtable[key][i+1];
		}
		
		hashtable[key][0]--;
		return find;
	}
	
	static boolean isAble(String input) {
		int len = input.length();
		for(int i = 1; i <= len; i++) {
			char[] data = input.substring(0, i).toCharArray();
			int key = get_key(data);
			if(hashtable[key][0] > 0) {
				return false;
			}
		}
		return true;
	}
}