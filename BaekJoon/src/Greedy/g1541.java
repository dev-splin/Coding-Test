package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class g1541 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String equation = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(equation,"+-",true);
			
			List<Integer> nums = new ArrayList<>();
			List<Character> signs = new ArrayList<>();
			
			// '+'와 '-'로 나눈 토큰을 순회하여 토큰을 Object객체로 받고
			// try catch를 이용해 int형으로 형변환이 가능하면 int로 바꾸고 아니면 char형으로 바꿉니다. 
			while(stk.hasMoreElements()) {
				Object numOrSign = stk.nextElement();
				try {
					int num = Integer.parseInt((String)numOrSign);
					nums.add(num);
				} catch (NumberFormatException e) {
					char sign = numOrSign.toString().charAt(0);
					signs.add(sign);
				}
			}
			
			int tempsum = 0;
			int sum = nums.get(0);
			boolean meetMinus = false;
			
			// 저장한 숫자리스트룰 순회하며 '-'를 만나기 전까지의 값은 총 합계에 더해주고
			// -를 만난뒤의 값은 임시합계에 다 더해준다음 "총합계 - 임시합계"를 합니다.
			for (int i = 1; i < nums.size(); i++) {
				if(signs.get(i-1) == '-')
					meetMinus = true;
				
				if(meetMinus)
					tempsum += nums.get(i);
				else 
					sum += nums.get(i);
			}
			sum -= tempsum;
			
			bw.write(Integer.toString(sum));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
