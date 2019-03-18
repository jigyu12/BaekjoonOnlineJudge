package π∞≈Î_2251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private static int a;
	private static int b;
	private static int c;
	private static boolean[][][] visited;
	private static boolean[] cAble;
	
	private static void find(int one, int two, int three) {
		if(one < 0 || two < 0 || three < 0) {
			return ;
		}
		
		if(visited[one][two][three]) {
			return ;
		}
		
		if(one == 0) {
			cAble[three] = true;
		}
		
		visited[one][two][three] = true;
		if(one + two <= b) {
			find(0,two+one,three);
		}
		else {
			find((one+two)-b,b,three);
		}
		if(one + three <= c) {
			find(0,two,three+one);
		}
		else {
			find((one+three)-c,two,c);
		}
		if(one + two <= a) {
			find(one+two,0,three);
		}
		else {
			find(a,(one+two)-a,three);
		}
		if(two + three <= c) {
			find(one,0,three+two);
		}
		else {
			find(one,(three+two)-c,c);
		}
		if(one + three <= a) {
			find(one+three,two,0);
		}
		else {
			find(a,two,(one+three)-a);
		}
		if(two + three <= b) {
			find(one,two+three,0);
		}
		else {
			find(one,b,(two+three)-b);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] abc = br.readLine().split(" ");
		
		a = Integer.parseInt(abc[0]);
		b = Integer.parseInt(abc[1]);
		c = Integer.parseInt(abc[2]);
		cAble = new boolean[c+1];
		visited = new boolean[a+1][b+1][c+1];
		find(0,0,c);
		
		for(int i = 0 ; i < c+1; i++) {
			if(cAble[i]) {
				bw.write(i + " ");
			}
		}
		bw.write("\n");
		bw.flush();
	}
}
