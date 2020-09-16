package 반도체설계_2352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	private static ArrayList<Integer> portList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		portList = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		
		init(Integer.parseInt(input[0]));
		
		for(int i = 1; i < n; i++) {
			int port = Integer.parseInt(input[i]);
			if(portList.get(portList.size()-1) < port) {
				portList.add(port);
			}
			else {
				int idx = binarySearch(0, portList.size(),port);
				portList.add(idx,port);
				portList.remove(idx+1);
			}
			
			for(int j = 0; j < portList.size(); j++) {
				System.out.print(portList.get(j) + " ");
			}
			System.out.println();
		}
		
		System.out.println(portList.size());
	}

	private static void init(int port) {
		portList.add(port);
	}

	private static int binarySearch(int start, int end, int port) {
		
		while(start <= end) {
			int mid = (start + end) / 2;
			if(portList.get(mid) >= port) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		
		return start;
	}

}
