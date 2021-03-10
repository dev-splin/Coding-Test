package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;



public class g11399 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			// 범위를 벗어나면 프로그램 종료
			if(1 > n || 1000 < n)
				return;
			
			// 문자열을 입력받고
			String times = br.readLine().trim();
			// 공백 단위로 문자열을 토큰으로 쪼갠 후
			StringTokenizer stk = new StringTokenizer(times);
			
			// 토큰의 개수가 입력될 개수와 맞지 않으면 프로그램 종료
			if(stk.countTokens() != n)
				return;
			
			// 입력받은 수를 저장할 리스트
			List<Integer> list = new ArrayList<>();
			
			// 토큰이 있는 지 체크하고 있으면 정수로 변환 후 범위 체크를 해주고 list에 추가합니다.
			while(stk.hasMoreTokens())
			{
				int time = Integer.parseInt(stk.nextToken());
				if(time < 1 || time > 1000)
					return;
				list.add(time);				
			}
			
			// list 정렬합니다 ( 기본 오름차순)
			Collections.sort(list);
			
			// 최소 시간의 합을 저장할 변수
			int sum = 0;
			// 이전 출금의 시간을 저장할 변수
			int preNum = 0;
			
			// list를 순회하여 preNum에 현재 시간을 더한 후 그 더한 값을 sum에 더해 총 시간을 구해줍니다.
			for(int time : list)
			{
				preNum += time;
				sum += preNum;
			}
			
			// 출력
			bw.write(Integer.toString(sum));
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
