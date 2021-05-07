package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c3_1676 {
		
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int twoCount = 0;
			int fiveCount = 0;
			
			for (int i = 1; i <= n; i++) {
				
				int divideNum = 2;
				int num = i;
				while(num != 1) {
					if(num % divideNum == 0) {
						if(divideNum == 2)
							++twoCount;
						else if(divideNum == 5)
							++fiveCount;
						
						num /= divideNum;
						divideNum = 2;
					} else
						++divideNum;
				}
			}
			
			int count = Math.min(twoCount, fiveCount);

			System.out.println(count);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}