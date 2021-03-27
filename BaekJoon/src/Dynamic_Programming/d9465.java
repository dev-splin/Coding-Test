package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d9465 {
	static int scores[][];
	static int memo[][];
		
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				
				scores = new int [3][n+1];
				memo = new int [3][n+1];
				
				for (int j = 1; j <= 2; j++) {
					String nums = br.readLine();
					StringTokenizer stk = new StringTokenizer(nums);
					
					for (int k = 1; k <= n; k++) {
						scores[j][k] = Integer.parseInt(stk.nextToken());
						memo[j][k] = scores[j][k];
					}
				}
								
				for (int j = 2; j <= n; j++) {
					memo[1][j] += Math.max(memo[2][j-1], Math.max(memo[2][j-2], memo[1][j-2]));
					memo[2][j] += Math.max(memo[1][j-1], Math.max(memo[2][j-2], memo[1][j-2]));
				}
				
				int maxScore = 0;
				for (int j = 1; j <= n; j++) {
					if(maxScore < memo[1][j])
						maxScore = memo[1][j];
					if(maxScore < memo[2][j])
						maxScore = memo[2][j];
				}
				
				System.out.println(maxScore);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
