package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1043 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String strNums = br.readLine();
			
			StringTokenizer stk = new StringTokenizer(strNums);
			
			List<Integer> nums = new ArrayList<Integer>();
			// 정수를 받기 위한 리스트
			
			while (stk.hasMoreTokens()) {
				int num = Integer.parseInt(stk.nextToken());
				
				if(num < 0)
					return;
				// 숫자가 0보다 작으면 프로그램을 종료해줍니다.
				
				nums.add(num);				
			}
			
			int result = nums.get(0) % nums.get(1);
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
