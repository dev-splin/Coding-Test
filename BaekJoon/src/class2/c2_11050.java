package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c2_11050 {
	static int memo[][];
	
	public static int dp(int n, int k) {
		if(n == k || k == 0)
			return 1;
		
		if(memo[n][k] == 0) {
			memo[n][k] = dp(n-1,k-1) + dp(n-1, k);
		}
		
		return memo[n][k];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			memo = new int[n+1][k+1];
			
			System.out.println(dp(n,k));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

