package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class d1932 {
	static Integer triangle[][];
	static Integer memo[][];
	static int n;
	
	public static int dp(int row, int col) {
		
		if(memo[row][col] == null) {
			memo[row][col] = Math.max(dp(row+1,col),dp(row+1,col+1)) + triangle[row][col];
		}
		
		return memo[row][col];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			n = Integer.parseInt(br.readLine().trim());
			
			triangle = new Integer[n+1][n+1];
			memo = new Integer[n+1][n+1];
			
			for (int i = 1; i <= n; i++) {
				String nums = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(nums);
				for (int j = 1; j <= i; j++) {
					triangle[i][j] = Integer.parseInt(stk.nextToken());
					
					if(i == n)
						memo[i][j] = triangle[i][j];
				}
			}
			
			bw.write(Integer.toString(dp(1,1)));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
