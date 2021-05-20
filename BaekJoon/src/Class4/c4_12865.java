package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c4_12865 {
	static Integer memo[][];
	static int w[];
	static int v[];
	
	// 재귀를 이용한 하향식
	public static int dp(int i, int k) {
		if(i < 0)
			return 0;
		
		if(memo[i][k] == null) {
			// k가 i번의 물건의 무게보다 작으면 i 이전의 물건 중 최대값인 dp(i-1,k)이 들어가게 됩니다.
			if(w[i] > k)
				memo[i][k] = dp(i-1,k);
			// k가 i번의 물건의 무게보다 크거나 같으면 i 이전의 물건 중 최대값인 dp(i-1,k)와
			// k에서 물건의 무게(w)를 뺀 i 이전의 물건 중 최대값인 dp(i-1, k-w[i])와 물건의 가치 v[i]를 더한 값 중 큰 값을 넣습니다.
			else
				memo[i][k] = Math.max(dp(i-1, k), dp(i-1, k-w[i]) + v[i]);
		}
		
		return memo[i][k];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			w = new int[n+1];
			v = new int[n+1];
			memo = new Integer[n+1][k+1];
			
			for (int i = 1; i <= n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				w[i] = Integer.parseInt(stk.nextToken());
				v[i] = Integer.parseInt(stk.nextToken());
			}
			
			System.out.println(dp(n,k));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
