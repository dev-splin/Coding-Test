package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class c2_2775 {
	static int apart[][];
	
	public static int dp(int k, int n) {
		if(k <= 0)
			return apart[k][n];
		
		if(apart[k][n] == 0) {
			for (int i = 1; i <= n; i++)
				apart[k][n] += dp(k-1,i);
		}
		
		return apart[k][n];
		
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		StringBuilder sb = new StringBuilder();
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				int k = Integer.parseInt(br.readLine());
				int n = Integer.parseInt(br.readLine());
				
				apart = new int[k+1][n+1];
				
				for (int j = 1; j <= n; j++) 
					apart[0][j] = j;
				
				System.out.println(dp(k,n));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}