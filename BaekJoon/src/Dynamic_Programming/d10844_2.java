package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d10844_2 {
	static Long nums[][];
	final static long MOD = 1000000000; 
	
	public static long dp(int num, int digit) {
		if(digit == 1)
			return nums[num][1];
		
		if(nums[num][digit] == null) {
			// 자리수가 0으로 시작하면 다음 자리수는 1밖에 올 수 없습니다.
			if(num == 0)
				nums[0][digit] = dp(1, digit - 1);
			// 자리수가 9으로 시작하면 다음 자리수는 8밖에 올 수 없습니다.
			else if(num == 9)
				nums[9][digit] = dp(8, digit - 1);
			// 자리수가 1~8로 시작하면 1의 차이가나는 이전 자리수(n-1,n+1)의 합만큼 올 수 있습니다.
			else
				nums[num][digit] = dp(num - 1, digit - 1) + dp(num + 1, digit - 1);
		}
		
		return nums[num][digit] % MOD;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			nums = new Long[10][n+1];
			
			// 자리수가 1개일 때, 0~9 로시작하는 자리수의 값을 넣어줍니다.
			// 이 때, 0으로 시작할 수 없지만 자리수가 2개 일 때 0을 이용하게 되므로 1을 넣어줍니다.
			for (int i = 0; i <= 9; i++) {
				nums[i][1] = 1L;
			}
			
			long result = 0;
			// 특정 숫자로 시작하는 n의 자리수의 경우의 수를 전부 더해줍니다.
			for (int i = 1; i <= 9; i++) {
				result += dp(i,n);
			}
			
			bw.write(Long.toString(result % MOD));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
