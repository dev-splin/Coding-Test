package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class g1946 {
		
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int t = Integer.parseInt(br.readLine().trim());
			int newRecruitNums[] = new int[t];
			
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine().trim());	
				// 지원자를 저장할 배열(인덱스는 서류등수)
				int applicants[] = new int[n]; 
				
				// [서류 등수 인덱스]에 면접등수를 저장합니다.
				for (int j = 0; j < n; j++) {
					String grades = br.readLine().trim();
					StringTokenizer stk = new StringTokenizer(grades);
					
					int documentGrade = Integer.parseInt(stk.nextToken());
					int interviewGrade = Integer.parseInt(stk.nextToken());
					
					applicants[documentGrade-1] = interviewGrade;
				}
				
				// 서류 1등은 무조건 합격이기 때문에 서류 1등의 면접등수를 비교할 면접등수로 잡습니다.
				int cmpInterview = applicants[0];
				// 서류 1등합격이 있기 때문에 1로 초기화 해줍니다. 
				int newRecruitCount = 1;
				
				// cmpInterview 면접등수와 비교해서 해당 인덱스(서류등수)의 면접등수가 더 낮으면 cmpInterview를 교체해주고
				// 합격자수를 늘려줍니다.
				for (int j = 1; j < applicants.length; j++) {
					if(cmpInterview > applicants[j]) {
						cmpInterview = applicants[j];
						++newRecruitCount;
					}
				}
				
				newRecruitNums[i] = newRecruitCount;
			}
			
			// 합격자 수 출력
			for(int newRecruitNum : newRecruitNums) {
				bw.write(Integer.toString(newRecruitNum));
				bw.newLine();
			}
				
			bw.flush();
			bw.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
