package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class c4_2407 {
	static BigInteger memo[][];
	
	public static BigInteger combi(int n, int m) {
		
		if(m == 0 || n == m)
			return memo[n][m] = BigInteger.ONE;
		
		if(memo[n][m] == null)
			memo[n][m] = combi(n-1, m).add(combi(n-1, m-1)); 
		
		return memo[n][m];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			memo = new BigInteger[n+1][m+1];
			
			System.out.println(combi(n, m).toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
