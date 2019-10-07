package 친구네트워크_4195;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static char[][] name;
	static int[] namelen;
	static int[][] hash_table;
	static final int PN = 31;
	static int hash_size;
	static int name_size;
	static int[] par;
	static int[] famcnt;
	
	static int get_key(char[] data) {
		int key = 0, p = 1;
		
		for(int i = 0; i < data.length; i++) {
			key += (data[i] * p);
			p *= PN;
		}
		
		if(key < 0) {
			key *= -1;
		}
		
		return key % hash_size;
	}
	
	static boolean strcmp(char[] a, int alen ,char[] b) {

		if(namelen[alen] != b.length) {
			return false;
		}
		
		int len = namelen[alen];
		
		for(int i = 0; i < len; i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	static int contain(char[] data) {
		int key = get_key(data);
		int size = hash_table[key][0];
		for(int i = 1; i <= size; i++) {
			int cmp = hash_table[key][i];
			if(strcmp(name[cmp],cmp,data)) {
				return cmp;
			}
		}
		
		return -1;
	}
	
	static int add(char[] data) {
		int key = get_key(data);
		int size = hash_table[key][0];
		int ret = name_size;
		
		namelen[name_size] = data.length;
		
		for(int i = 0; i < data.length; i++) {
			name[name_size][i] = data[i]; 
		}
		
		hash_table[key][size+1] = name_size;
		
		hash_table[key][0]++;
		name_size++;
		
		return ret;
	}
	
	static void init() {
		for(int i = 0; i < 200000; i++) {
			par[i] = i;
			famcnt[i] = 1;
		}
	}
	
	static int find(int data) {
		if(par[data] == data) {
			return data;
		}
		
		return par[data] = find(par[data]);
	}
	
	static int union(int a, int b) {
		int ap = find(a), bp = find(b);
		
		if(ap != bp) {
			par[bp] = find(par[ap]);
			famcnt[ap] += famcnt[bp];
			famcnt[bp] = 1;
		}
		
		return famcnt[ap];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		hash_size = 70000;
		name = new char[200001][21];
		hash_table = new int[hash_size][30];
		namelen = new int[200001];
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < test; t++) {
			int cnt = Integer.parseInt(br.readLine());
			name_size = 0;
			par = new int[200000];
			famcnt = new int[200000];
			
			init();
			
			for(int c = 0; c < 70000; c++) {
				hash_table[c][0] = 0;
			}

			for(int c = 1; c <= cnt; c++) {
				String[] s = br.readLine().split(" ");
				
				char[] a = s[0].toCharArray();
				char[] b = s[1].toCharArray();
				
				int akey = contain(a);
				
				if(akey == -1) {
					akey = add(a);
				}
				
				int bkey = contain(b);
				
				if(bkey == -1) {
					bkey = add(b);
				}

				bw.write(union(akey, bkey)+"\n");
			}
		}
		bw.flush();
	}
}
