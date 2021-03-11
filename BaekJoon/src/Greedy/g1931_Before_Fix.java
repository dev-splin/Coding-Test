package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;



public class g1931_Before_Fix {
	// Meeting(회의) 클래스, 시작시간과, 종료시간을 갖습니다.
	public static class Meeting {
		int startTime;
		int endTime;
		
		public Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	
	// list와 endTime(종료시간)을 인자로 받아 리스트 중에 종료 시간 보다 앞의 시간의 시작시간을 갖는 회의(Meeting)를 삭제합니다.
	// 예를 들어, 1~4 회의 시간이 결정 됐으면 1~3의 시작시간을 가지고 있는 회의들은 배치할 수 없기 때문입니다. 
	public static void deleteEarlyStartTime(List<Meeting> meetings, int endTime) {
		
		Iterator<Meeting> iter = meetings.iterator();
		
		while (iter.hasNext()) {
			if(iter.next().startTime < endTime) {
				iter.remove();
			}
		}
	}
	
	// list의 객체들 중에 제일 앞에 배치할 수 있는 회의를 찾아 반환해줍니다.
	// 종료 시간을 비교해 찾아주는데, 종료 시간이 같다면 시작 시간이 더 빠른 객체를 찾습니다.
	// 시작시간이 더 빠른 객체를 찾는 이유는 만약 5~6과 6~6이 있을 때 시작시간이 더 긴 6~6을 먼저 찾게 되면 5~6은 건너뛰기 때문입니다.
	public static Meeting findEarliestMeeting(List<Meeting> meetings) {
		Meeting tempMeeting = meetings.get(0);
		
		for(Meeting meeting : meetings) {
			
			if(meeting.endTime < tempMeeting.endTime)
				tempMeeting = meeting;
			else if(meeting.endTime == tempMeeting.endTime) {			
				if(meeting.startTime < tempMeeting.startTime)
					tempMeeting = meeting;
			}
		}
		
		return tempMeeting;
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
			
			List<Meeting> meetings = new LinkedList<>();
			
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
			int meetingCount = 0;
			
			// list가 비어있을 때 까지 반복합니다.
			while(!meetings.isEmpty())
			{
				Meeting tempMeeting = findEarliestMeeting(meetings);			
				
				++meetingCount;
				deleteEarlyStartTime(meetings,tempMeeting.endTime);				
			}
			
			bw.write(Integer.toString(meetingCount));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
