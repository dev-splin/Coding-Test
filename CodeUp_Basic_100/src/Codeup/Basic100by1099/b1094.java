package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class b1094 {
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
			
			// list를 거꾸로 변환합니다.
			Collections.reverse(calledNum);
			
			for(int num : calledNum)
				bw.write(Integer.toString(num) + " ");
		
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

