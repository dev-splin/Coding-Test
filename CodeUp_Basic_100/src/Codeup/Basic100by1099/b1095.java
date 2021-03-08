package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class b1095 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			// 출석 번호를 부른 횟수
			int n = Integer.parseInt(br.readLine().trim());
			
			String nums = br.readLine().trim();
			
			StringTokenizer stk = new StringTokenizer(nums);
			
			// 무작위로 부른 번호의 개수와 처음 입력한 부른 횟수가 같지 않으면 프로그램 종료
			if(stk.countTokens() != n)
				return;
			
			// 불렸던 숫자를 저장할 리스트
			List<Integer> calledNum = new ArrayList<>(); 
			
			// 토큰을 가져와서 int형으로 변환후 list에 저장합니다.
			while(stk.hasMoreTokens())
			{
				int num = Integer.parseInt(stk.nextToken());
				
				calledNum.add(num);
			}
			
			// 일단 최소 숫자는 제일 처음 저장된 0번 인덱스의 값을 넣어놓습니다.
			int minNum = calledNum.get(0);

			// 최소 숫자와 list의 모든 숫자와 비교하여 제일 작은 숫자를 찾습니다.
			for(int num : calledNum)
				if(minNum > num)
					minNum = num;

			bw.write(Integer.toString(minNum));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

