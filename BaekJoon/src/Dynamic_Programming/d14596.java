package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class d14596 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	static int b1[][];
	static int b2[][];
	static int b3[][];
	static Integer memo[][];
	static int h,w;
	
	public static void makeImage() throws Exception{
		String nums = br.readLine();
		StringTokenizer stk = new StringTokenizer(nums);
		
		h = Integer.parseInt(stk.nextToken());
		w = Integer.parseInt(stk.nextToken());
		
		b1 = new int[h][w];
		b2 = new int[h][w];
		b3 = new int[h][w];
		memo = new Integer[h][w];
		
		for (int i = 0; i < h; i++) {
			nums = br.readLine();
			stk = new StringTokenizer(nums);
			
			for (int j = 0; j < w; j++) { 
				b1[i][j] = Integer.parseInt(stk.nextToken());
				b3[i][j] = b1[i][j];
			}
		}
		
		for (int i = 0; i < h; i++) {
			nums = br.readLine();
			stk = new StringTokenizer(nums);
			
			for (int j = 0; j < w; j++) { 
				b2[i][j] = Integer.parseInt(stk.nextToken());
				b3[i][j] -= b2[i][j];
				b3[i][j] = b3[i][j] * b3[i][j];
				
				if(i == h - 1) {
					memo[i][j] = b3[i][j];
				}
			}
		}
	}
	
	public static int dp(int n, int m) {
		if(n >= h)
			return 0;
		
		if(m < 0)
			m = 0;
		else if(m >= w)
			m = w - 1;
		
		if(memo[n][m] == null) {
			memo[n][m] = Math.min(dp(n+1,m-1), Math.min(dp(n+1,m), dp(n+1,m+1))) + b3[n][m];
		}
		
		return memo[n][m];
	}
	
	public static void main(String[] args) {
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			makeImage();
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < w; i++) {
				int num = dp(0,i);
				
				if(num < min)
					min = num;
			}
			
			System.out.println(min);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
