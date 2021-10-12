package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class g14916 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			
			int n = Integer.parseInt(br.readLine());
			
			int twoCoin = 0;
			int fiveCoin = 0;
			
			while(n > 0) {
				if(n % 5 == 0) {
					fiveCoin = n / 5;
					n = 0;
				}
				else {
					n -= 2;
					++twoCoin;
				}
			}
			
			if(n < 0)
				System.out.println(-1);
			else
				System.out.println(twoCoin + fiveCoin);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
