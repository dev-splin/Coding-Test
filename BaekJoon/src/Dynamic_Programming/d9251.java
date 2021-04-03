package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d9251 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String a = br.readLine();
			String b = br.readLine();
			
			int n = a.length();
			int m = b.length();

			int memo[][] = new int[n+1][m+1];
			
			// [1][1]부터 하나씩 채워나갑니다.
			for (int i = 1; i <= n; i++) {
				
				for (int j = 1; j <= m; j++) {
					// 문자가 같게되면 대각선 왼쪽 값에서 +1
					if(b.charAt(j-1) == a.charAt(i-1))
						memo[i][j] = memo[i-1][j-1] + 1;
					// 같지 않으면 행-1 과 열-1 즉, 위와 왼쪽 중 비교해 최대값을 구합니다.
					else
						memo[i][j] = Math.max(memo[i][j-1], memo[i-1][j]);
				}
			}
			
			System.out.println(memo[n][m]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
