package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class g1541_2 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String equation = br.readLine().trim();
			StringTokenizer minusStk = new StringTokenizer(equation,"-");
			
			int sum = 0;
			boolean firstToken = true;
			
			// '-'를 기준으로 나눈 토큰을 순회면서 나눈 토큰을 '+' 로 또 나누고 '+'로 나눈 토큰들을 임시합계에 더해줍니다.
			// '-'로 나누었을 때, 첫번 째 토큰이면 "총 합계 += 임시합계", 다른 토큰이면 "총 합계 -= 임시합계". 즉, "첫 번째 토큰 - 나머지 토큰"이 됩니다. 
			while(minusStk.hasMoreTokens()) {
				int tempsum = 0;
				StringTokenizer plusStk1 = new StringTokenizer(minusStk.nextToken(),"+");
				
				while(plusStk1.hasMoreTokens()) {
					int num = Integer.parseInt(plusStk1.nextToken());
					
					tempsum += num;
				}
				
				if(firstToken) {
					sum += tempsum;
					firstToken = false;
				}
				else
					sum -= tempsum;
			}
			
			bw.write(Integer.toString(sum));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
