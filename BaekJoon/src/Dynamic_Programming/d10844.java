package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class d10844 {
	static BigInteger nums[][];
	static BigInteger stairs[];
	
	public static BigInteger dp(int n) {
		
		
		if(stairs[n] == null) {
			stairs[n] = BigInteger.ZERO;
			
			for (int i = 1; i <= 9; i++) {
				if(i == 1) {
					nums[i][n] = nums[i][n-2].add(nums[i+1][n-1]);
					stairs[n] = stairs[n].add(nums[i][n]);
					continue;
				}
				
				if(i == 9) {
					nums[i][n] = nums[i-1][n-1];
					stairs[n] = stairs[n].add(nums[i][n]);
					continue;
				}
				
				nums[i][n] = nums[i-1][n-1].add(nums[i+1][n-1]); 
				stairs[n] = stairs[n].add(nums[i][n]);
			}
		}
		
		stairs[n] = stairs[n].mod(new BigInteger("1000000000"));
		
		return stairs[n];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			nums = new BigInteger[10][n+1];
			stairs = new BigInteger[n+1];
			
			for (int i = 1; i <= 9; i++) {
				nums[i][1] = BigInteger.ONE;
			}
			
			if(n >= 2) {
				for (int i = 1; i <= 9; i++) {
					nums[i][2] = BigInteger.TWO;
					
					if(i == 9)
						nums[i][2] = BigInteger.ONE;
				}
				stairs[2] = new BigInteger("17");
			}
			
			stairs[1] = new BigInteger("9");
			
			
			for (int i = 1; i <= n; i++) {
				dp(i);
			}
			
			bw.write(stairs[n].toString());
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
