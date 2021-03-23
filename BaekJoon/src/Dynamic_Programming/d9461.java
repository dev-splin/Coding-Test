package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class d9461 {
	static BigInteger memo[];
	
	public static BigInteger dp(int n) {
		
		if(memo[n] == null) {
			memo[n] = dp(n-2).add(dp(n-3));
		}
		
		return memo[n];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int t = Integer.parseInt(br.readLine().trim());
			
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine().trim());
				
				memo = new BigInteger[n+1];
				
				memo[1] = BigInteger.ONE;
				if(n >= 2)
					memo[2] = BigInteger.ONE;
				if(n >= 3)
					memo[3] = BigInteger.ONE;
				
				bw.write(dp(n).toString());
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
