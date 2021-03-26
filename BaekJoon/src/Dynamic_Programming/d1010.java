package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class d1010 {
	static int memo[][] = new int[30][30];
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine().trim());
			
			// 1-> i는 i만큼 만들 수 있으니 i로 초기화 해줍니다.
			for (int i = 1; i <= 29; i++)
				memo[1][i] = i;
						
			for (int i = 0; i < t; i++) {
				String nums = br.readLine();
				StringTokenizer stk = new StringTokenizer(nums);
				
				int n = Integer.parseInt(stk.nextToken());
				int m = Integer.parseInt(stk.nextToken());
				
				// 경우의 수를 구합니다.
				for (int j = 2; j <= n; j++) {
					for (int k = j; k <= m; k++) {
						// memo에 이미 값이 있다면 건너뜁니다.
						if(memo[j][k] > 0)
							continue;
						
						// j == k의 경우의 수는 1개 밖에 없습니다.
						if(j == k)
							memo[j][k] = 1;
						else
							memo[j][k] = memo[j-1][k-1] + memo[j][k-1];
					}
				}
				
				System.out.println(memo[n][m]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}