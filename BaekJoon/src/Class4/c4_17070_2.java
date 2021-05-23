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
			// dp[행][열][방향] 방향 0 = 가로, 1 = 세로, 2 = 대각선
			int dp[][][] = new int [n+1][n+1][3];
			
			for (int i = 1; i <= n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++)
					arr[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			// 처음 파이프 끝의 위치에 값을 넣어줍니다. (1행 2열에 올 수 있는 경우의 수)
			dp[1][2][0] = 1;
			
			// n,n까지 순회하기 때문에 따로 arr범위를 넘어가는지 체크해주지 않아도 됩니다.
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(arr[i][j] == 1)
						continue;
					
					// 가로
					dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
					// 세로
					dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
					
					// 현재 방향이 대각선이면, 현재 위치의 위(i-1,j)와 왼쪽(i,j-1)에 벽이 없는지 체크해야 합니다.
					if(arr[i-1][j] == 0 && arr[i][j-1] == 0)
						dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				}
			}
			
			// 모든 방향의 경우의 수를 더해 답을 구합니다.
			int sum = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
			
			System.out.println(sum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

