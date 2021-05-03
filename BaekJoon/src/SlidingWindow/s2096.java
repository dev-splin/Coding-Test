package SlidingWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2096 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int result[][] = new int[3][2];
			int arr[][] = new int[3][2];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < 3; j++) {
					arr[j][0] = Integer.parseInt(stk.nextToken());
					arr[j][1] = arr[j][0];
					
					arr[j][0] += Math.min(result[1][0],(j==1)?Math.min(result[0][0], result[2][0]):result[j][0]);
					arr[j][1] += Math.max(result[1][1],(j==1)?Math.max(result[0][1], result[2][1]):result[j][1]);
				}
				
				for (int j = 0; j < 3; j++) {
					result[j][0] = arr[j][0];
					result[j][1] = arr[j][1];
				}
			}
			
			int max = Math.max(result[0][1], Math.max(result[1][1], result[2][1]));
			int min = Math.min(result[0][0], Math.min(result[1][0], result[2][0]));
			
			System.out.println(max + " " + min);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

