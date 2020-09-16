package 탑_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static class Top {
		int height;
		int idx;
		
		public Top(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
		
	}
	
	private static final String DELIMETER = " ";

	public static void main(String[] args) 
			throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int topNum = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		Stack<Top> stack = new Stack<>();
		
		//initialize
		stack.add(new Top(Integer.parseInt(input[0]),0));
		sb.append("0 ");
		
		for(int idx = 1; idx < topNum; idx++) {
			int curHeight = Integer.parseInt(input[idx]);

			while(!stack.isEmpty() && 
					stack.peek().height < curHeight) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append("0");
			} else if(stack.peek().height == curHeight) {
				sb.append(stack.peek().idx + 1);
				stack.pop();
			} else {
				sb.append(stack.peek().idx + 1);
			}
			stack.add(new Top(curHeight,idx));
			sb.append(DELIMETER);
		}
		
		System.out.println(sb.toString());
	}

}
