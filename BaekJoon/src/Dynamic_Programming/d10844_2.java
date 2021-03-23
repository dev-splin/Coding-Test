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
			// �ڸ����� 0���� �����ϸ� ���� �ڸ����� 1�ۿ� �� �� �����ϴ�.
			if(num == 0)
				nums[0][digit] = dp(1, digit - 1);
			// �ڸ����� 9���� �����ϸ� ���� �ڸ����� 8�ۿ� �� �� �����ϴ�.
			else if(num == 9)
				nums[9][digit] = dp(8, digit - 1);
			// �ڸ����� 1~8�� �����ϸ� 1�� ���̰����� ���� �ڸ���(n-1,n+1)�� �ո�ŭ �� �� �ֽ��ϴ�.
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
			
			// �ڸ����� 1���� ��, 0~9 �ν����ϴ� �ڸ����� ���� �־��ݴϴ�.
			// �� ��, 0���� ������ �� ������ �ڸ����� 2�� �� �� 0�� �̿��ϰ� �ǹǷ� 1�� �־��ݴϴ�.
			for (int i = 0; i <= 9; i++) {
				nums[i][1] = 1L;
			}
			
			long result = 0;
			// Ư�� ���ڷ� �����ϴ� n�� �ڸ����� ����� ���� ���� �����ݴϴ�.
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
