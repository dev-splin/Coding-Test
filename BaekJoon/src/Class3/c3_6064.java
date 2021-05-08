package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c3_6064 {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(stk.nextToken());
				int n = Integer.parseInt(stk.nextToken());
				int x = Integer.parseInt(stk.nextToken()) - 1;
				int y = Integer.parseInt(stk.nextToken()) - 1;
				
				boolean isPossible = false;
				
				for (int j = x; j < m * n; j += m) {
					if(j % n == y) {
						isPossible = true;
						sb.append(j + 1).append("\n");
						break;
					}
				}
				
				if(!isPossible)
					sb.append("-1\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}