package 순회강연_2109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	
	static class Lecture{
		int pay;
		int day;
		
		public Lecture(int pay, int day) {
			this.pay = pay;
			this.day = day;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Lecture> lectureList = new ArrayList<>();
		int[] scheduleList = new int[10001];
		int answer = 0;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String[] pd = br.readLine().split(" ");
			Lecture lecture = new Lecture(Integer.parseInt(pd[0]),
					Integer.parseInt(pd[1]));
			lectureList.add(lecture);
		}
		
		Collections.sort(lectureList, new Comparator<Lecture>() {
			@Override
			public int compare(Lecture o1, Lecture o2) {
				if(o1.day == o2.day) {
					return o2.pay - o1.pay;
				}
				return o1.day - o2.day;
			}
		});
		
		for(int i = 0; i < n; i++) {
			Lecture lecture = lectureList.get(i);
			int leastPay = 10001;
			int leastDay = 0;
			if(scheduleList[lecture.day] < lecture.pay) {
				scheduleList[lecture.day] = lecture.pay;
			}
			else {
				for(int j = 1; j <= lecture.day; j++) {
					if(scheduleList[j] < lecture.pay
							&& scheduleList[j] < leastPay) {
						leastPay = scheduleList[j];
						leastDay = j;
					}
				}
				scheduleList[leastDay] = lecture.pay;
			}
		}
		
		for(int i = 1; i <= 10000; i++) {
			answer += scheduleList[i];
		}

		System.out.println(answer);
	}
}
