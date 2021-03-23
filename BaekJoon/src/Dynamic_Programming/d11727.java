package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d11727 {
	static int memo[];
	
	public static int dp(int n) {
		
		if(memo[n] == 0) {
			memo[n] = dp(n-1) + dp(n-2) * 2;
		}
		
		return memo[n] % 10007;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			memo = new int[n+1];
			
			memo[1] = 1;
			if(n >= 2)
				memo[2] = 3;
			
			bw.write(Integer.toString(dp(n) % 10007));			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}