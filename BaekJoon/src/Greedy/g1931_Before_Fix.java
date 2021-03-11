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
	// Meeting(ȸ��) Ŭ����, ���۽ð���, ����ð��� �����ϴ�.
	public static class Meeting {
		int startTime;
		int endTime;
		
		public Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	
	// list�� endTime(����ð�)�� ���ڷ� �޾� ����Ʈ �߿� ���� �ð� ���� ���� �ð��� ���۽ð��� ���� ȸ��(Meeting)�� �����մϴ�.
	// ���� ���, 1~4 ȸ�� �ð��� ���� ������ 1~3�� ���۽ð��� ������ �ִ� ȸ�ǵ��� ��ġ�� �� ���� �����Դϴ�. 
	public static void deleteEarlyStartTime(List<Meeting> meetings, int endTime) {
		
		Iterator<Meeting> iter = meetings.iterator();
		
		while (iter.hasNext()) {
			if(iter.next().startTime < endTime) {
				iter.remove();
			}
		}
	}
	
	// list�� ��ü�� �߿� ���� �տ� ��ġ�� �� �ִ� ȸ�Ǹ� ã�� ��ȯ���ݴϴ�.
	// ���� �ð��� ���� ã���ִµ�, ���� �ð��� ���ٸ� ���� �ð��� �� ���� ��ü�� ã���ϴ�.
	// ���۽ð��� �� ���� ��ü�� ã�� ������ ���� 5~6�� 6~6�� ���� �� ���۽ð��� �� �� 6~6�� ���� ã�� �Ǹ� 5~6�� �ǳʶٱ� �����Դϴ�.
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
			
			// list�� ������� �� ���� �ݺ��մϴ�.
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
