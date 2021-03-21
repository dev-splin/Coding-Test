package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class d1149 {
	static int house[][];	// n행은 개수 열은 1부터 r,g,b를 나타냄
	static Integer memo[][];	// n행은 개수 열은 0은 최솟값 1은 색깔
	final static int R = 0;
	final static int G = 1;
	final static int B = 2;
	
	public static int dp(int n, int color) {
		if(n == 1) {
			return house[n][color];
		}
		
		if(memo[n][color] == null) {
			memo[n][color] = house[n][color] + Math.min(dp(n-1,(color + 1) % 3),dp(n-1,(color + 2) % 3));
//			if(color == R)
//				memo[n][color] = house[n][color] + Math.min(dp(n-1,G),dp(n-1,B));
//			else if(color == G)
//				memo[n][color] = house[n][color] + Math.min(dp(n-1,R),dp(n-1,B));
//			else
//				memo[n][color] = house[n][color] + Math.min(dp(n-1,R),dp(n-1,G));
		}
		
		return memo[n][color];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			house = new int[n+1][4];
			memo = new Integer[n+1][4];
			
			for (int i = 1; i < house.length; i++) {
				String costs = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(costs);
				
				house[i][R] = Integer.parseInt(stk.nextToken());
				house[i][G] = Integer.parseInt(stk.nextToken());
				house[i][B] = Integer.parseInt(stk.nextToken());
			}
			
			int result = Math.min(dp(n, R),Math.min(dp(n, G), dp(n, B)));
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
