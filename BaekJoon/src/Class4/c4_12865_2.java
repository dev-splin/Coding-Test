package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_12865_2 {
	static int memo[][];
	static int w[];
	static int v[];
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			w = new int[n+1];
			v = new int[n+1];
			memo = new int[n+1][k+1];
			
			for (int i = 1; i <= n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				w[i] = Integer.parseInt(stk.nextToken());
				v[i] = Integer.parseInt(stk.nextToken());
			}
			
			// 처음 부터 순회하면서 memo에 값을 넣어줍니다.
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= k; j++) {
					// j가 i번의 물건의 무게보다 작으면 i 이전의 물건 중 최대값인 memo[i-1][j]가 들어가게 됩니다.
					if(w[i] > j)
						memo[i][j] = memo[i-1][j];
					// j가 i번의 물건의 무게보다 크거나 같으면 i 이전의 물건 중 최대값인 memo[i-1][j]와
					// j에서 물건의 무게(w)를 뺀 i 이전의 물건 중 최대값인 memo[i-1][j-w[i]], 물건의 가치 v[i]를 더한 값 중 큰 값을 넣습니다.
					else
						memo[i][j] = Math.max(memo[i-1][j], memo[i-1][j-w[i]] + v[i]);
				}
			}
			
			System.out.println(memo[n][k]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
