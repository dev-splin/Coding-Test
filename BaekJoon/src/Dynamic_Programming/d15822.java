package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class d15822 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	static int wave[][];
	static Integer memo[][];
	static int n;
	final static int INF = Integer.MAX_VALUE;
	
	public static void makeWave() throws Exception{
		n = Integer.parseInt(br.readLine());
		
		memo = new Integer[n+1][n+1];
		wave = new int[2][n+1];
		
		for (int i = 0; i < 2; i++) {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			
			for (int j = 1; j <= n; j++)
				wave[i][j] = Integer.parseInt(stk.nextToken());
		}
		
		memo[1][1] = (int)Math.pow(wave[0][1] - wave[1][1],2);
	}
	
	public static int dp(int n, int m) {
		if(n <= 0 || m <= 0)
			return INF;
		
		if(memo[n][m] == null) {
			memo[n][m] = Math.min(dp(n-1,m-1),Math.min(dp(n-1,m), dp(n,m-1))) +
					(int)Math.pow(wave[0][n] - wave[1][m],2);
		}
		
		return memo[n][m];
	}
	
	public static void main(String[] args) {
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			makeWave();
			
			System.out.println(dp(n,n));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
