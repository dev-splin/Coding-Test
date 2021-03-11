package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;



public class g1931 {
	public static class Meeting {
		int startTime;
		int endTime;
		
		public Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			if(n < 1 || n > 100000)
				return;
			
			List<Meeting> meetings = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				String times = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(times);
				
				if(stk.countTokens() != 2)
					return;
				
				int startTime = Integer.parseInt(stk.nextToken());
				int endTime = Integer.parseInt(stk.nextToken());
				
				Meeting meeting = new Meeting(startTime, endTime);
				meetings.add(meeting);
			}
			
			// 람다식과 comprator를 이용하여 endTime 기준으로 오름차순 정렬 합니다.
			// 이 때, endTime이 같으면 startTime이 더 빠른(작은) 회의를 앞에 둡니다.
			Collections.sort(meetings,(meeting1,meeting2b)->{
				if(meeting1.endTime == meeting2b.endTime)
					return meeting1.startTime - meeting2b.startTime;
				return meeting1.endTime - meeting2b.endTime;
			});
			
			int meetingCount = 0;
			int prevEndTime = 0;
			
			// 리스트를 순회하면서 배치된 이전 endTime 이후에 시작되는 회의를 구하고
			// 배치될 수 있으면 이전 endTime을 배치 될 회의의 endTime으로 바꿉니다.
			for(Meeting meeting : meetings) {
				if(meeting.startTime >= prevEndTime) {
					prevEndTime = meeting.endTime;
					++meetingCount;
				}
			}
			
			
			bw.write(Integer.toString(meetingCount));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
