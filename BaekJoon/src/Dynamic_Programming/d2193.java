package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class d2193 {
	static BigInteger memo[];
	
	public static BigInteger dp(int n) {
		if(n <= 0)
			return memo[0];
		
		if(n <= 2)
			return memo[n];
		
		if(memo[n] == null) 
			memo[n] = dp(n-1).add(dp(n-2));
		
		return memo[n];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			memo = new BigInteger[n+1];
			memo[0] = BigInteger.ZERO;
			memo[1] = BigInteger.ONE;
			if(n >= 2)
				memo[2] = BigInteger.ONE;
			
			bw.write(dp(n).toString());
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}