package 빗물_14719;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] HW = br.readLine().split(" ");
		
		int H = Integer.parseInt(HW[0]);
		int W = Integer.parseInt(HW[1]);
		
		int[] block_array = new int[W];
		
		String[] input_array = br.readLine().split(" ");
		
		for(int i = 0; i < W; i++) {
			block_array[i] = Integer.parseInt(input_array[i]);
		}
		
		bw.write(calculate_rain_amount(block_array)+"");
		bw.flush();
		br.close();
		bw.close();
	}

	private static int calculate_rain_amount(int[] block_array) {
		int answer = 0;

		for(int current = 1; current < block_array.length - 1; current++) {
			int front_height = block_array[current-1];
			int back_height = block_array[current+1];
			
			int f_index = current - 1;
			while(front_height <=block_array[current] && f_index > 0) {
				front_height = block_array[--f_index];
			}
			
			int b_index = current + 1;
			while(back_height < block_array[current] && b_index < block_array.length - 1) {
				back_height = block_array[++b_index];
			}
			
			if(front_height > block_array[current] && block_array[current] < back_height) {
				int min = front_height < back_height ? front_height : back_height;
				answer += ((min - block_array[current]) * (b_index - f_index - 1));
			}
		}
		
		return answer;
	}

}
