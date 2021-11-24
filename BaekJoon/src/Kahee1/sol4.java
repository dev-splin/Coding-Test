package Kahee1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol4 {
	
	public static class Log {
		int year;
		int month;
		int day;
		int time;
		int minute;
		int second;
		
		public Log(int year, int month, int day, int time, int minute, int second) {
			this.year = year;
			this.month = month;
			this.day = day;
			this.time = time;
			this.minute = minute;
			this.second = second;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int q = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
