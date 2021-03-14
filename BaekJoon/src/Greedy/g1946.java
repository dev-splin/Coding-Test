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
				// �����ڸ� ������ �迭(�ε����� �������)
				int applicants[] = new int[n]; 
				
				// [���� ��� �ε���]�� ��������� �����մϴ�.
				for (int j = 0; j < n; j++) {
					String grades = br.readLine().trim();
					StringTokenizer stk = new StringTokenizer(grades);
					
					int documentGrade = Integer.parseInt(stk.nextToken());
					int interviewGrade = Integer.parseInt(stk.nextToken());
					
					applicants[documentGrade-1] = interviewGrade;
				}
				
				// ���� 1���� ������ �հ��̱� ������ ���� 1���� ��������� ���� ��������� ����ϴ�.
				int cmpInterview = applicants[0];
				// ���� 1���հ��� �ֱ� ������ 1�� �ʱ�ȭ ���ݴϴ�. 
				int newRecruitCount = 1;
				
				// cmpInterview ��������� ���ؼ� �ش� �ε���(�������)�� ��������� �� ������ cmpInterview�� ��ü���ְ�
				// �հ��ڼ��� �÷��ݴϴ�.
				for (int j = 1; j < applicants.length; j++) {
					if(cmpInterview > applicants[j]) {
						cmpInterview = applicants[j];
						++newRecruitCount;
					}
				}
				
				newRecruitNums[i] = newRecruitCount;
			}
			
			// �հ��� �� ���
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
