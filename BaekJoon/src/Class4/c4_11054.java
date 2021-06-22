package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_11054 {
	static int n;
	static int num[];
	static int arr[][];
	static int memo[][];
	
	public static int DP(int status, int index) {
		
		if(memo[status][index] == 0) {
			memo[status][index] = 1;
			
			if(status == 0) {
				for (int i = index-1; i >= 1; --i) {
					if(num[i] < num[index])
						memo[status][index] = Math.max(memo[status][index], DP(status,i) + 1);
				}
			} else {
				for (int i = index+1; i <= n ; ++i) {
					if(num[i] < num[index])
						memo[status][index] = Math.max(memo[status][index], DP(status,i) + 1);
				}
			}
			
			
		}
		
		return memo[status][index];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			n = Integer.parseInt(br.readLine());
			
			num = new int[n+1];
			// 0 오름차순, 1 내림차순
			memo = new int[2][n+1];
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= n; i++)
				num[i] = Integer.parseInt(stk.nextToken());
			
			
			for (int i = 1; i <= n; i++) {
				DP(0,i);
				DP(1,i);
			}
			
			int ans = 0;
			for (int i = 1; i <= n; i++)
				ans = Math.max(ans, memo[0][i] + memo[1][i] - 1);
			
			System.out.println(ans);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
