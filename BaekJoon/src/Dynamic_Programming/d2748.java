package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class d2748 {
	static BigInteger memo[];
	
	public static BigInteger fibonacci(int n) {
		
		if(memo[n] == null) {
			memo[n] = fibonacci(n-1).add(fibonacci(n-2));
		}
		
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
			if(n >= 1)
				memo[1] = BigInteger.ONE;
			if(n >= 2)
				memo[2] = BigInteger.ONE;
			
			bw.write(fibonacci(n).toString());
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
