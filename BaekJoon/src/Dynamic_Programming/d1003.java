package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d1003 {
	static int zero[];
	static int one[];
	
	public static int fibonacci(int[] memo,int n) {
		if(n == 1) {
			return memo[n];
		}
		
		if(n == 0) {
			return memo[n];
		}
		
		if(memo[n] == 0) {
			memo[n] = fibonacci(memo, n-1) + fibonacci(memo, n-2);
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
				
				zero = new int[n+1];
				one = new int[n+1];
				
				zero[0] = 1;
				one[0] = 0;
				
				if(n >= 1) {
					zero[1] = 0;
					one[1] = 1;
				}
				
				int zeroCount = fibonacci(zero, n);
				int oneCount = fibonacci(one, n);
				
				bw.write(Integer.toString(zeroCount) + " ");
				bw.write(Integer.toString(oneCount));
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

