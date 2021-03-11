package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class g11047 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			// 코인 종류 개수와 가격을 입력받습니다.
			String coinTypeCountAndPrice = br.readLine().trim();
			
			// 공백을 기준으로 토큰으로 나눕니다.
			StringTokenizer stk = new StringTokenizer(coinTypeCountAndPrice);
			
			// 나눈 토큰 개수가 2개가 아니면 프로그램 종료(2개를 입력하지 않으면 종료)
			if(stk.countTokens() != 2)
				return;
			
			// 토큰을 가져와 변수에 담습니다.
			int coinTypeCount = Integer.parseInt(stk.nextToken());
			int price = Integer.parseInt(stk.nextToken());
			
			// 코인 종류 개수만큼 배열을 만들어 줍니다.
			int coin[] = new int[coinTypeCount];
			
			// 배열방에 값 입력
			for (int i = 0; i < coin.length; i++)
				coin[i] = Integer.parseInt(br.readLine().trim());
			
			// 배열방을 순회하기 위한 변수
			int i = coin.length - 1;
			// 가격을 형성하는데 필요한 총 코인 개수
			int totalCoinCount = 0;
			
			// 가격이 0이하가 될 때 까지 루프를 돕니다.
			// "가격/코인종류" 로 나온 몫으로 코인 개수를 판단하고 가격에 코인개수*코인종류를 빼줍니다.
			while(price > 0) {
				int quotient = price / coin[i];
				if(quotient != 0) {
					price -= (coin[i] * quotient);
					totalCoinCount += quotient;
				}
				--i;
			}
			
			bw.write(Integer.toString(totalCoinCount));
			bw.flush();
			bw.close();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
