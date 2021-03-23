package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class d1912 {
	static int sequences[];
	static int memo[];
	static int maxNum = -1000;
	
	public static int dp(int n) {
		if(n <= 0)
			return 0;
		
		if(memo[n] == 0) {
			
			memo[n] = Math.max(sequences[n], dp(n-1) + sequences[n]);
			
			maxNum = Math.max(memo[n], maxNum);
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
			
			sequences = new int[n+1];
			memo = new int[n+1];
			memo[0] = 0;
			
			String nums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nums);
			
			int count = stk.countTokens();
			 
			for (int i = 1; i <= count; i++) 
				sequences[i] = Integer.parseInt(stk.nextToken());
			
			for (int i = 1; i <= count; i++)
				dp(i);
			
			bw.write(Integer.toString(maxNum));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
