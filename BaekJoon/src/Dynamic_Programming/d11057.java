package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class d11057 {
	static BigInteger memo[];
	
	public static BigInteger factorial(int n) {
		if(n <= 1)
			return BigInteger.ONE;
		
		if(memo[n] == null) {
			BigInteger num = new BigInteger(Integer.toString(n));
			memo[n] = num.multiply(factorial(n-1));
		}
		
		return memo[n];
	}
	
	public static BigInteger dp(int n, int r) {
		
		return factorial(n+r-1).divide((factorial(r).multiply(factorial(n-1))));
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			memo = new BigInteger[10+n];
			
			System.out.println(dp(10,n).mod(new BigInteger("10007")).toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

