package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class c4_17070_2 {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int arr[][] = new int[n+1][n+1];
			int dp[][][] = new int [n+1][n+1][3];
			
			for (int i = 1; i <= n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++)
					arr[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			dp[1][2][0] = 1;
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(arr[i][j] == 1)
						continue;
					
					dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
					dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
					
					if(arr[i-1][j] == 0 && arr[i][j-1] == 0)
						dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				}
			}
			
			int sum = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
			
			System.out.println(sum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

