package Kahee1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sol4 {
	static String logs[];
	static int dp[][];
	static int n; 
	
	public static class Log {
		int date;
		
		public Log(int date) {
			this.date = date;
		}
	}
	
	public static String makeDateTime(String str) {
		String dateTime = "";
		
		StringTokenizer stk = new StringTokenizer(str);
		
		String date = stk.nextToken();
		String time = stk.nextToken();
		
		stk = new StringTokenizer(date, "-");
		while(stk.hasMoreTokens())
			dateTime += stk.nextToken();
		
		stk = new StringTokenizer(time, ":");
		while(stk.hasMoreTokens())
			dateTime += stk.nextToken();
		
		return dateTime;
	}
	
	public static int getCount(int level, String start, String end) {
		
		int startIndex = findStart(1, n+1, start);
		int endIndex = findEnd(1, n+1, end);
		
		return dp[endIndex-1][level] - dp[startIndex-1][level];
	}
	
	public static int findStart(int start, int end, String findStr) {
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(findStr.compareTo(logs[mid]) <= 0)
				end = mid;
			else
				start = mid + 1;
		}
		
		return start;
	}
	
	public static int findEnd(int start, int end, String findStr) {
			
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(findStr.compareTo(logs[mid]) >= 0)
				start = mid + 1;
			else
				end = mid;
		}
		
		return start;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			int q = Integer.parseInt(stk.nextToken());
			
			logs = new String[n+2];
			dp = new int[n+1][7];
			
			for (int i = 1; i <= n; i++) {
				stk = new StringTokenizer(br.readLine(), "#");
				
				String str = stk.nextToken();
				int level = Integer.parseInt(stk.nextToken());
				
				String dateTime = makeDateTime(str);
				
				logs[i] = dateTime;
				
				for (int j = level; j >= 1; --j) {
					++dp[i][j];
				}
			}
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= 6; j++) {
					dp[i][j] += dp[i-1][j];
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < q; i++) {
				stk = new StringTokenizer(br.readLine(), "#");
				
				String startStr = makeDateTime(stk.nextToken());
				String endStr = makeDateTime(stk.nextToken());
				int level = Integer.parseInt(stk.nextToken());
				
				int count = getCount(level, startStr, endStr);
				
				sb.append(count).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
