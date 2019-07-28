package 이모티콘_14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Emoticon{
		int num;
		int time;
		int clipboard;
		
		public Emoticon(int num, int time, int clipboard) {
			this.num = num;
			this.time = time;
			this.clipboard = clipboard;
		}

		@Override
		public String toString() {
			return "Emoticon [num=" + num + ", time=" + time + ", clipboard=" + clipboard + "]";
		}

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		Queue<Emoticon> qu = new LinkedList<>();
		int[][] visited = new int[1003][2005];
		for(int i = 0 ; i <= 1002; i++) {
			Arrays.fill(visited[i], 2005);
		}
		qu.add(new Emoticon(1,0,0));
		int ans = 2005;
		
		while(!qu.isEmpty()) {
			Emoticon e = qu.poll();
			int en = e.num;
			int et = e.time;
			int ec = e.clipboard;
			
			if(en <= 0 || en > 2005) {
				continue;
			}
			
			if(en == num) {
				if(ans > et) {
					ans = et;
				}
				continue;
			}
			
			if(ans <= et) {
				continue;
			}
			
			qu.add(new Emoticon(en,et+1,en));
			
			if(en > 0 && ec != 0  && en+ec < 2005 && visited[ec][en+ec] > et + 1) {
				visited[ec][en+ec] = et+1;
				qu.add(new Emoticon(en+ec,et+1,ec));
			}
			
			if(en > 0 && en+ec < 2005 && visited[ec][en-1] > et + 1) {
				visited[ec][en-1] = et+1;
				qu.add(new Emoticon(en-1,et+1,ec));
			}
			
		}
		
		System.out.println(ans);
	}
}
