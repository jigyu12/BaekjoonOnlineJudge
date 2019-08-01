package 괄호의값_2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("");
		
		Stack<String> st = new Stack<>();
		boolean find = true;
		
		xx : for(int i = 0; i < s.length; i++) {
			switch(s[i]) {
			case "(": case "[": 
				st.push(s[i]);
				break;
				
			case ")": 
				if(st.empty()) {
					find = false;
					break xx;
				}
				String p1 = st.peek();
				int in1 = 1;
				while(!p1.equals("(") && !st.empty()) {
					if(p1.equals("[") || p1.equals("]")) {
						break xx;
					}
					else {
						st.pop();
						in1 = Integer.parseInt(p1);
						if(st.empty()) {
							find = false;
							break xx;
						}
						p1 = st.peek();
					}
				}
				if(p1.equals("(")) {
					p1 = st.pop();
					st.push(String.valueOf(in1 * 2));
				}
				break;
			case "]":
				if(st.empty()) {
					find = false;
					break xx;
				}
				String p2 = st.peek();
				int in2 = 1;
				while(!p2.equals("[") && !st.empty()) {
					if(p2.equals("(") || p2.equals(")")) {
						break xx;
					}
					else {
						p2 = st.pop();
						in2 = Integer.parseInt(p2);
						if(st.empty()) {
							find = false;
							break xx;
						}
						p2 = st.peek();
					}
				}
				if(p2.equals("[")) {
					p2 = st.pop();
					st.push(String.valueOf(in2 * 3));
				}
				break;
			}
			
			int add = 0;
			while(!st.isEmpty()) {
				String p = st.pop();
	
				try {
					add += Integer.parseInt(p);
				}
				catch(NumberFormatException e) {
					st.push(p);
				
					break;
				}
			}
			if(add > 0) {
				st.push(String.valueOf(add));
			}
	
		}
		
	
		int ans = 0;
		while(!st.isEmpty()) {
			String p = st.pop();
			try {
				ans += Integer.parseInt(p);
			}catch(NumberFormatException e) {
				find = false;
				break;
			}
		}
		if(!find) {
			System.out.println("0");
		}
		else {
			System.out.println(ans);
		}
	}

}
