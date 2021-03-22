package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d2156 {
	static Integer memo[];
	static int wine[];
	
	public static int dp(int n) {
		// n < 3�� ��� �ε����� -�� �Ǵ� ���� �������ݴϴ�.
		if(n <= 0)
			return 0;
		
		if(memo[n] == null) {
			memo[n] = Math.max(wine[n] + wine[n-1] + dp(n-3), Math.max(dp(n-1), wine[n] + dp(n-2)));
		}
		
		return memo[n];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			wine = new int[n+1];
			memo = new Integer[n+1];
			
			for (int i = 1; i <= n ; i++) {
				wine[i] = Integer.parseInt(br.readLine().trim());
			}
			
			// 1���� ���� 2���� ����� �ִ� ���� ���� ������ �� �����Ƿ� ���� ������ݴϴ�.
			memo[1] = wine[1];
			if(n >= 2)
			memo[2] = wine[1] + wine[2];
			
			bw.write(Integer.toString(dp(n)));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
