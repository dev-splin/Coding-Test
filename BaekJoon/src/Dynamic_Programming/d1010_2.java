package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d1010_2 {
	static int memo[][] = new int[30][30];
	
	// 조합 공식을 이용해 경우의 수를 찾습니다. 
	public static int dp(int n, int r) {
				
		// 조합 공식의 성질 2
		if(n == r || r == 0)
			return memo[n][r] = 1;
		
		// 조합 공식의 성질 1
		if(memo[n][r] == 0)
			return memo[n][r] = dp(n-1,r-1) + dp(n-1,r);
		
		return memo[n][r];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine().trim());
			
			for (int i = 0; i < t; i++) {
				String nums = br.readLine();
				StringTokenizer stk = new StringTokenizer(nums);
				
				int n = Integer.parseInt(stk.nextToken());
				int m = Integer.parseInt(stk.nextToken());
				
				System.out.println(dp(m,n));
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}