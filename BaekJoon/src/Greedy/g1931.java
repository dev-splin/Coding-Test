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
			
			// ���ٽİ� comprator�� �̿��Ͽ� endTime �������� �������� ���� �մϴ�.
			// �� ��, endTime�� ������ startTime�� �� ����(����) ȸ�Ǹ� �տ� �Ӵϴ�.
			Collections.sort(meetings,(meeting1,meeting2b)->{
				if(meeting1.endTime == meeting2b.endTime)
					return meeting1.startTime - meeting2b.startTime;
				return meeting1.endTime - meeting2b.endTime;
			});
			
			int meetingCount = 0;
			int prevEndTime = 0;
			
			// ����Ʈ�� ��ȸ�ϸ鼭 ��ġ�� ���� endTime ���Ŀ� ���۵Ǵ� ȸ�Ǹ� ���ϰ�
			// ��ġ�� �� ������ ���� endTime�� ��ġ �� ȸ���� endTime���� �ٲߴϴ�.
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
