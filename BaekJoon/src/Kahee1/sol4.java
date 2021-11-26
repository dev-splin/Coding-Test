package Kahee1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sol4 {
	static ArrayList<String> list[];
	
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
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int q = Integer.parseInt(stk.nextToken());
			
			list = new ArrayList[7];
			
			for (int i = 1; i <= 6; i++)
				list[i] = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine(), "#");
				
				String str = stk.nextToken();
				int level = Integer.parseInt(stk.nextToken());
				
				String dateTime = makeDateTime(str);
				
				list[level].add(dateTime);
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < q; i++) {
				stk = new StringTokenizer(br.readLine(), "#");
				
				String startStr = stk.nextToken();
				String endStr = stk.nextToken();
				int level = Integer.parseInt(stk.nextToken());
				
				int sum = 0;
				
				for (int j = level; j <= 6; j++) {
					
				}
				
				sb.append(sum).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
