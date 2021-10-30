package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class nhn2 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < t; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(stk.nextToken());
				int m = Integer.parseInt(stk.nextToken());
				
				stk = new StringTokenizer(br.readLine());
				
				HashSet<Integer> set = new HashSet<>();
				
				for (int j = 1; j <= n; j++) {
					int num = Integer.parseInt(stk.nextToken());
					
					if(!set.contains(num))
						set.add(num);
					
					if(set.size() >= m) {
						sb.append(j).append('\n');
						break;
					}
				}
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
